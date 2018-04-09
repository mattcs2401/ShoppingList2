package mcssoft.com.shoppinglist2.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "SHOPPING_ITEM_TYPE")
public class ShoppingItemType {

    public ShoppingItemType(@NonNull String code, @NonNull String subCode, String description) {
//        this.id = id;
        this.code = code;
        this.subCode = subCode;
        this.description = description;
    }

    //<editor-fold defaultstate="collapsed" desc="Region: Getter/Setter">
    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    @NonNull
    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(@NonNull String subCode) {
        this.subCode = subCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>

    // Columns for SHOPPING_ITEM_TYPE table.
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id") int id;                 // database row id.

    @NonNull
    @ColumnInfo(name = "Code") String code;

    @NonNull
    @ColumnInfo(name = "SubCode") String subCode;

    @ColumnInfo(name = "Description") String description;

//    @NonNull
//    @ColumnInfo(name = "Archive") String archive;
}
