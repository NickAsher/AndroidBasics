package in.rafique.androidbasics.paginglibraryv2.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private RequestQueue requestQueue ;
    static VolleySingleton mInstance ;


    private VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context) ;
    }


    public static VolleySingleton getInstance(Context context){
        if(mInstance == null){
            synchronized (VolleySingleton.class){
                if (mInstance == null){
                    mInstance = new VolleySingleton(context) ;
                }
            }
        }
        return mInstance ;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue ;
    }
}
