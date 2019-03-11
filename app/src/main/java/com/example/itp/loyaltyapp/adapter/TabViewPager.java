package com.example.itp.loyaltyapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.itp.loyaltyapp.fragment.HomeShowcaseFragment;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.List;

public class TabViewPager extends ViewPager {
    public TabViewPager(@NonNull Context context) {
        super(context);
    }

//    class TabViewPagerAdapter extends FragmentStatePagerAdapter {
//        private Context context;
//
//        public TabViewPagerAdapter(FragmentManager fm, Context context, List<ShowcaseItem> showcaseItemList) {
//            super(fm);
//            this.context = context;
//            this.showcaseItemList = showcaseItemList;
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            HomeShowcaseFragment fragment = new HomeShowcaseFragment();
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("item", showcaseItemList.get(i));
//            fragment.setArguments(bundle);
//            return fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return showcaseItemList.size();
//        }
//    }
}


