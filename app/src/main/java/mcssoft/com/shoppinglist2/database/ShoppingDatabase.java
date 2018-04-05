package mcssoft.com.shoppinglist2.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import mcssoft.com.shoppinglist2.database.entity.ShoppingItem;
import mcssoft.com.shoppinglist2.database.entity.ShoppingItemType;
import mcssoft.com.shoppinglist2.database.entity.ShoppingList;
import mcssoft.com.shoppinglist2.database.entity.ShoppingListItem;
import mcssoft.com.shoppinglist2.utility.AppExecutors;

@Database(entities = {ShoppingItem.class, ShoppingItemType.class, ShoppingList.class, ShoppingListItem.class}, version = 1, exportSchema = false)
public abstract class ShoppingDatabase extends RoomDatabase {

    static synchronized public ShoppingDatabase getInstance(Context context, final AppExecutors executors) {
        if (instance == null) {
            synchronized (ShoppingDatabase.class) {
                if (instance == null) {
                    instance = create(context.getApplicationContext(), executors);
                    instance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return databaseCreated;
    }

    //    public abstract IShoppingDAO getShoppingDAO();

    private static ShoppingDatabase create(final Context context, final AppExecutors executors) {
        return Room.databaseBuilder(context, ShoppingDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            addDelay();
                            // Generate the data for pre-population
                            ShoppingDatabase database = ShoppingDatabase.getInstance(context, executors);
//                            List<ProductEntity> products = DataGenerator.generateProducts();
//                            List<CommentEntity> comments =
//                                    DataGenerator.generateCommentsForProducts(products);
//
//                            insertData(database, products, comments);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                }).build();

    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private static void addDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
        }
    }

    private void setDatabaseCreated(){
        databaseCreated.postValue(true);
    }

    private static volatile ShoppingDatabase instance;
    private static final String DATABASE_NAME = "SHOPPINGLIST";
    private final MutableLiveData<Boolean> databaseCreated = new MutableLiveData<>();

}
