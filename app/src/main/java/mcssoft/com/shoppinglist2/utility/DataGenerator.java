package mcssoft.com.shoppinglist2.utility;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mcssoft.com.shoppinglist2.database.entity.ShoppingItemType;

/**
 * Simple utility to load app related data on app first run.
 */
public class DataGenerator {

    public DataGenerator(Context context) {

        try {
            is = context.getAssets().open("reference_values.xml");

        } catch (Exception ex) {

        }
    }

    public List<ShoppingItemType> patseForShoppingItemType() {
        List<ShoppingItemType> lSit = new ArrayList<>();


        return lSit;
    }

    private InputStream is;
//    /**
//     * Get a list of ShoppingItemType.
//     * @return The list.
//     */
//    public List<ShoppingItemType> getShoppingItemType() {
//        List<ShoppingItemType> lSit = new ArrayList<>();
//
//        lSit.add(new ShoppingItemType("FRUIT","NA",""));
//
//        lSit.add(new ShoppingItemType("MEAT","FISH",""));
//        lSit.add(new ShoppingItemType("MEAT","PORK",""));
//        lSit.add(new ShoppingItemType("MEAT","CHKEN",""));
//        lSit.add(new ShoppingItemType("MEAT","BEEF",""));
//        lSit.add(new ShoppingItemType("MEAT","LAMB",""));
//        lSit.add(new ShoppingItemType("MEAT","KNGRO",""));
//        lSit.add(new ShoppingItemType("MEAT","OTHER",""));
//
//        lSit.add(new ShoppingItemType("VGTBL","NA",""));
//
//        lSit.add(new ShoppingItemType("GENRL","CLTNG",""));
//        lSit.add(new ShoppingItemType("GENRL","HSHLD",""));
//        lSit.add(new ShoppingItemType("GENRL","GRDEN",""));
//        lSit.add(new ShoppingItemType("GENRL","OUTDR",""));
//        lSit.add(new ShoppingItemType("GENRL","PRSNL",""));
//        lSit.add(new ShoppingItemType("GENRL","OTHER",""));
//
//        return lSit;
//    }

}
