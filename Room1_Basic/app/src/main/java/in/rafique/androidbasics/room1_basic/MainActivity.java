package in.rafique.androidbasics.room1_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import in.rafique.androidbasics.room1_basic.data.AppDatabase;
import in.rafique.androidbasics.room1_basic.data.Objects.Object_FoodItem;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity => " ;
    AppDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getInstance(this.getApplicationContext()) ;

        

    }

    public void oneTimeSetup(View v){
        List<Object_FoodItem> listOfItems = db.foodDao().getListOfFoodItems() ;
        Log.d(LOG_TAG, "Doing the one time item loading task for a new database") ;
        if(listOfItems.size() == 0){
            

            listOfItems.add(new Object_FoodItem( "Margherita Pizza")); ;
            listOfItems.add(new Object_FoodItem( "Double Cheese Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Farmhouse ")) ;
            listOfItems.add(new Object_FoodItem( "Peppy Paneer ")) ;
            listOfItems.add(new Object_FoodItem( "Mexican Green Wave")) ;
            listOfItems.add(new Object_FoodItem( "Deluxe Veggie")) ;
            listOfItems.add(new Object_FoodItem( "Veggie Paradise")) ;
            listOfItems.add(new Object_FoodItem( "Veg ExtraVaganza")) ;
            listOfItems.add(new Object_FoodItem( "5 Pepper")) ;
            listOfItems.add(new Object_FoodItem( "Chef's Wonder")) ;
            listOfItems.add(new Object_FoodItem( "Cloud 9 ")) ;
            listOfItems.add(new Object_FoodItem( "Hawaian Pizza")) ;
            listOfItems.add(new Object_FoodItem( "4 Cheese Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Chilli Extreme")) ;
            listOfItems.add(new Object_FoodItem( "Chicken Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Barbeque Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Classic Pepperoni")) ;
            listOfItems.add(new Object_FoodItem( "Gouda and Ham Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Fish Pizza")) ;
            listOfItems.add(new Object_FoodItem( "Gold Pizza")) ;
            db.foodDao().insertListOfFoodItems(listOfItems);
            Log.d(LOG_TAG, "Items are inserted") ;

        }
        Log.d(LOG_TAG, "One time setup done") ;
    }
    
    public void openDBManipulationActivity(View v){
        Intent intent = new Intent(this, Activity_DBManipulation.class) ;
        startActivity(intent) ;
    }
}