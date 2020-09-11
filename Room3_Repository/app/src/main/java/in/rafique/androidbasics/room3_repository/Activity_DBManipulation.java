package in.rafique.androidbasics.room3_repository;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

import in.rafique.androidbasics.room3_repository.data.AppDatabase;
import in.rafique.androidbasics.room3_repository.data.AppExecutors;
import in.rafique.androidbasics.room3_repository.data.DataRepository;
import in.rafique.androidbasics.room3_repository.data.Objects.Object_FoodItem;


public class Activity_DBManipulation extends AppCompatActivity {
    private static final String LOG_TAG = "DBMainpulation => " ;
    DataRepository dataRepository ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_manipulation);

        dataRepository = DataRepository.getInstance(this.getApplicationContext()) ;
        showAllFoodItems();
    }

    private void showAllFoodItems(){
        // This is where is have used live Data i.e. Retrieving Data and setting up UI
        final TextView listTextView  = findViewById(R.id.activityDbManipulation_TextView_Status) ;

        LiveData<List<Object_FoodItem>> listLiveData = dataRepository.getListOfFoodItem_LiveData() ;
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