package in.rafique.androidbasics.paginglibraryv2.data.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PositionalDataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

@Dao
public interface Dao_CryptoCoin {

    @Query("SELECT * FROM CryptoCoin ORDER BY id ASC")
    List<Object_CryptoCoin> getListOfAllCoins() ;

    @Query("SELECT * FROM CryptoCoin ORDER BY id ASC")
    LiveData<List<Object_CryptoCoin>> getListOfAllCoins_LiveData() ;

    @Query("SELECT * FROM CryptoCoin ORDER BY id ASC")
    DataSource.Factory<Integer, Object_CryptoCoin> getListOfAllCoins_DataSource() ;


    @Insert
    void insertNewCoin(Object_CryptoCoin foodItem) ;

    @Insert
    void insertListOfCoins(List<Object_CryptoCoin> listOfItems) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCoin(Object_CryptoCoin foodItem) ;

    @Delete
    void deleteCoin(Object_CryptoCoin foodItem) ;


}
