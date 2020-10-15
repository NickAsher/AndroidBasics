package in.rafique.androidbasics.paginglibraryv2.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import in.rafique.androidbasics.paginglibraryv2.data.dao.Dao_CryptoCoin;
import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;


@Database(entities = {Object_CryptoCoin.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG = AppDatabase.class.getSimpleName() + "--> ";
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "crypto.db";
    private static AppDatabase instance ;

    public static AppDatabase getInstance(Context appContext){
        if(instance == null){
            synchronized (LOCK){
                Log.d(LOG_TAG, "Creating a new Database Instance") ;

                instance = Room.databaseBuilder(appContext.getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build() ;
            }
        }
        Log.d(LOG_TAG, "Getting the database instance") ;
        return instance ;
    }

    public abstract Dao_CryptoCoin CoinDao() ;




}
