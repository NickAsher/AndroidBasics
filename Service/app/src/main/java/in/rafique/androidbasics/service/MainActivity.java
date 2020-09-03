package in.rafique.androidbasics.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openMyIntentService(View v){
        Intent intent = new Intent(this, MyIntentService.class) ;
        intent.putExtra("myData", "Rafique GGGG") ;
        startService(intent) ;

    }

    public void openMyJobIntentService(View v){
        Intent intent = new Intent(this, MyJobIntentService.class) ;
        intent.putExtra("myData", "Shampy OOOO") ;
        startService(intent) ;
    }
}