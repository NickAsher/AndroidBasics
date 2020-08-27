package com.example.intents.explicit_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.intents.R;

public class Activity_ExplicitIntent extends AppCompatActivity {
    public static final int INTENT_REQUEST_CODE_CHOOSEFOOD = 1 ;
    TextView dataTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        dataTextView = findViewById(R.id.activityExplicitIntent_TextView_Data) ;
    }

    public void openFoodChooserActivityForResult(View v){
        Intent intent = new Intent(this, ActivityDemo_ChooseFood.class) ;
        startActivityForResult(intent, INTENT_REQUEST_CODE_CHOOSEFOOD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INTENT_REQUEST_CODE_CHOOSEFOOD){
          if(resultCode == Activity.RESULT_OK){
              String choosenFood = data.getStringExtra("CHOSEN_FOOD") ;
              dataTextView.setText("Chosen Food is " +  choosenFood);

          }else if(resultCode == Activity.RESULT_CANCELED){
              dataTextView.setText("You didn't chose any food");
          }


        } // you can implement startActivityForResult multiple times with different requestCodes, by using if-else statements

    }
}