package in.rafique.androidbasics.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import in.rafique.androidbasics.broadcastreceivers.receivers.DynamicImplicit_2_NetworkBroadcastReceiver;

public class MainActivity extends AppCompatActivity {
    DynamicImplicit_2_NetworkBroadcastReceiver dynamicImplicit2NetworkReceiver = new DynamicImplicit_2_NetworkBroadcastReceiver() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    protected void onStart() {
        super.onStart();

        //Registering the second receiver
        IntentFilter filter = new IntentFilter() ;
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);  // you can add multiple action here i.e. listen to multiple intent filters
        registerReceiver(dynamicImplicit2NetworkReceiver, filter) ;


    }


    @Override
    protected void onStop() {
        super.onStop();

        // unregistering the second receiver
        unregisterReceiver(dynamicImplicit2NetworkReceiver);
    }



    public void onClick_Btn3_sendCustomBroadCast(View v){
        // This button sends a custom broadcast with my own intent filter
        // This broadcast is then caught by my receiver that can handle my custom intent-filter
        // Although the following broadcast is sent by our own app,
        //      other apps can also send the broadcast with this custom intent
        //      and our receiver will still be able to catch these broadcasts
        Intent intent = new Intent() ;
        intent.setAction("yoloman.super.duper.myFilter.MY_ACTION") ;
        intent.putExtra("yoloman.super.duper.myFilter.EXTRA_DATA_1", "zoravar") ;
        sendBroadcast(intent);


    }

    public void onClick_Btn4_ExplicitBroadcastReceiver(View v){
        String packageName = "in.rafique.androidbasics.broadcastreceivers" ;
        String broadcastReceiverFullName = "in.rafique.androidbasics.broadcastreceivers.receivers.StaticExplicit_4_BroadcastReceiver" ;
        // when we do new Intent(context, className.java) we are stll doing the following thing
        // the context gives package name, and the class name gives class path
        ComponentName componentName = new ComponentName(packageName, broadcastReceiverFullName) ;
        Intent intent = new Intent() ;
        intent.setComponent(componentName) ;
        sendBroadcast(intent);
    }
}