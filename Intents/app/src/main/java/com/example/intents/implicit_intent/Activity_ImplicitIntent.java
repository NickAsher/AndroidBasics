package com.example.intents.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.intents.R;

public class Activity_ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }

    public void example_ImplicitIntent(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW) ; // Intent.ACTION_VIEW = "android.intent.action.VIEW"
        intent.setDataAndType(Uri.parse("https://www.youtube.com"), "text/html") ;

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void example_ImplicitIntent_ForceAppChooser(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW) ; // Intent.ACTION_VIEW = "android.intent.action.VIEW"
        intent.setDataAndType(Uri.parse("https://www.youtube.com"), "text/html") ;

        // Verify the original intent will resolve to at least one activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Create intent to show the chooser dialog
            Intent chooser = Intent.createChooser(intent, "Yolo open browser");
            startActivity(chooser);
        }
    }


    public void example_ImplicitIntent_Maps(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW) ; // Intent.ACTION_VIEW = "android.intent.action.VIEW"
        intent.setData(Uri.parse("geo:37.7749,-122.4194")) ;

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        // you can also choose this app, for our own activity
    }




    public void example_ImplicitIntent_MyIntentFilter(View v){
        // We make an activity with our own intent filter, and then send data from here using our own intent filter
        // and then android system will see that our app can intercept this intent. So it will open our app.
        Intent intent = new Intent();
        intent.setAction("android.intent.action.YOLOMAN") ; // Intent.ACTION_VIEW = "android.intent.action.VIEW"
        intent.setData(Uri.parse("kuchbhi_scheme:{'name':'rafique'}")) ;

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}