package in.rafique.androidbasics.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import in.rafique.androidbasics.workmanager.works.W1_NormalWork;
import in.rafique.androidbasics.workmanager.works.W2_IOWork;
import in.rafique.androidbasics.workmanager.works.W3_ConstrainedWork;
import in.rafique.androidbasics.workmanager.works.W4_NormalPeriodicWork;

public class MainActivity extends AppCompatActivity {
    Context context ;
    static final String LOG_TAG = "MainActivity => " ;
    WorkManager workManager ;
    TextView statusTextView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this ;
        workManager = WorkManager.getInstance(context) ;
        statusTextView = findViewById(R.id.activityMain_TextView_Status) ;
    }


    public void doBasic_OneTimeWork(View v){
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(W1_NormalWork.class)
                .addTag("W1_NormalWork")   //used like findFragmentByTag
                .build() ;

        workManager
                .enqueue(workRequest) ;

        workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        String workStatus = workInfo.getState().toString() ;
                        statusTextView.append("\n W1=> " + workStatus);
                    }
                });
    }


    public void doIO_OneTimeWork(View v){
        // one time work with input data and output data

        Data inputData = new Data.Builder()
                .putString("name", "Rafique")
                .putInt("age", 21)
                .build() ;

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(W2_IOWork.class)
                .addTag("W2_IOWork")
                .setInputData(inputData)
                .build() ;

        workManager
                .enqueue(workRequest) ;

        workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this, new Observer<WorkInfo>() {
                @Override
                public void onChanged(WorkInfo workInfo) {
                    String workStatus = workInfo.getState().toString() ;
                    statusTextView.append("\n W2=> " + workStatus);

                    if(workInfo.getState().isFinished()){
                        // always check if work is finished when getting output data
                        Data outputData = workInfo.getOutputData() ;
                        String outputLine = outputData.getString("line") ;
                        statusTextView.append("\n W2=> Output: " + outputLine);
                    }
                }
            });

    }

    public void doConstrained_OneTimeWork(View v){

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
//                .setRequiresBatteryNotLow(true)
//                .setRequiredNetworkType(NetworkType.CONNECTED) METERED, NOT_REQUIRED, ROAMING, UNMETERED
                .build() ;

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(W3_ConstrainedWork.class)
                .addTag("W3_ConstrainedWork")
                .setConstraints(constraints)
                .build() ;

        workManager
                .enqueue(workRequest) ;

        workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String workStatus = workInfo.getState().toString() ;
                statusTextView.append("\n W3=> " + workStatus);
            }
        });


    }





    public void doBasic_PerdiodicWork(View v){

        PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(W4_NormalPeriodicWork.class, 31, TimeUnit.MINUTES)
                .addTag("W4_NormalPeriodicWork")
                .build() ;

        workManager.
                enqueueUniquePeriodicWork(
                        "background_updater",
                        ExistingPeriodicWorkPolicy.REPLACE, // if same work exists, replace it with new one
                        workRequest) ;

        // NOTE the lifecycle of periodic work is ENQUEUE=>RUNNING=>ENQUEUE.
        // Periodic work cannot finish, it will only finish when forcefull terminated
        // So use periodic work, where you don't need output data
        // if you need output data, put it in a database and use liveView to update in UI
        // i can't make an example to show result. You can see the result in logcat though


    }


}