package in.rafique.androidbasics.paginglibrary.z1_normal;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.rafique.androidbasics.paginglibrary.data.DataRepository;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;

public class ViewModel_Normal extends ViewModel {
    private LiveData<List<Object_CryptoCoin>> listOfCryptoCoins_LiveData ;

    public ViewModel_Normal(Context context, DataRepository dataRepository) {
        this.listOfCryptoCoins_LiveData = dataRepository.getListOfCryptoCoin_LiveData() ;
    }

    public LiveData<List<Object_CryptoCoin>> getListOfCryptoCoins_LiveData() {
        return listOfCryptoCoins_LiveData;
    }




    public static class Factory extends ViewModelProvider.NewInstanceFactory{
        Context context ;
        private DataRepository dataRepository ;


        public Factory(Context context){
            this.context = context ;
            this.dataRepository = DataRepository.getInstance(context);
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ViewModel_Normal(context, dataRepository) ;
        }
    }

}
