package in.rafique.androidbasics.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class StaticImplicit_3_CustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // this is a custom intent filter made by me
        // you can also add extra data when sending a broadcast, and we will catch it here

        if("yoloman.super.duper.myFilter.MY_ACTION".equals(intent.getAction())){
            String customIntentFilter_ExtraData = intent.getStringExtra("yoloman.super.duper.myFilter.EXTRA_DATA_1") ;
            Toast.makeText(context, "My Lord, This is inside the custom Receiver "+ customIntentFilter_ExtraData, Toast.LENGTH_SHORT).show();

        }
    }
}
