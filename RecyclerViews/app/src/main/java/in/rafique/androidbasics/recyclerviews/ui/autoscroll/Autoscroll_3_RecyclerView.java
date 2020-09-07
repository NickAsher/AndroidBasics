package in.rafique.androidbasics.recyclerviews.ui.autoscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class Autoscroll_3_RecyclerView extends AppCompatActivity {
    List<Object_FoodItem> listOfItems ;
    Context context ;
    private static final String LOG_TAG = "Autoscroll_3 => " ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoscroll_3_recycler_view);
        context = this ;
        listOfItems = Object_FoodItem.getListOfFoodItems() ;

        initRecyclerView() ;

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.activityAutoscroll_RecyclerView) ;
        RVAdapter_Autoscroll rvAdapter_autoscroll = new RVAdapter_Autoscroll(context, listOfItems) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(rvAdapter_autoscroll);
    }

}