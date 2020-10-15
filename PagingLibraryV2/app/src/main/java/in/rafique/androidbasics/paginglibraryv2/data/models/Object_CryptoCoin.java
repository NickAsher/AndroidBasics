package in.rafique.androidbasics.paginglibraryv2.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "CryptoCoin")
public class Object_CryptoCoin {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int mId;

    @ColumnInfo(name = "name")
    String mName ;

    @ColumnInfo(name = "symbol")
    String mSymbol ;


    public Object_CryptoCoin(int mId, String mName, String mSymbol) {
        this.mId = mId;
        this.mName = mName;
        this.mSymbol = mSymbol;
    }

    @Ignore
    public Object_CryptoCoin(String mName, String mSymbol) {
        this.mName = mName;
        this.mSymbol = mSymbol;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String mSymbol) {
        this.mSymbol = mSymbol;
    }

}
