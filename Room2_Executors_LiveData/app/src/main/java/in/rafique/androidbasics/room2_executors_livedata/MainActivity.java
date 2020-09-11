package in.rafique.androidbasics.room2_executors_livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import in.rafique.androidbasics.room2_executors_livedata.data.AppDatabase;
import in.rafique.androidbasics.room2_executors_livedata.data.AppExecutors;
import in.rafique.androidbasics.room2_executors_livedata.data.Objects.Object_FoodItem;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity => " ;
    AppDatabase db ;
    AppExecutors appExecutors ;
    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;
        db = AppDatabase.getInstance(this.getApplicationContext()) ;
        appExecutors = AppExecutors.getInstance() ;
    }

    public void oneTimeSetup(View v){

        final LiveData<List<Object_FoodItem>> listLiveData = db.foodDao().getListOfFoodItems_LiveData() ;
        listLiveData.observe(this, new Observer<List<Object_FoodItem>>() {
            @Override
            public void onChanged(List<Object_FoodItem> listOfItems) {
                listLiveData.removeObserver(this);

                if (listOfItems.size() == 0) {
                    listOfItems.add(new Object_FoodItem("Margherita Pizza"));
                    listOfItems.add(new Object_FoodItem("Double Cheese Pizza"));
                    listOfItems.add(new Object_FoodItem("Farmhouse "));
                    listOfItems.add(new Object_FoodItem("Peppy Paneer "));
                    listOfItems.add(new Object_FoodItem("Mexican Green Wave"));
                    listOfItems.add(new Object_FoodItem("Deluxe Veggie"));
                    listOfItems.add(new Object_FoodItem("Veggie Paradise"));
                    listOfItems.add(new Object_FoodItem("Veg ExtraVaganza"));
                    listOfItems.add(new Object_FoodItem("5 Pepper"));
                    listOfItems.add(new Object_FoodItem("Chef's Wonder"));
                    listOfItems.add(new Object_FoodItem("Cloud 9 "));
                    listOfItems.add(new Object_FoodItem("Hawaian Pizza"));
                    listOfItems.add(new Object_FoodItem("4 Cheese Pizza"));
                    listOfItems.add(new Object_FoodItem("Chilli Extreme"));
                    listOfItems.add(new Object_FoodItem("Chicken Pizza"));
                    listOfItems.add(new Object_FoodItem("Barbeque Pizza"));
                    listOfItems.add(new Object_FoodItem("Classic Pepperoni"));
                    listOfItems.add(new Object_FoodItem("Gouda and Ham Pizza"));
                    listOfItems.add(new Object_FoodItem("Fish Pizza"));
                    listOfItems.add(new Object_FoodItem("Gold Pizza"));


                    db.foodDao().insertListOfFoodItems(listOfItems);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(LOG_TAG, "Insertion Of Items Complete") ;
                        }
                    });

                }
                Toast.makeText(context, "One Time Setup Complete", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openDBManipulationActivity(View v){
        Intent intent = new Intent(this, Activity_DBManipulation.class) ;
        startActivity(intent) ;
    }
}