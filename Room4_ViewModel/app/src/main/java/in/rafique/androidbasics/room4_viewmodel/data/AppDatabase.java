package in.rafique.androidbasics.room4_viewmodel.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import in.rafique.androidbasics.room4_viewmodel.data.Dao.Dao_FoodItem;
import in.rafique.androidbasics.room4_viewmodel.data.Objects.Object_FoodItem;


@Database(entities = {Object_FoodItem.class}, version = 1, exportSchema = false)
@TypeConverters({MyTypeConverters.class})

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

    public abstract Dao_FoodItem foodDao() ;



}
