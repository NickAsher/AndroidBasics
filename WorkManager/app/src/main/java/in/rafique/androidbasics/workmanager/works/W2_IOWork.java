package in.rafique.androidbasics.workmanager.works;

import android.content.Context;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class W2_IOWork extends Worker {


    public W2_IOWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        SystemClock.sleep(2000);

        Data inputData = getInputData() ;
        String name = inputData.getString("name") ;
        String age = inputData.getString("age") ;

        String outputLine = "Name is " + name + " and his age is " + age ;

        Data outputData=  new Data.Builder()
                .putString("line", outputLine)
                .build() ;

        return Result.success(outputData) ;
    }
}
