package in.rafique.androidbasics.paginglibrary.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import in.rafique.androidbasics.paginglibrary.data.dao.Dao_CryptoCoin;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;


@Database(entities = {Object_CryptoCoin.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "MeraData.db" ;
    public static final Object LOCK = new Object() ;
    public static AppDatabase mInstance ;

    public static AppDatabase getInstance(Context appContext){
        if(mInstance == null){
            synchronized (LOCK){
                mInstance = Room.databaseBuilder(appContext.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                        .build() ;
            }
        }
        return mInstance ;
    }

    public abstract Dao_CryptoCoin cryptoCoinDao() ;



}
