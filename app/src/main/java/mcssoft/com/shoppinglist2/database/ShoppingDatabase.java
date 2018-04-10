package mcssoft.com.shoppinglist2.database;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import mcssoft.com.shoppinglist2.interfaces.room.IRefItemDAO;
import mcssoft.com.shoppinglist2.utility.DataGenerator;

abstract class ShoppingDatabase extends RoomDatabase {

    static synchronized ShoppingDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = create(context);
            setDatabaseCreated(context);
        }
        return instance;
    }

    public static void setDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            databaseCreated.postValue(true);
        } else {
            databaseCreated.postValue(false);
        }
    }

    public abstract IRefItemDAO getRefItemDAO();

    private static ShoppingDatabase create(final Context context) {
        return Room.databaseBuilder(context, ShoppingDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                DataGenerator dGen = new DataGenerator(context);
                                getInstance(context).getRefItemDAO().insertRefVals(dGen.patseForShoppingItemType());
                            }
                        });
                    }
                })
                .build();
    }

    private static volatile ShoppingDatabase instance = null;
    private static final String DATABASE_NAME = "SHOPPINGLIST";
    private static final MutableLiveData<Boolean> databaseCreated = new MutableLiveData<>();
}
