package in.rafique.androidbasics.recyclerviews.ui.normal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class Normal_1_RecyclerView extends AppCompatActivity {
    List<Object_FoodItem> listOfItems ;
    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_1_recycler_view);
        context = this ;
        listOfItems = Object_FoodItem.getListOfFoodItems() ;

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView rv = findViewById(R.id.activityNormal_RecyclerView) ;

        RVAdapter_Normal adapter_normal = new RVAdapter_Normal(context, listOfItems) ;
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(adapter_normal);

    }


}