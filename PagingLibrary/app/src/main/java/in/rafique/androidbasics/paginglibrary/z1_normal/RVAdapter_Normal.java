package in.rafique.androidbasics.paginglibrary.z1_normal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.rafique.androidbasics.paginglibrary.R;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

public class RVAdapter_Normal extends RecyclerView.Adapter<RVAdapter_Normal.MyViewHolder> {
    Context context ;
    List<Object_CryptoCoin> listOfItems ;

    public RVAdapter_Normal(Context context) {
        this.context = context;
        this.listOfItems = new ArrayList<>();
    }

    public RVAdapter_Normal(Context context, List<Object_CryptoCoin> listOfItems) {
        this.context = context;
        this.listOfItems = listOfItems ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow_coin, parent, false) ;
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Object_CryptoCoin cryptoCoin = listOfItems.get(position) ;

        holder.textViewId.setText("" + cryptoCoin.getId());
        holder.textViewName.setText(cryptoCoin.getName());
        holder.textViewSymbol.setText(cryptoCoin.getSymbol());


    }

    @Override
    public int getItemCount() {
        return this.listOfItems.size();
    }

    public void refreshData(List<Object_CryptoCoin> newListOfItems){
        this.listOfItems = newListOfItems ;
        notifyDataSetChanged();
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
