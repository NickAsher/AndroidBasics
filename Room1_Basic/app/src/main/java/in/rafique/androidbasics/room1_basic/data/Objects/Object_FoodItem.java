package in.rafique.androidbasics.room1_basic.data.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "table_foodItem")
public class Object_FoodItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int mId;

    @ColumnInfo(name = "name")
    String mName ;

    @ColumnInfo(name = "creationDate")
    Date mCreationDate ;

    public Object_FoodItem(int mId, String mName, Date creationDate) {
        this.mId = mId;
        this.mName = mName;
        this.mCreationDate = creationDate;
    }

    @Ignore
    public Object_FoodItem(String mName,  Date mCreationDate) {
        this.mName = mName;
        this.mCreationDate = mCreationDate;
    }

    @Ignore
    public Object_FoodItem(String mName) {
        this.mName = mName;
        this.mCreationDate = new Date() ;
    }




    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


    public Date getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.mCreationDate = creationDate;
    }
}
