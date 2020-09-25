package in.rafique.androidbasics.recyclerviews.ui.autoscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class Autoscroll_3_RecyclerView extends AppCompatActivity {
    private static final String LOG_TAG = "AutoscrollActicity_3 =>" ;
    List<Object_FoodItem> listOfItems ;
    Context context ;
    RVAdapter_Autoscroll rvAdapter_autoscroll ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoscroll_3_recycler_view);
        context = this ;
        listOfItems = Object_FoodItem.getListOfFoodItems() ;

        initRecyclerView() ;
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.activityAutoscroll_RecyclerView) ;
        rvAdapter_autoscroll = new RVAdapter_Autoscroll(context, listOfItems) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(rvAdapter_autoscroll);
    }

    @Override
    protected void onStop() {
        super.onStop();
        rvAdapter_autoscroll.stopScrolling(recyclerView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}