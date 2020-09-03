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
        if("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())){
            Log.d("jdfslj =>", "I am inside onReceive") ;
            Toast.makeText(context, "Ringer Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
