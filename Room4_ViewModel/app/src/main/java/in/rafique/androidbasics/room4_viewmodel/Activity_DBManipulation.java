package in.rafique.androidbasics.room4_viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import in.rafique.androidbasics.room4_viewmodel.data.DataRepository;
import in.rafique.androidbasics.room4_viewmodel.data.Objects.Object_FoodItem;


public class Activity_DBManipulation extends AppCompatActivity {
    private static final String LOG_TAG = "DBMainpulation => " ;
    Context context ;
    DataRepository dataRepository ;
    ViewModel_DBMainpulation viewModel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_manipulation);
        context = this.getApplicationContext() ;

        dataRepository = DataRepository.getInstance(this.getApplicationContext()) ;

        ViewModel_DBMainpulation.Factory vmFactory = new ViewModel_DBMainpulation.Factory(context, 1) ;
        viewModel = new ViewModelProvider(this, vmFactory).get(ViewModel_DBMainpulation.class) ;


        showAllFoodItems();
        showFirstItem();
    }

    private void showAllFoodItems(){
        // This is where is have used live Data i.e. Retrieving Data and setting up UI
        final TextView listTextView  = findViewById(R.id.activityDbManipulation_TextView_Status) ;

        LiveData<List<Object_FoodItem>> listLiveData = viewModel.getListOfFoodItems_LiveData() ;
        listLiveData.observe(this, new Observer<List<Object_FoodItem>>() {
            @Override
            public void onChanged(List<Object_FoodItem> listOfItems) {
                listTextView.setText("");
                for (Object_FoodItem foodItem : listOfItems){
                    listTextView.append(foodItem.getId() + " - " + foodItem.getName() + " - " + foodItem.getCreationDate() + " \n");
                }
            }
        });

    }

    private void showFirstItem(){
        final TextView firstItemTextView = findViewById(R.id.activityDbManipulation_TextView_FirstItem) ;
        LiveData<Object_FoodItem> firstFoodItem_LiveData = viewModel.getFirstFoodItem_LiveData() ;
        firstFoodItem_LiveData.observe(this, new Observer<Object_FoodItem>() {
            @Override
            public void onChanged(Object_FoodItem foodItem) {
                firstItemTextView.setText(foodItem.getName());
            }
        });
    }


    public void insertNewFoodItem(View v){
        EditText newFoodItemNameEditText = findViewById(R.id.activityDbManipulation_EditText_InsertItemName) ;
        String newFoodItemName = newFoodItemNameEditText.getText().toString() ;
        newFoodItemNameEditText.getText().clear();

        final Object_FoodItem newFoodItem = new Object_FoodItem(newFoodItemName) ;
        dataRepository.insertNewFoodItem(newFoodItem);
    }

    public void deleteFoodItemById(View v){
        EditText  deleteFoodItemByIdEditText = findViewById(R.id.activityDbManipulation_EditText_DeleteItemId) ;
        final int id = Integer.parseInt(deleteFoodItemByIdEditText.getText().toString() );
        deleteFoodItemByIdEditText.getText().clear();

        dataRepository.deleteFoodItem(id);
    }

    public void updateFoodItem(View v){
        EditText editTextItemId = findViewById(R.id.activityDbManipulation_EditText_UpdateItemId) ;
        EditText editTextItemName = findViewById(R.id.activityDbManipulation_EditText_UpdateItemName) ;

        final int id = Integer.parseInt(editTextItemId.getText().toString() );
        final String newName = editTextItemName.getText().toString() ;

        editTextItemId.getText().clear();
        editTextItemName.getText().clear();

        dataRepository.updateFoodItem(id, newName);
    }


}