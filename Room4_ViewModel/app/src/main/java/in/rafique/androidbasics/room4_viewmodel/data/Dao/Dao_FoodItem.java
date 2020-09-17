package in.rafique.androidbasics.room4_viewmodel.data.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import in.rafique.androidbasics.room4_viewmodel.data.Objects.Object_FoodItem;


@Dao
public interface Dao_FoodItem {

    @Query("SELECT * FROM table_foodItem ORDER BY id ASC ")
    LiveData<List<Object_FoodItem>> getListOfFoodItems_LiveData() ;

    @Query("SELECT * FROM table_foodItem WHERE id = :id ")
    LiveData<Object_FoodItem> getFoodItem_ById(int id) ;

    @Insert
    void insertNewFoodItem(Object_FoodItem foodItem) ;

    @Insert
    void insertListOfFoodItems(List<Object_FoodItem> listOfItems) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFoodItem(Object_FoodItem foodItem) ;

    @Query("UPDATE table_foodItem SET name = :newName WHERE id = :id")
    void updateFoodItem(int id, String newName) ;

    @Delete
    void deleteFoodItem(Object_FoodItem foodItem) ;

    @Query("DELETE FROM table_foodItem WHERE id = :id")
    void deleteFoodItemById(int id) ;


}
