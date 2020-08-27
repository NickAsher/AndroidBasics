package in.rafique.androidbasics.room1_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.rafique.androidbasics.room1_basic.data.AppDatabase;
import in.rafique.androidbasics.room1_basic.data.Objects.Object_FoodItem;

public class Activity_DBManipulation extends AppCompatActivity {
    private static final String LOG_TAG = "DBMainpulation => " ;
    AppDatabase db ;

    TextView statusTextView ;
    EditText newFoodItemNameEditText, deleteFoodItemByIdEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_manipulation);

        db = AppDatabase.getInstance(this.getApplicationContext()) ;
        getReferences() ;
    }

    private void getReferences(){
        statusTextView = findViewById(R.id.activityDbManipulation_TextView_Status) ;
        newFoodItemNameEditText = findViewById(R.id.activityDbManipulation_EditText_InsertItemName) ;
        deleteFoodItemByIdEditText = findViewById(R.id.activityDbManipulation_EditText_DeleteItemId) ;
    }

    public void showAllFoodItems(View v){
        List<Object_FoodItem> listOfItems = db.foodDao().getListOfFoodItems() ;
        statusTextView.setText("");
        for (Object_FoodItem foodItem : listOfItems){
            statusTextView.append(foodItem.getId() + " - " + foodItem.getName() + " - " + foodItem.getCreationDate() + " \n");
        }
    }

    public void showFoodItems_StartingWithC(View v){
        List<Object_FoodItem> listOfItems = db.foodDao().getListOfFoodItems_StartingWithC() ;
        statusTextView.setText("");
        for (Object_FoodItem foodItem : listOfItems){
            statusTextView.append(foodItem.getId() + " - " + foodItem.getName() + " - " + foodItem.getCreationDate() + " \n");
        }
    }

    public void insertNewFoodItem(View v){
        String newFoodItemName = newFoodItemNameEditText.getText().toString() ;
        Object_FoodItem newFoodItem = new Object_FoodItem(newFoodItemName) ;
        db.foodDao().insertNewFoodItem(newFoodItem);
        newFoodItemNameEditText.getText().clear();
        Toast.makeText(this, "Item Inserted, Refresh to see result", Toast.LENGTH_SHORT).show();

    }

    public void deleteFoodItemById(View v){
        String stringID = deleteFoodItemByIdEditText.getText().toString() ;
        Log.d(LOG_TAG, stringID) ;
        int id = Integer.parseInt(stringID);
        Log.d(LOG_TAG, "Integer Id is " + id) ;
        db.foodDao().deleteFoodItemById(id) ;
        deleteFoodItemByIdEditText.getText().clear();
        Toast.makeText(this, "Item Deleted, Refresh to see result", Toast.LENGTH_SHORT).show();
    }


}