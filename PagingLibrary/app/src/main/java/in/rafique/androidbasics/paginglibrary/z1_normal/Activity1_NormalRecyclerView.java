package in.rafique.androidbasics.paginglibrary.z1_normal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import in.rafique.androidbasics.paginglibrary.R;
import in.rafique.androidbasics.paginglibrary.data.DataRepository;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

public class Activity1_NormalRecyclerView extends AppCompatActivity {
    Context context ;
    ViewModel_Normal viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_normal_recycler_view);
        context = this.getApplicationContext() ;

        ViewModel_Normal.Factory vmFactory = new ViewModel_Normal.Factory(context) ;
        viewModel = new ViewModelProvider(this, vmFactory).get(ViewModel_Normal.class) ;

        setupRecyclerView();

    }


    private void setupRecyclerView(){
        RecyclerView rv = findViewById(R.id.activity1Normal_RecyclerView) ;
        final RVAdapter_Normal adapter = new RVAdapter_Normal(this) ;
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(adapter);

        viewModel.getListOfCryptoCoins_LiveData().observe(this, new Observer<List<Object_CryptoCoin>>() {
            @Override
            public void onChanged(List<Object_CryptoCoin> listOfItems) {
                adapter.refreshData(listOfItems);
            }
        });
    }
}