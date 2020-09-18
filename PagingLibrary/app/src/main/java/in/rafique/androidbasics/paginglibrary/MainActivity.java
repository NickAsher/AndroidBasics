package in.rafique.androidbasics.paginglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.rafique.androidbasics.paginglibrary.data.DataRepository;
import in.rafique.androidbasics.paginglibrary.data.objects.Object_CryptoCoin;
import in.rafique.androidbasics.paginglibrary.z1_normal.Activity1_NormalRecyclerView;
import in.rafique.androidbasics.paginglibrary.z2_pagedDB.Activity2_PagedDB;

public class MainActivity extends AppCompatActivity {
    Context context ;
    DataRepository dataRepository ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext() ;
        dataRepository = DataRepository.getInstance(context) ;
    }

    public void oneTimeSetup(View v){
        final LiveData<List<Object_CryptoCoin>> liveData = dataRepository.getListOfCryptoCoin_LiveData() ;
        liveData.observe(this, new Observer<List<Object_CryptoCoin>>() {
            @Override
            public void onChanged(List<Object_CryptoCoin> listOfItems) {
                liveData.removeObserver(this);

                if(listOfItems.size() == 0){
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

                    dataRepository.insertListOfCryptoCoins(newListOfCoins);
                    Toast.makeText(context, "One Time Setup is now complete", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void showNormal_RecyclerView(View v){
        Intent intent = new Intent(this, Activity1_NormalRecyclerView.class) ;
        startActivity(intent);
    }

    public void showPagedFromDB_RecyclerView(View v){
        Intent intent = new Intent(this, Activity2_PagedDB.class) ;
        startActivity(intent);
    }
}