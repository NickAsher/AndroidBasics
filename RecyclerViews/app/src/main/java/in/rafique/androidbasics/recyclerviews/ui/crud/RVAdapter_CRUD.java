package in.rafique.androidbasics.recyclerviews.ui.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class RVAdapter_CRUD extends RecyclerView.Adapter<RVAdapter_CRUD.RVHolder_Normal> {
    private static final String LOG_TAG = "RVAdapter_Normal => " ;
    Context context ;
    List<Object_FoodItem> lisOfItems ;

    public RVAdapter_CRUD(Context context, List<Object_FoodItem> listOfItems){
        this.context = context ;
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
        Object_FoodItem currentItem = lisOfItems.get(position) ;

        Glide.with(context).load(currentItem.getImageId()).into(holder.itemImageView) ;
        holder.itemIdTextView.setText("" + currentItem.getId());
        holder.itemNameTextView.setText(currentItem.getName());
    }


    @Override
    public int getItemCount() {
        return lisOfItems.size();
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


    public void refreshAllData(List<Object_FoodItem> newListOfItems){
        this.lisOfItems = newListOfItems ;
        notifyDataSetChanged();
        Toast.makeText(context, "I have refreshed the data by calling notifyDataSetChanged(), but you won't see any UI change", Toast.LENGTH_SHORT).show();
    }

    public void addItem(Object_FoodItem newObj){
        lisOfItems.add(newObj) ;
        notifyItemInserted(lisOfItems.size()-1);
    }

    public void removeLastItem(){
        // we are going to remove the last item
        // generally you should retreive the position of the item in the recyclerView you want to delete

        // IMPORTANT : make sure that store the position as an integer separately  and not doing it directly
        // because let's say you had the following code
        //      lisOfItems.remove(position) ;
        //      notifyItemRemoved(position);
        //      Whats happening here is that you firstly remove the item from the list
        //      but when you are calling notifyItemRemoved after that the list.size() value has already changed
        //          it will now already be one item less, so now would you have to add one item i.e. notifyItemRemoved(lisOfItems.size()+1 -1);
        //      better to just store the position in an integer
        int position = lisOfItems.size() -1 ;
        lisOfItems.remove(position) ;
        notifyItemRemoved(position);

    }


}
