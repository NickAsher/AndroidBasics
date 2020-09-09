package in.rafique.androidbasics.recyclerviews.ui.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;
import in.rafique.androidbasics.recyclerviews.data.Object_FoodItem;

public class CRUD_2_RecyclerView extends AppCompatActivity {
    List<Object_FoodItem> listOfItems ;
    Context context ;

    RecyclerView recyclerView ;
    RVAdapter_CRUD rvAdapter_crud ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_2_recycler_view);
        context = this ;
        listOfItems = Object_FoodItem.getListOfFoodItems() ;


        initRecyclerView() ;
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.activityCRUD_RecyclerView) ;
        rvAdapter_crud = new RVAdapter_CRUD(context, listOfItems) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(rvAdapter_crud);
    }

    public void addNewItem(View v){
        EditText addFoodEditText = findViewById(R.id.activityCRUD_EditText_NewFood) ;
        String foodName = addFoodEditText.getText().toString() ;
        Object_FoodItem newFoodItem = new Object_FoodItem(listOfItems.size(), foodName, R.drawable.neon_tree_sign) ;
        rvAdapter_crud.addItem(newFoodItem);
        addFoodEditText.getText().clear();
    }

    public void removeLastItem(View v){
        rvAdapter_crud.removeLastItem();
    }

    public void refreshData(View v){
        rvAdapter_crud.refreshAllData(listOfItems);
    }


}