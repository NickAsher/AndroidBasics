package in.rafique.androidbasics.paginglibraryv2.util;

import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

public class Utils {
    private static final String LOG_TAG = "Utils => " ;

    public static String getURL_CoinGecko_CoinList(int noOfCoinsPerPage, int pageNo){
        return "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=" + noOfCoinsPerPage + "&page=" + pageNo + "&sparkline=false&price_change_percentage=7d" ;
    }

    public static List<Object_CryptoCoin> parseListOfCoinsFromStringResponse(String response){
        List<Object_CryptoCoin> returnList = new ArrayList<>() ;
        try{
            JSONArray responseArray = new JSONArray(response) ;

            for (int i = 0; i<responseArray.length(); i++){
                JSONObject jsonObject = responseArray.getJSONObject(i) ;
                returnList.add(new Object_CryptoCoin(
                        jsonObject.getInt("market_cap_rank"),
                        jsonObject.getString("name"),
                        jsonObject.getString("symbol")
                )) ;
            }

        }catch (JSONException e){
            Log.e(LOG_TAG, e.toString()) ;

        }
        return returnList ;
    }

}
