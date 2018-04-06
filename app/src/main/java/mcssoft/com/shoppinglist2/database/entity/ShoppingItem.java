package mcssoft.com.shoppinglist2.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "SHOPPING_ITEM")
public class ShoppingItem {

    //<editor-fold defaultstate="collapsed" desc="Region: Private">
    // Columns for SHOPPING_ITEM table.
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id") int id;                 // database row id.

    @NonNull
    @ColumnInfo(name = "Name") String Name;           // e.g. Carrot

    @NonNull
    @ColumnInfo(name = "TypeName") String TypeName;

    @NonNull
    @ColumnInfo(name = "TypeCode") String TypeCode;

    @ColumnInfo(name = "TypeSubCode") String SubCode;

    @NonNull
    @ColumnInfo(name = "Visible") boolean Visible;

    @NonNull
    @ColumnInfo(name = "Archive") boolean Archive;
    //</editor-fold>
}
/*
Property Meaning / Description Example
ID Unique identifier.
Name A general name. Carrot
Type A general type (class) name. Vegetable
TypeCode The type’s code. VGTBL
SubCode The type’s sub-code if applicable
Visible A flag to indicate display in list. Y
Archive A flag to indicate no longer used. N
 */