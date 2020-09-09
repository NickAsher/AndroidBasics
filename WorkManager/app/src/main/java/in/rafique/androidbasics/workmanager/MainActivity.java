package in.rafique.androidbasics.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import in.rafique.androidbasics.workmanager.works.W1_NormalWork;

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
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(W1_NormalWork.class).build() ;

        workManager
                .enqueue(workRequest) ;

        workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        String workStatus = workInfo.getState().toString() ;
                        statusTextView.setText("W1=> " + workStatus);


                    }
                });
    }

    public void doIO_OneTimeWork(View v){
        // one time work with input data and output data
    }

    public void doConstrained_OneTimeWork(View v){

    }

    public void doBasic_PerdiodicWork(View v){

    }


}