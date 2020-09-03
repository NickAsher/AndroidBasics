package in.rafique.androidbasics.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticImplicit_1_BluetoothBroadcastReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "1_Bluetooth => " ;
    @Override
    public void onReceive(Context context, Intent intent) {

        if("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            Log.d(LOG_TAG, "Inside onReceive of bluetooth") ;
            //Note that string intentFilter comes first before intent.getAction in the if-statement
            // this is because intent.getAction() can sometimes be null, causing an app crash. So add the string first

            Toast.makeText(context, "StaticImplicit_1_BluetoothBroadcastReceiver => My Lord, You Have changed Bluetooth State", Toast.LENGTH_SHORT).show();
        }

        // you can have multiple if-else statements to catch multiple intent-actions in a single receiver




    }
}
