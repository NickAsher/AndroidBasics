package in.rafique.androidbasics.recyclerviews.ui.normal;

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

public class RVAdapter_Normal extends RecyclerView.Adapter<RVAdapter_Normal.RVHolder_Normal> {
    private static final String LOG_TAG = "RVAdapter_Normal => " ;
    Context context ;
    List<Object_FoodItem> lisOfItems ;

    public RVAdapter_Normal(Context context, List<Object_FoodItem> listOfItems){
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
}
