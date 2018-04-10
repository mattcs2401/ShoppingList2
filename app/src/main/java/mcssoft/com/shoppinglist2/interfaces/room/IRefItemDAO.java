package mcssoft.com.shoppinglist2.interfaces.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import mcssoft.com.shoppinglist2.database.entity.ShoppingItemType;

@Dao
public interface IRefItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public List<Long> insertRefVals(List<ShoppingItemType> lRefValues);
}
