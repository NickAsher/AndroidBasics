package in.rafique.androidbasics.networking1_volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    public static VolleySingleton instance ;
    Context context ;
    RequestQueue requestQueue ;

    VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context) ;
    }

    public static VolleySingleton getInstance(Context context){
        if(instance == null){
            synchronized (VolleySingleton.class){
                if(instance == null){
                    instance = new VolleySingleton(context) ;
                }
            }
        }
        return instance ;
    }


    public RequestQueue getRequestQueue(){
        return requestQueue ;
    }
}
