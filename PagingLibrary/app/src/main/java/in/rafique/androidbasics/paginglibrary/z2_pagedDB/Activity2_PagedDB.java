package in.rafique.androidbasics.paginglibrary.z2_pagedDB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.Pager;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import in.rafique.androidbasics.paginglibrary.R;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

public class Activity2_PagedDB extends AppCompatActivity {
    Context context ;
    ViewModel_PagingDB viewModel ;
    private static final String LOG_TAG = "Activity2_Paged => " ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_paged_db);
        context = this ;

        ViewModel_PagingDB.MyFactory vmFactory = new ViewModel_PagingDB.MyFactory(context) ;
        viewModel = new ViewModelProvider(this, vmFactory).get(ViewModel_PagingDB.class) ;

        setupRecyclerView() ;
    }

    private void setupRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.activity2Paging_RecyclerView) ;
        final RVAdapter_PagingDB adapter = new RVAdapter_PagingDB(context) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        viewModel.getPagedListOfCryptoCoins_LiveData().observe(this, new Observer<PagingData<Object_CryptoCoin>>() {
            @Override
            public void onChanged(PagingData<Object_CryptoCoin> pagingData) {
                adapter.submitData(getLifecycle(), pagingData);
            }
        });

    }


}