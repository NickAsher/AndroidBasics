package in.rafique.androidbasics.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StaticExplicit_4_BroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // i don't right now know when to use explicit broadcast receiver
        Toast.makeText(context, "This is from explicit broadcast receiver", Toast.LENGTH_SHORT).show();
    }
}
