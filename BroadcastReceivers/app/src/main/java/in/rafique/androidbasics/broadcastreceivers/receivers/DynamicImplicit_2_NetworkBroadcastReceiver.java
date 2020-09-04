package in.rafique.androidbasics.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class DynamicImplicit_2_NetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Registering Dynamically sends an initial sticky broadcast, every time app resumes, opens
        // we don't want that, so bypassing the initial-sticky-broadcast here using isInitialStickyBroadcast()
        if(!isInitialStickyBroadcast()){


            if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
                boolean hasNoConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false) ;
                if(hasNoConnectivity){
                    Toast.makeText(context, "NOOO, network is gone my lord", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "YAYYY, the network is back my Lord", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
