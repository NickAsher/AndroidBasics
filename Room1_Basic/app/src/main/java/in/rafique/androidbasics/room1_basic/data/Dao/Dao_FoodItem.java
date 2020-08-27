package in.rafique.androidbasics.room1_basic.data.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import in.rafique.androidbasics.room1_basic.data.Objects.Object_FoodItem;

@Dao
public interface Dao_FoodItem {

    @Query("SELECT * FROM table_foodItem ORDER BY id ASC ")
    List<Object_FoodItem> getListOfFoodItems() ;

    @Query("SELECT * FROM table_foodItem WHERE name LIKE 'C%' ORDER BY id ASC")
    List<Object_FoodItem> getListOfFoodItems_StartingWithC() ;

    @Insert
    void insertNewFoodItem(Object_FoodItem foodItem) ;

    @Insert
    void insertListOfFoodItems(List<Object_FoodItem> listOfItems) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFoodItem(Object_FoodItem foodItem) ;

    @Delete
    void deleteFoodItem(Object_FoodItem foodItem) ;

    @Query("DELETE FROM table_foodItem WHERE id = :id")
    void deleteFoodItemById(int id) ;


}
