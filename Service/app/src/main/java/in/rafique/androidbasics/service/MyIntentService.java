package in.rafique.androidbasics.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {



    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Do Background related tasks here
        // Like download data from internet, or sync data to some database
        // I am Just going to post some Log Statements
        String someData = intent.getStringExtra("myData") ;
        Log.d("MyIntentService => ", "Data is " + someData) ;

    }
}
