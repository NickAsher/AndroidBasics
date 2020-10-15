package in.rafique.androidbasics.paginglibraryv2.ui.p1_normal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.R;
import in.rafique.androidbasics.paginglibraryv2.data.DataRepository;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

public class Activity_P1Normal extends AppCompatActivity {
    Context context ;
    DataRepository dataRepository ;

    RVAdapter_Normal adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_normal);
        context = this ;
        dataRepository  = DataRepository.getInstance(context) ;

        setupRecyclerView() ;
        setDataToRecyclerView() ;
    }

    private void setupRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.activity1Normal_RecyclerView) ;
        adapter = new RVAdapter_Normal(context) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);


    }

    private void setDataToRecyclerView(){
        LiveData<List<Object_CryptoCoin>> listLiveData = dataRepository.getListOfAllCoins_LiveData() ;
        listLiveData.observe(this, new Observer<List<Object_CryptoCoin>>() {
            @Override
            public void onChanged(List<Object_CryptoCoin> listOfCoins) {
                adapter.refreshData(listOfCoins);
            }
        });
    }
}