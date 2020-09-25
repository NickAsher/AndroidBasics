package in.rafique.androidbasics.recyclerviews.ui.multiple_viewtype;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;
import in.rafique.androidbasics.recyclerviews.ui.normal.RVAdapter_Normal;

public class MultipleViewType_4_RecyclerView extends AppCompatActivity {
    List<Object_FoodItem> listOfItems ;
    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_multiview);
        context = this ;
        listOfItems = Object_FoodItem.getListOfFoodItems() ;

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView rv = findViewById(R.id.activityNormal_RecyclerView) ;

        RVAdapter_MultiView adapter_normal = new RVAdapter_MultiView(context, listOfItems) ;
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(adapter_normal);

    }


}