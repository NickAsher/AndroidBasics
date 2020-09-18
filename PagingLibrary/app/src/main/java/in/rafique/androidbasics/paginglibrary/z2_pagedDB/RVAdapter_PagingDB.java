package in.rafique.androidbasics.paginglibrary.z2_pagedDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import in.rafique.androidbasics.paginglibrary.R;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

public class RVAdapter_PagingDB extends PagingDataAdapter<Object_CryptoCoin, RVAdapter_PagingDB.MyViewHolder> {
    Context context ;

    private static DiffUtil.ItemCallback<Object_CryptoCoin> DIFF_COIN_CALLBACK = new DiffUtil.ItemCallback<Object_CryptoCoin>() {
        @Override
        public boolean areItemsTheSame(@NonNull Object_CryptoCoin oldItem, @NonNull Object_CryptoCoin newItem) {
            return oldItem.getSymbol().equalsIgnoreCase(newItem.getSymbol());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Object_CryptoCoin oldItem, @NonNull Object_CryptoCoin newItem) {
            return oldItem.getSymbol().equalsIgnoreCase(newItem.getSymbol());
//            return oldItem.equals(newItem);  //implement this equals method afterwards
        }
    } ;

    public RVAdapter_PagingDB(Context context) {
        super(DIFF_COIN_CALLBACK);
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow_coin, parent, false) ;
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Object_CryptoCoin cryptoCoin = getItem(position) ;  // we can use getItem directly in a pagingDataAdapter

        ((MyViewHolder)holder).textViewId.setText("" + cryptoCoin.getId());
        ((MyViewHolder)holder).textViewName.setText(cryptoCoin.getName());
        ((MyViewHolder)holder).textViewSymbol.setText(cryptoCoin.getSymbol());
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewId, textViewSymbol, textViewName  ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.singleRowCoin_TextView_Id) ;
            textViewSymbol = itemView.findViewById(R.id.singleRowCoin_TextView_Symbol) ;
            textViewName = itemView.findViewById(R.id.singleRowCoin_TextView_Name) ;

        }
    }
}
