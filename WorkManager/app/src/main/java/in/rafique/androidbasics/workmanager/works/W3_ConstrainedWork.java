package in.rafique.androidbasics.workmanager.works;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class W3_ConstrainedWork extends Worker {

    public W3_ConstrainedWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        SystemClock.sleep(2000);
        Log.d("W3_ConstrainedWork => ", "My Work is done here") ; // can't use Toasts here
        return Result.success() ;
    }
}
