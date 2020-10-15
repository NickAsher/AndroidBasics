package in.rafique.androidbasics.paginglibraryv2.ui.p3_network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.util.Utils;
import in.rafique.androidbasics.paginglibraryv2.util.VolleySingleton;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

public class DataSource_Coins extends PageKeyedDataSource<Integer, Object_CryptoCoin> {
    Context context ;
    private static final String LOG_TAG = "DataSource_Coins => ";
    public static final int NO_OF_COINS_PER_PAGE = 20 ;
    final Integer FIRST_PAGE = 1 ;


    void setupContext(Context context){
        // i made this method, because i need context for volley methods
        this.context = context ;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Object_CryptoCoin> callback) {
        // This method is called once, when the list is initialised.
        // You basically fetch your data here, and after fetching data
        // pass it to a method
        //          callback.onResult(listOfData, previousPageNo, NextPageNo)

        String url = Utils.getURL_CoinGecko_CoinList(NO_OF_COINS_PER_PAGE, FIRST_PAGE) ;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Paging Library's Load Initial", Toast.LENGTH_SHORT).show();
                Log.d(LOG_TAG, response) ;
                List<Object_CryptoCoin> listOfCoins = Utils.parseListOfCoinsFromStringResponse(response) ;
                callback.onResult(listOfCoins, null, FIRST_PAGE+1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error in making volley request in DataSource in PagingLibraryV2", Toast.LENGTH_SHORT).show();
                Log.e(LOG_TAG, error.toString() ) ;
            }
        }) ;
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest) ;
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Object_CryptoCoin> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Object_CryptoCoin> callback) {
        // This method is called everytime boundary is reached and you need to load data again
        // You basically fetch your data here, and after fetching data
        // pass it to a method      callback.onResult(listOfData, adjacentPageKey)
        // But to get the NextPageNo, you do  params.key

        String url = Utils.getURL_CoinGecko_CoinList(NO_OF_COINS_PER_PAGE, params.key) ;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Paging Library's Load After", Toast.LENGTH_SHORT).show();
                Log.d(LOG_TAG, response) ;
                List<Object_CryptoCoin> listOfCoins = Utils.parseListOfCoinsFromStringResponse(response) ;
                callback.onResult(listOfCoins, params.key+1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error in making volley request in DataSource-LoadAfter in PagingLibraryV2", Toast.LENGTH_SHORT).show();
                Log.e(LOG_TAG, error.toString() ) ;
            }
        }) ;
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest) ;

    }





    public static class MyFactory extends DataSource.Factory {
        Context context ;

        void setupContext(Context context){
            // i made this method to pass arguments to the parent DataSource class
            this.context = context ;
        }

        @NonNull
        @Override
        public DataSource create() {
            // this method will be used by the
            DataSource_Coins dataSource_allCoinsList = new DataSource_Coins() ;
            dataSource_allCoinsList.setupContext(context);
            return dataSource_allCoinsList ;
        }

    }
}
