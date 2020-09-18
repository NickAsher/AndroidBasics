package in.rafique.androidbasics.paginglibrary.z2_pagedDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;
import androidx.paging.PagingSource;

import in.rafique.androidbasics.paginglibrary.data.DataRepository;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;
import kotlin.jvm.functions.Function0;

public class ViewModel_PagingDB extends ViewModel {
    Context context ;
    DataRepository dataRepository ;
    LiveData<PagingData<Object_CryptoCoin>> pagedListOfCryptoCoins_LiveData ;


    public ViewModel_PagingDB(Context context, final DataRepository dataRepository) {
        this.context = context;
        this.dataRepository = dataRepository;


        Pager<Integer, Object_CryptoCoin> pager = new Pager<>(new PagingConfig(10, 1, false),
                new Function0<PagingSource<Integer, Object_CryptoCoin>>() {
                    @Override
                    public PagingSource<Integer, Object_CryptoCoin> invoke() {
                        return dataRepository.getListOfCryptoCoin_Paged();
                    }
                }) ;
        pagedListOfCryptoCoins_LiveData = PagingLiveData.getLiveData(pager) ;






    }

    public LiveData<PagingData<Object_CryptoCoin>> getPagedListOfCryptoCoins_LiveData() {
        return pagedListOfCryptoCoins_LiveData;
    }




    public static class MyFactory extends ViewModelProvider.NewInstanceFactory{
        Context context ;
        private DataRepository dataRepository ;


        public MyFactory(Context context){
            this.context = context ;
            this.dataRepository = DataRepository.getInstance(context);
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ViewModel_PagingDB(context, dataRepository) ;
        }
    }
}
