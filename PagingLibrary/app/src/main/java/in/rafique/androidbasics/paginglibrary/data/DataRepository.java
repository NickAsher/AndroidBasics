package in.rafique.androidbasics.paginglibrary.data;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;

import java.util.List;

import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

public class DataRepository {

    static DataRepository mInstance ;
    AppDatabase db ;
    AppExecutors appExecutors;
    Context appContext ;


    private DataRepository(Context context){
        appContext = context ;
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

    public LiveData<List<Object_CryptoCoin>> getListOfCryptoCoin_LiveData(){
        Toast.makeText(appContext, "Getting list of cryptoCoins", Toast.LENGTH_SHORT).show();
        return db.cryptoCoinDao().getListOfCryptoCoin_LiveData() ;
    }

    public PagingSource<Integer, Object_CryptoCoin> getListOfCryptoCoin_Paged(){
        return db.cryptoCoinDao().getListOfCryptoCoin_Paged() ;
    }




    public void insertNewCryptoCoin(final Object_CryptoCoin cryptoCoin){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.cryptoCoinDao().insertNewCryptoCoin(cryptoCoin);
            }
        });
    }

    public void insertListOfCryptoCoins(final List<Object_CryptoCoin> listOfItems){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.cryptoCoinDao().insertListOfCryptoCoin(listOfItems);
            }
        });
    }


    public void deleteCryptoCoin(final Object_CryptoCoin cryptoCoin){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.cryptoCoinDao().deleteCryptoCoin(cryptoCoin);
            }
        });
    }

    public void deleteAllCryptoCoins(){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.cryptoCoinDao().emptyTable();
            }
        });
    }



}
