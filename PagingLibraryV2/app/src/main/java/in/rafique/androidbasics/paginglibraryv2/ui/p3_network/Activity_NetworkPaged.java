package in.rafique.androidbasics.paginglibraryv2.ui.p3_network;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.rafique.androidbasics.paginglibraryv2.R;
import in.rafique.androidbasics.paginglibraryv2.data.DataRepository;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;
import in.rafique.androidbasics.paginglibraryv2.ui.p2_dbpaged.RVAdapter_DbPaged;


public class Activity_NetworkPaged extends AppCompatActivity {
    Context context ;
    DataRepository dataRepository ;

    RVAdapter_NetworkPaged adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_network_paged);
        context = this ;
        dataRepository = DataRepository.getInstance(context) ;

        initRecyclerView() ;
        setDataToRecyclerView() ;
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.activityRecyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RVAdapter_NetworkPaged(context) ;
        recyclerView.setAdapter(adapter);
    }



    private void setDataToRecyclerView(){
        DataSource_Coins.MyFactory dataSourceFactory = new DataSource_Coins.MyFactory() ;
        dataSourceFactory.setupContext(context);

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPrefetchDistance(DataSource_Coins.NO_OF_COINS_PER_PAGE)
                .setPageSize(DataSource_Coins.NO_OF_COINS_PER_PAGE)
                .build() ;
        LiveData<PagedList<Object_CryptoCoin>> liveData_PagedList = new LivePagedListBuilder(dataSourceFactory, config).build() ; //this method will use the dataSourceFactory's create method to make the data source

        liveData_PagedList.observe(this, new Observer<PagedList<Object_CryptoCoin>>() {
            @Override
            public void onChanged(PagedList<Object_CryptoCoin> pagedList) {
                adapter.submitList(pagedList);
            }
        });
    }
}