package in.rafique.androidbasics.workmanager.works;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class W1_NormalWork extends Worker {


    public W1_NormalWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }



    @NonNull
    @Override
    public Result doWork() {
        SystemClock.sleep(2000);
        Log.d("WI_NormalWork => ", "My Work is done here") ; // can't use Toasts here
        return Result.success() ;
    }
}
