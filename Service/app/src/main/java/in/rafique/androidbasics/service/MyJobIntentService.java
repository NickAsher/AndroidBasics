package in.rafique.androidbasics.service;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class MyJobIntentService extends JobIntentService {


    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        // Do Background related tasks here
        // Like download data from internet, or sync data to some database
        // I am Just going to post some Log Statements
        String someData = intent.getStringExtra("myData") ;
        Log.d("MyJobIntentService => ", "Data is " + someData) ;

    }
}
