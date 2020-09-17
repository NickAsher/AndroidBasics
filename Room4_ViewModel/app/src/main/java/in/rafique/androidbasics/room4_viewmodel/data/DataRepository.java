package in.rafique.androidbasics.room4_viewmodel.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import in.rafique.androidbasics.room4_viewmodel.data.Objects.Object_FoodItem;

public class DataRepository {

    static DataRepository mInstance ;
    AppDatabase db ;
    AppExecutors appExecutors;
    Context appContext ;


    private DataRepository(Context context){
        db = AppDatabase.getInstance(context) ;
        appExecutors = AppExecutors.getInstance() ;
    }

    public static DataRepository getInstance(Context context){
        if(mInstance == null){
            synchronized (DataRepository.class){
                if(mInstance == null){
                    mInstance = new DataRepository(context) ;
                }
            }
        }
        return mInstance ;
    }

    public LiveData<List<Object_FoodItem>> getListOfFoodItem_LiveData(){
        // Repository => ViewModel => UI
        return db.foodDao().getListOfFoodItems_LiveData() ;
    }

    public LiveData<Object_FoodItem> getFoodItem_ById(int itemId){
        return db.foodDao().getFoodItem_ById(itemId) ;
    }

    public void insertNewFoodItem(final Object_FoodItem foodItem){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().insertNewFoodItem(foodItem);
            }
        });
    }

    public void insertListOfFoodItems(final List<Object_FoodItem> listOfItems){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().insertListOfFoodItems(listOfItems);
            }
        });
    }

    public void updateFoodItem(final int itemId, final String itemName){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().updateFoodItem(itemId, itemName);
            }
        });

    }

    public void deleteFoodItem(final int itemId){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.foodDao().deleteFoodItemById(itemId);
            }
        });
    }



}
