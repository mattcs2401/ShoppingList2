package mcssoft.com.shoppinglist2.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "SHOPPING_LIST_ITEM")
public class ShoppingListItem {

    //<editor-fold defaultstate="collapsed" desc="Region: Private">
    // Columns for SHOPPING_LIST_ITEM table.
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id") int id;                 // database row id.

    //</editor-fold>
}
