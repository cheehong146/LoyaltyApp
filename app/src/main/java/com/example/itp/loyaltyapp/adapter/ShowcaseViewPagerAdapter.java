package com.example.itp.loyaltyapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.example.itp.loyaltyapp.fragment.HomeShowcaseFragment;
import com.example.itp.loyaltyapp.model.Item;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.List;

public class ShowcaseViewPagerAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = "ShowcaseViewPagerAdapter";
    private Context context;
    private List<ShowcaseItem> showcaseItemList;//will contain a list of images that is used to populate the viewpager

    public ShowcaseViewPagerAdapter(FragmentManager fm, Context context, List<ShowcaseItem> showcaseItemList) {
        super(fm);
        this.context = context;
        this.showcaseItemList = showcaseItemList;
    }

    @Override
    public Fragment getItem(int i) {
        HomeShowcaseFragment fragment = new HomeShowcaseFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("showcaseItem", showcaseItemList.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return showcaseItemList.size();
    }
}

