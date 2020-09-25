package in.rafique.androidbasics.recyclerviews.ui.autoscroll;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class RVAdapter_Autoscroll extends RecyclerView.Adapter<RVAdapter_Autoscroll.RVHolder_Normal> {
    private static final String LOG_TAG = "RVAdapter_Normal => " ;
    Context context ;
    List<Object_FoodItem> lisOfItems ;

    public static int NO_OF_ITEMS = 1000 ;
    boolean newAutoScroll = true ;
    public static boolean pauseAutoScroll = false ;
    Runnable autoScrollRunnable ;

    public RVAdapter_Autoscroll(Context context, List<Object_FoodItem> listOfItems){
        this.context = context.getApplicationContext() ; //very important to use application context
        this.lisOfItems = listOfItems ;
    }


    @NonNull
    @Override
    public RVHolder_Normal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow_normal, parent, false) ;
        return new RVHolder_Normal(v) ;

    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder_Normal holder, int position) {
        if(lisOfItems.size()== 0){
            return;
        }

        Object_FoodItem currentItem = lisOfItems.get(position%lisOfItems.size()) ;
        Log.d(LOG_TAG, "Still Loggin and applying") ;
        Glide.with(context).load(currentItem.getImageId()).into(holder.itemImageView) ; //must use application context here, when using autoscroll
        holder.itemIdTextView.setText("" + currentItem.getId());
        holder.itemNameTextView.setText(currentItem.getName());
    }


    public void stopScrolling(RecyclerView rv){
        pauseAutoScroll = true ;
         boolean callbacksRemoved = rv.removeCallbacks(autoScrollRunnable) ; //  it doesn't really work, so that's why i am also calling pauseAutoscroll
        Log.d(LOG_TAG, "Removing Callbacks : " + callbacksRemoved) ;
    }


    @Override
    public int getItemCount() {
        return NO_OF_ITEMS;
    }


    public class RVHolder_Normal extends RecyclerView.ViewHolder{
        TextView itemNameTextView ;
        ImageView itemImageView ;
        TextView itemIdTextView ;

        public RVHolder_Normal(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemName);
            itemImageView = itemView.findViewById(R.id.singleRowNormal_ImageView_ItemImage) ;
            itemIdTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemId) ;
        }
    }




    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        // This method is Called by RecyclerView when it starts observing this Adapter.

        // Rather than calling the autoscroll method directly Autoscroll(recyclerView)
        // we call it by using a boolean,
        // Initialise the boolean to true. Call the method, and then set boolean to false
        // The reason we do this, is otherwise everytime the config changes, or onResume Occurs, or any recyclerView Change occurs
        // the autoscroll method will be called again, and since we use seperate threads in that method, we only want to call it once
        // hence this approach

        if (newAutoScroll == true){
            Autoscroll(recyclerView);
//            Toast.makeText(context, "Autoscroll is called", Toast.LENGTH_SHORT).show();
        }
        newAutoScroll = false ;


    }

    private void Autoscroll(final RecyclerView recyclerView) {
        // this list is autoscrolled by using this method
        // What is happening in this method is that  we are creating a new runnable thread
        // and in this thread after every 20 milli-seconds
        // we are scrolling the recyclerView by 1 pixel

        // To use this method, we needed a reference to the RecyclerView itself, which we pass as argument
        // We could have easily got that reference in the Parent-Activty, where we initialise the recyclerView
        // but we wanted to put all the code in the adapter so that's why we did it here


        final long totalScrollTime = Long.MAX_VALUE; //total scroll time. I think that 300 000 000 years is close enouth to infinity. if not enought you can restart timer in onFinish()

        final int scrollPeriod = 20; // every 20 ms scoll will happened. smaller values for smoother
        final int heightToScroll = 1; // will be scrolled to 20 px every time. smaller values for smoother scrolling

        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {

                recyclerView.scrollToPosition(NO_OF_ITEMS/2);
                new CountDownTimer(totalScrollTime, scrollPeriod) {
                    public void onTick(long millisUntilFinished) {
                        if(pauseAutoScroll == false){
                            // the reason we have this boolean pauseAutoscroll is so that
                            // we can use a button to change its value and pause the scrolling
                            recyclerView.scrollBy(0,heightToScroll);
                        }
                    }
                    public void onFinish() {
                        //you can add code for restarting timer here
                    }
                }.start();
            }

        } ;

        recyclerView.post(autoScrollRunnable);
    }
}
