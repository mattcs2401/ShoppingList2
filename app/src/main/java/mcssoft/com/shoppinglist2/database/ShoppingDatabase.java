package mcssoft.com.shoppinglist2.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

//@Database(entities = {ShoppingItem.class, ReferenceValues.class}, version = 1, exportSchema = false)
public abstract class ShoppingDatabase extends RoomDatabase {

    static synchronized public ShoppingDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

//    public abstract IShoppingDAO getShoppingDAO();
//    public abstract IReferenceDAO getReferenceDAO();

    private static ShoppingDatabase create(final Context context) {
        return Room.databaseBuilder(context, ShoppingDatabase.class, "SHOPPINGLIST").build();
    }

    private static volatile ShoppingDatabase instance;
}
