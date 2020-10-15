package in.rafique.androidbasics.paginglibraryv2.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

import in.rafique.androidbasics.paginglibraryv2.data.models.Object_CryptoCoin;

public class DataRepository {
    Context context ;
    static DataRepository mInstance ;
    private AppDatabase db;
    private AppExecutors appExecutors ;


    private DataRepository(Context context){
        db = AppDatabase.getInstance(context) ;
        appExecutors = AppExecutors.getInstance() ;
    }

    public static DataRepository getInstance(Context context){
        if(mInstance == null){
            synchronized (DataRepository.class){
                if (mInstance == null){
                    mInstance = new DataRepository(context) ;
                }
            }
        }
        return mInstance ;
    }

    public LiveData<List<Object_CryptoCoin>> getListOfAllCoins_LiveData(){
        return db.CoinDao().getListOfAllCoins_LiveData() ;
    }

    public DataSource.Factory<Integer, Object_CryptoCoin> getListOfAllCoins_PositionalDataSource(){
        return db.CoinDao().getListOfAllCoins_DataSource() ;
    }


    public void insertListOfCoins(final List<Object_CryptoCoin> list){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.CoinDao().insertListOfCoins(list);
            }
        });
    }

    public List<Object_CryptoCoin> getFakeData(){
        List<Object_CryptoCoin> newListOfCoins = new ArrayList<>() ;

        newListOfCoins.add(new Object_CryptoCoin("BTC", "Bitcoin")) ;
        newListOfCoins.add(new Object_CryptoCoin("ETH", "Ethereum")) ;
        newListOfCoins.add(new Object_CryptoCoin("USDT", "USDT")) ;
        newListOfCoins.add(new Object_CryptoCoin("XRP", "Ripple")) ;
        newListOfCoins.add(new Object_CryptoCoin("DOT", "Polkadot")) ;
        newListOfCoins.add(new Object_CryptoCoin("BCH", "Bitcoin Cash")) ;
        newListOfCoins.add(new Object_CryptoCoin("BNB", "Binance Coin")) ;
        newListOfCoins.add(new Object_CryptoCoin("LINK", "Chainlink")) ;
        newListOfCoins.add(new Object_CryptoCoin("CRO", "Crypto.com Coin")) ;
        newListOfCoins.add(new Object_CryptoCoin("LTC", "Litecoin")) ;
        newListOfCoins.add(new Object_CryptoCoin("BSV", "Bitcoin SV")) ;
        newListOfCoins.add(new Object_CryptoCoin("ADA", "Cardano")) ;
        newListOfCoins.add(new Object_CryptoCoin("EOS", "EOS")) ;
        newListOfCoins.add(new Object_CryptoCoin("USDC", "USD Coin")) ;
        newListOfCoins.add(new Object_CryptoCoin("TRX", "Tron")) ;
        newListOfCoins.add(new Object_CryptoCoin("XTZ", "Tezos")) ;
        newListOfCoins.add(new Object_CryptoCoin("NEO", "Neo")) ;
        newListOfCoins.add(new Object_CryptoCoin("XLM", "Stellar")) ;
        newListOfCoins.add(new Object_CryptoCoin("XMR", "Monero")) ;
        newListOfCoins.add(new Object_CryptoCoin("LEO", "UNUS SED LEO")) ;
        newListOfCoins.add(new Object_CryptoCoin("ATOM", "Cosmos")) ;
        newListOfCoins.add(new Object_CryptoCoin("HT", "Huobi Token")) ;
        newListOfCoins.add(new Object_CryptoCoin("YFI", "Yearn.finance")) ;
        newListOfCoins.add(new Object_CryptoCoin("XEM", "NEM")) ;
        newListOfCoins.add(new Object_CryptoCoin("VET", "Vechain")) ;
        newListOfCoins.add(new Object_CryptoCoin("IOTA", "IOTA")) ;
        newListOfCoins.add(new Object_CryptoCoin("UMA", "UMA")) ;
        newListOfCoins.add(new Object_CryptoCoin("LEND", "AAve")) ;
        newListOfCoins.add(new Object_CryptoCoin("DASH", "Dash")) ;
        newListOfCoins.add(new Object_CryptoCoin("WBTC", "Wrapped Bitcoin")) ;
        newListOfCoins.add(new Object_CryptoCoin("ETC", "Ethereum Classic")) ;
        newListOfCoins.add(new Object_CryptoCoin("DAI", "Dai")) ;
        newListOfCoins.add(new Object_CryptoCoin("ZEC", "Zcash")) ;
        newListOfCoins.add(new Object_CryptoCoin("ONT", "Ontology")) ;
        newListOfCoins.add(new Object_CryptoCoin("TUSD", "TrueUSD")) ;
        newListOfCoins.add(new Object_CryptoCoin("MKR", "Maker")) ;
        newListOfCoins.add(new Object_CryptoCoin("THETA", "Theta")) ;
        newListOfCoins.add(new Object_CryptoCoin("OMG", "OMG Network")) ;
        newListOfCoins.add(new Object_CryptoCoin("SNX", "Synthetic Network")) ;
        newListOfCoins.add(new Object_CryptoCoin("BUSD", "Binance USD")) ;
        newListOfCoins.add(new Object_CryptoCoin("COMP", "Compund")) ;
        newListOfCoins.add(new Object_CryptoCoin("KSM", "Kusama")) ;
        newListOfCoins.add(new Object_CryptoCoin("ALGO", "Algorand")) ;
        newListOfCoins.add(new Object_CryptoCoin("BAT", "Basic Attention Token")) ;
        newListOfCoins.add(new Object_CryptoCoin("OKB", "OKB")) ;
        newListOfCoins.add(new Object_CryptoCoin("HEDG", "HedgeTrade")) ;
        newListOfCoins.add(new Object_CryptoCoin("FTT", "FTX Token")) ;
        newListOfCoins.add(new Object_CryptoCoin("DOGE", "DogeCoin")) ;
        newListOfCoins.add(new Object_CryptoCoin("BTT", "BitTorrent")) ;
        newListOfCoins.add(new Object_CryptoCoin("DGB", "DigiByte")) ;

        return newListOfCoins ;
    }




}
