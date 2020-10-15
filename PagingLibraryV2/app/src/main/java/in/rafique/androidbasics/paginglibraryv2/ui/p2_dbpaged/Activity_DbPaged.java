package in.rafique.androidbasics.paginglibraryv2.ui.p2_dbpaged;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.R;
import in.rafique.androidbasics.paginglibraryv2.data.DataRepository;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;


public class Activity_DbPaged extends AppCompatActivity {
    Context context ;
    DataRepository dataRepository ;

    RVAdapter_DbPaged adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_paged);
        context = this ;
        dataRepository = DataRepository.getInstance(context) ;

        initRecyclerView() ;
        setDataToRecyclerView() ;
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.activityRecyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RVAdapter_DbPaged(context) ;
        recyclerView.setAdapter(adapter);
    }

    private void setDataToRecyclerView(){
        DataSource.Factory<Integer, Object_CryptoCoin> dataSource = dataRepository.getListOfAllCoins_PositionalDataSource() ;

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .setPageSize(10)
                .build() ;
        LiveData<PagedList<Object_CryptoCoin>> liveData_PagedList = new LivePagedListBuilder(dataSource, config).build() ;

        liveData_PagedList.observe(this, new Observer<PagedList<Object_CryptoCoin>>() {
            @Override
            public void onChanged(PagedList<Object_CryptoCoin> pagedList) {
                adapter.submitList(pagedList);
            }
        });
    }
}