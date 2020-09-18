package in.rafique.androidbasics.paginglibrary.data.objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import javax.xml.namespace.QName;

@Entity(tableName = "table_CryptoCoin")
public class Object_CryptoCoin {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id ;

    @ColumnInfo(name = "symbol")
    String symbol ;

    @ColumnInfo(name = "name")
    String name ;


    public Object_CryptoCoin(int id, String symbol, String name) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    @Ignore
    public Object_CryptoCoin(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }



}
