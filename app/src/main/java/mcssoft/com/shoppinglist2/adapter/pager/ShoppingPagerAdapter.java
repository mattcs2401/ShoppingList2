package mcssoft.com.shoppinglist2.adapter.pager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import butterknife.BindArray;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.ButterKnife;
import mcssoft.com.shoppinglist2.R;
import mcssoft.com.shoppinglist2.fragment.ShoppingFragment;

public class ShoppingPagerAdapter extends FragmentPagerAdapter {

    public ShoppingPagerAdapter(FragmentManager fMgr, Context context) {
        super(fMgr);
        ButterKnife.bind(this, new View(context));
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        Bundle bundle = new Bundle();
        ShoppingFragment fragment = new ShoppingFragment();
        bundle.putInt(key, position + 1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public String getPageTitle(int position) {
        return shopping_item_types[position].split(":")[1];
    }

    @Override
    public int getCount() {
        return num_shopping_item_pages;
    }

    @BindString(R.string.general_key) String key;
    @BindArray(R.array.shopping_item_types) String[] shopping_item_types;
    @BindInt(R.integer.num_shopping_item_pages) int num_shopping_item_pages;
}
