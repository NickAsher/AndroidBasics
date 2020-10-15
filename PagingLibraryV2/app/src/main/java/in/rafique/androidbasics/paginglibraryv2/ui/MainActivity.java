package in.rafique.androidbasics.paginglibraryv2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.R;
import in.rafique.androidbasics.paginglibraryv2.data.DataRepository;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;
import in.rafique.androidbasics.paginglibraryv2.ui.p1_normal.Activity_P1Normal;
import in.rafique.androidbasics.paginglibraryv2.ui.p2_dbpaged.Activity_DbPaged;

public class MainActivity extends AppCompatActivity {
    Context context ;
    DataRepository dataRepository ;
    private static final String LOG_TAG = "MainActivity => " ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;
        dataRepository = DataRepository.getInstance(context) ;


    }

    public void oneTimeSetup(View v){
        final LiveData<List<Object_CryptoCoin>> listLiveData = dataRepository.getListOfAllCoins_LiveData() ;
        listLiveData.observe(this, new Observer<List<Object_CryptoCoin>>() {
            @Override
            public void onChanged(List<Object_CryptoCoin> listOfCoins) {
                listLiveData.removeObserver(this);
                if(listOfCoins.size() == 0){
                    dataRepository.insertListOfCoins(dataRepository.getFakeData());
                }
            }
        });
    }

    public void openNormalRecyclerView(View v){
        startActivity(new Intent(this, Activity_P1Normal.class));
    }


    public void openDBPagedRecyclerView(View v){
        startActivity(new Intent(this, Activity_DbPaged.class));
    }

    public void openNetworkPagedRecyclerView(View v){
        startActivity(new Intent(this, Activity_P1Normal.class));

    }
}