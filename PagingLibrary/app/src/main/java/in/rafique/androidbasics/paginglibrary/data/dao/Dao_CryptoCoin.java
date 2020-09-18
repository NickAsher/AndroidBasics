package in.rafique.androidbasics.paginglibrary.data.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

@Dao
public interface Dao_CryptoCoin {

    @Query("SELECT * FROM table_CryptoCoin ORDER BY id ASC ")
    LiveData<List<Object_CryptoCoin>> getListOfCryptoCoin_LiveData() ;

    @Query("SELECT * FROM table_CryptoCoin ORDER BY id ASC ")
    PagingSource<Integer, Object_CryptoCoin> getListOfCryptoCoin_Paged() ;


    @Insert
    void insertNewCryptoCoin(Object_CryptoCoin cryptoCoin) ;

    @Insert
    void insertListOfCryptoCoin(List<Object_CryptoCoin> listOfItems) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCryptoCoin(Object_CryptoCoin cryptoCoin) ;

    @Delete
    void deleteCryptoCoin(Object_CryptoCoin cryptoCoin) ;

    @Query("DELETE FROM table_CryptoCoin ")
    void emptyTable() ;
}
