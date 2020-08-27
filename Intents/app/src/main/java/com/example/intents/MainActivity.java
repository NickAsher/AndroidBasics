package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intents.explicit_intent.Activity_ExplicitIntent;
import com.example.intents.implicit_intent.Activity_ImplicitIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openExplicitIntentsActivity(View v){
        Intent intent = new Intent(this, Activity_ExplicitIntent.class) ;
        startActivity(intent);
    }

    public void openImplicitIntentsActivity(View v){
        Intent intent = new Intent(this, Activity_ImplicitIntent.class) ;
        startActivity(intent);
    }

}