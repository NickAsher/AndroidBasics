package in.rafique.androidbasics.workmanager.works;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class W4_NormalPeriodicWork extends Worker {

    public W4_NormalPeriodicWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        SystemClock.sleep(2000);
        Log.d("W4_PeriodicWork => ", "My Work is done here") ; // can't use Toasts here
        return Result.success() ;

    }
}
