package com.example.intents.explicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.intents.R;

public class ActivityDemo_ChooseFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydemo_choose_food);
    }

    public void onChoosingPizza(View v){
        Intent returnIntent = new Intent() ;
        returnIntent.putExtra("CHOSEN_FOOD", "Pizza") ;
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void onChoosingBurger(View v){
        Intent returnIntent = new Intent() ;
        returnIntent.putExtra("CHOSEN_FOOD", "Burger") ;
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void onChoosingChocolate(View v){
        Intent returnIntent = new Intent() ;
        returnIntent.putExtra("CHOSEN_FOOD", "Chocolate") ;
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();

    }
}