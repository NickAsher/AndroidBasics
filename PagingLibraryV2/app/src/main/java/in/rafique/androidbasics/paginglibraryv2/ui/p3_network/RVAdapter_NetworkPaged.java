package in.rafique.androidbasics.paginglibraryv2.ui.p3_network;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import in.rafique.androidbasics.paginglibraryv2.R;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

public class RVAdapter_NetworkPaged extends PagedListAdapter<Object_CryptoCoin, RVAdapter_NetworkPaged.MyViewHolder> {
    // The recyclerView basically stays the same, as in database paging
    Context context ;
    String LOG_TAG = "RVPagedAdapter_AllCoins --> " ;

    private static DiffUtil.ItemCallback<Object_CryptoCoin> DIFF_COIN_CALLBACK   = new DiffUtil.ItemCallback<Object_CryptoCoin>() {
        @Override
        public boolean areItemsTheSame(@NonNull Object_CryptoCoin oldItem, @NonNull Object_CryptoCoin newItem) {
            return oldItem.getName().equalsIgnoreCase(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Object_CryptoCoin oldItem, @NonNull Object_CryptoCoin newItem) {
            return oldItem.equals(newItem);
        }
    } ;



    protected RVAdapter_NetworkPaged(Context context) {
        super(DIFF_COIN_CALLBACK);
        this.context = context ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow_coin, parent, false) ;
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Object_CryptoCoin cryptoCoin = getItem(position) ;

        holder.textViewId.setText("" + cryptoCoin.getId());
        holder.textViewName.setText(cryptoCoin.getName());
        holder.textViewSymbol.setText(cryptoCoin.getSymbol());
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
