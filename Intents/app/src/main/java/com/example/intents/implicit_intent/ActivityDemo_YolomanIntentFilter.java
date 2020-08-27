package com.example.intents.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intents.R;

public class ActivityDemo_YolomanIntentFilter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydemo_yoloman_intent_filter);

        TextView textView = findViewById(R.id.activityYolomanIntentFilter_TextView_data);

        Intent intent = getIntent();
        Uri data = intent.getData();
//        if(Intent.ACTION_VIEW.equals(intent.getAction()) ) {
//            if(data != null && "kuchbhi_scheme".equals(data.getScheme())) {
                textView.setText("Humra data is " + data.toString());
//            }
//        }

    }
}