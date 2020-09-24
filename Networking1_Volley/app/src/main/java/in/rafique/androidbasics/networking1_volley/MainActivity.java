package in.rafique.androidbasics.networking1_volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity => " ;
    Context context ;
    RequestQueue requestQueue ;

    TextView statusTextview ;
    ImageView statusImageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext() ;
        requestQueue = VolleySingleton.getInstance(context).getRequestQueue() ;

        statusTextview = findViewById(R.id.activityMain_Textview_Status) ;
        statusImageView = findViewById(R.id.activityMain_ImageView_Status) ;

    }

    public void sendGetRequest_StringRequest(View v){
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin%2Cripple&vs_currencies=usd" ;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                statusTextview.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "There has been some kind of error", Toast.LENGTH_SHORT).show();
                statusTextview.setText(error.getMessage());
            }
        }) ;
        requestQueue.add(request) ;
    }


    public void sendGetRequest_JSONRequest(View v){
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=ethereum%2Cripple&vs_currencies=usd" ;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                statusTextview.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "There has been some kind of error", Toast.LENGTH_SHORT).show();
                statusTextview.setText(error.getMessage());
            }
        }) ;
        requestQueue.add(request) ;

    }

    public void sendGetRequest_ImageRequest(View v){
        String url = "https://i.imgur.com/7spzG.png" ;
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                statusImageView.setImageBitmap(response);
            }
        }, 0, 0, null, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "There has been some kind of error", Toast.LENGTH_SHORT).show();
                statusTextview.setText(error.getMessage());
            }
        }) ;
        requestQueue.add(request) ;
        // you can show a progress bar now, and finish the progress bar in onResponse methods

    }

    public void sendPostRequest_StringRequest(View v) throws Exception{
        String url = "https://postman-echo.com/put?argkey1=yolo&argkey2=tolo" ;
        StringRequest request = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                statusTextview.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "There has been some kind of error", Toast.LENGTH_SHORT).show();
                statusTextview.setText(error.getMessage());
            }
        }){
            // This is the body of the StringRequest class. We are going to override some functions here

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>() ;
                params.put("key1", "Rafique Gagneja") ;
                params.put("key2", "21") ;
                params.put("key3", "Male") ;
                return params ;
            }

            // you can even override the getHeaders method to set custom headers
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        } ;
        requestQueue.add(request) ;


    }


    public void sendPostRequest_JsonRequest(View v) throws Exception{
        // To make post requests, you need to use JsonObjectRequest. You can't do post requests with StringRequest
        String url = "https://postman-echo.com/put" ;

        JSONObject putRequestData = new JSONObject() ;
        putRequestData.put("key1", "some fukin data here") ;
        putRequestData.put("key2", "some fukin number here") ;
        putRequestData.put("key3", "some fukin date here") ;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, putRequestData, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    // adding indentation in toString() method of jsonObject throws exception, so caught it
                    statusTextview.setText(response.toString(4));
                }catch (Exception e){}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "There has been some kind of error", Toast.LENGTH_SHORT).show();
                statusTextview.setText(error.getMessage());
            }
        }) ;
        requestQueue.add(request) ;


    }


    public void sendPostRequest_ImageRequest(View v){
        Toast.makeText(context, "This should be done using the android multipart library", Toast.LENGTH_SHORT).show();

    }


}