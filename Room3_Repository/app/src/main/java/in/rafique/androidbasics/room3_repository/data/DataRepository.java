package in.rafique.androidbasics.room3_repository.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import in.rafique.androidbasics.room3_repository.data.Objects.Object_FoodItem;

public class DataRepository {
    /* The class DataRepository is used as a single class for managing CRUD operations
     * But it is only used for 3 of these CRUD operations i.e. Create, Update & Delete
     * Read methods aren't put in dataRepository, because Read operations are tied to ViewModel
     * Because when we read data, we setup the UI based on that, so we set OBSERVERS when reading data
     * so we use ViewModel & LiveData there. So in Conclusion
     * DataRepository is used for CUD operation and for Reading => ViewModel & LiveData
     */

    /* Repository is especially useful when we introduce data from web
     * When fetching the data from web, we are also supposed to save/cache the data in our local database
     * Well, all that should be abstracted away from the app logic, It should all be done in repository
     *
     */

    /* Looks like repository is used for all 4 of CRUD operations
     * But for 3 CUD operations, it is used directly by UI i.e.activities, fragment, services
     * For the Read operation, the data goes through the ViewModel and then to UI(activity, Fragment)
     */

    /* The Repository class is made using the singleton pattern
     * as we generally have multiple threads (Background worker, services, content providers) all accessing it
     * so singleton pattern
     */

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
        // although in this app, i am directly passing the liveData from Repository => UI
        // but in a real app, you would pass this liveData from Repository => ViewModel => UI
        return db.foodDao().getListOfFoodItems_LiveData() ;
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
