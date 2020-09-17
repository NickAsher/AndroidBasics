package in.rafique.androidbasics.room4_viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import in.rafique.androidbasics.room4_viewmodel.data.DataRepository;
import in.rafique.androidbasics.room4_viewmodel.data.Objects.Object_FoodItem;

public class ViewModel_DBMainpulation extends ViewModel {
    private static final String LOG_TAG = "ViewModel_DBManip =>" ;

    // all the things whose live data you need to observe in the activity
    LiveData<List<Object_FoodItem>> listOfFoodItems_LiveData ;
    LiveData<Object_FoodItem> firstFoodItem_LiveData ;

    public ViewModel_DBMainpulation(DataRepository dataRepository, int itemId){
        // instantiate all the livedata's you need here, in the constructor
        listOfFoodItems_LiveData = dataRepository.getListOfFoodItem_LiveData() ;
        firstFoodItem_LiveData = dataRepository.getFoodItem_ById(itemId) ;
    }

    public LiveData<List<Object_FoodItem>> getListOfFoodItems_LiveData() {
        return listOfFoodItems_LiveData;
    }

    public LiveData<Object_FoodItem> getFirstFoodItem_LiveData() {
        return firstFoodItem_LiveData;
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory{

        private DataRepository dataRepository ;
        private int itemId ;


        public Factory(Context context, int itemId){
            this.dataRepository = DataRepository.getInstance(context);
            this.itemId = itemId ;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ViewModel_DBMainpulation(dataRepository, itemId) ;
        }
    }

}
