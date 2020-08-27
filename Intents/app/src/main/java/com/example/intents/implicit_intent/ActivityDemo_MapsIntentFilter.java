package com.example.intents.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intents.R;

public class ActivityDemo_MapsIntentFilter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydemo_maps_intent_filter);

        TextView textView = findViewById(R.id.activityMapsIntentFilter_TextView_data) ;

        Intent intent = getIntent();
        Uri data = intent.getData();

        if(Intent.ACTION_VIEW.equals(intent.getAction()) ) {
            if(data != null && "geo".equals(data.getScheme())) {
                textView.setText("Data is " + data.toString());
            }
        }
        else {
            // Code for activity when it`s started without geo uri
        }
    }


}