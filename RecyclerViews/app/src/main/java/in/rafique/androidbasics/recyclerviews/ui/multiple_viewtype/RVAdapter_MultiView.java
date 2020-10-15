package in.rafique.androidbasics.recyclerviews.ui.multiple_viewtype;

import android.content.Context;
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

public class RVAdapter_MultiView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEWTYPE_1 = 1 ;
    private static final int VIEWTYPE_2 = 2 ;
    private static final String LOG_TAG = "RVAdapter_Normal => " ;
    Context context ;
    List<Object_FoodItem> lisOfItems ;

    public RVAdapter_MultiView(Context context, List<Object_FoodItem> listOfItems){
        this.context = context ;
        this.lisOfItems = listOfItems ;
    }


    @Override
    public int getItemViewType(int position) {
        if(position %2 == 0){
            return VIEWTYPE_1 ;
        }else{
            return VIEWTYPE_2 ;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEWTYPE_1 :
                View v = LayoutInflater.from(context).inflate(R.layout.singlerow_normal, parent, false) ;
                return new RVHolder_1(v) ;
            case VIEWTYPE_2 :
                View v2 = LayoutInflater.from(context).inflate(R.layout.singlerow_normal_type2, parent, false) ;
                return new RVHolder_2(v2) ;
            default:
                View v3 = LayoutInflater.from(context).inflate(R.layout.singlerow_normal, parent, false) ;
                return new RVHolder_1(v3) ;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object_FoodItem currentItem = lisOfItems.get(position) ;

        // lazy typecasting
        switch (holder.getItemViewType()){
            case VIEWTYPE_1 :
                Glide.with(context).load(currentItem.getImageId()).into(((RVHolder_1)holder).itemImageView) ;
                ((RVHolder_1)holder).itemIdTextView.setText("" + currentItem.getId());
                ((RVHolder_1)holder).itemNameTextView.setText(currentItem.getName());
                break;
            case VIEWTYPE_2 :
                Glide.with(context).load(currentItem.getImageId()).into(((RVHolder_2)holder).itemImageView) ;
                ((RVHolder_2)holder).itemIdTextView.setText("" + currentItem.getId());
                ((RVHolder_2)holder).itemNameTextView.setText(currentItem.getName());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return lisOfItems.size();
    }


    public class RVHolder_1 extends RecyclerView.ViewHolder{
        TextView itemNameTextView ;
        ImageView itemImageView ;
        TextView itemIdTextView ;



        public RVHolder_1(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemName);
            itemImageView = itemView.findViewById(R.id.singleRowNormal_ImageView_ItemImage) ;
            itemIdTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemId) ;
        }
    }

    public class RVHolder_2 extends RecyclerView.ViewHolder{
        TextView itemNameTextView ;
        ImageView itemImageView ;
        TextView itemIdTextView ;



        public RVHolder_2(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemName);
            itemImageView = itemView.findViewById(R.id.singleRowNormal_ImageView_ItemImage) ;
            itemIdTextView = itemView.findViewById(R.id.singleRowNormal_TextView_ItemId) ;
        }
    }
}
