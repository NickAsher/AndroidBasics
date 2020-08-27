package in.rafique.androidbasics.room2_executors_livedata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

import in.rafique.androidbasics.room2_executors_livedata.data.AppDatabase;
import in.rafique.androidbasics.room2_executors_livedata.data.AppExecutors;
import in.rafique.androidbasics.room2_executors_livedata.data.Objects.Object_FoodItem;


public class Activity_DBManipulation extends AppCompatActivity {
    private static final String LOG_TAG = "DBMainpulation => " ;
    AppDatabase db ;
    AppExecutors appExecutors ;

    TextView statusTextView ;
    EditText newFoodItemNameEditText, deleteFoodItemByIdEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_manipulation);

        db = AppDatabase.getInstance(this.getApplicationContext()) ;
        appExecutors = AppExecutors.getInstance() ;
        getReferences() ;
    }

    private void getReferences(){
        statusTextView = findViewById(R.id.activityDbManipulation_TextView_Status) ;
        newFoodItemNameEditText = findViewById(R.id.activityDbManipulation_EditText_InsertItemName) ;
        deleteFoodItemByIdEditText = findViewById(R.id.activityDbManipulation_EditText_DeleteItemId) ;
    }

    public void showAllFoodItems(View v){
        LiveData<List<Object_FoodItem>> listLiveData = db.foodDao().getListOfFoodItems_LiveData() ;
        listLiveData.observe(this, new Observer<List<Object_FoodItem>>() {
            @Override
            public void onChanged(List<Object_FoodItem> listOfItems) {
                statusTextView.setText("");
                for (Object_FoodItem foodItem : listOfItems){
                    statusTextView.append(foodItem.getId() + " - " + foodItem.getName() + " - " + foodItem.getCreationDate() + " \n");
                }
            }
        });

    }



    public void insertNewFoodItem(View v){
        String newFoodItemName = newFoodItemNameEditText.getText().toString() ;
        newFoodItemNameEditText.getText().clear();
        final Object_FoodItem newFoodItem = new Object_FoodItem(newFoodItemName) ;

        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().insertNewFoodItem(newFoodItem);
            }
        });

    }

    public void deleteFoodItemById(View v){
        final int id = Integer.parseInt(deleteFoodItemByIdEditText.getText().toString() );
        deleteFoodItemByIdEditText.getText().clear();
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().deleteFoodItemById(id) ;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // do anything on UI , you want to do after completion
                    }
                });
            }
        });
    }


}