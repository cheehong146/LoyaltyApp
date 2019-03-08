package com.example.itp.loyaltyapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.itp.loyaltyapp.fragment.HomeShowcaseFragment;
import com.example.itp.loyaltyapp.model.Item;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.List;

public class ShowcaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private List<ShowcaseItem> showcaseItemList;//will contain a list of images that is used to populate the viewpager

    public ShowcaseViewPagerAdapter(FragmentManager fm, Context context, List<ShowcaseItem> showcaseItemList) {
        super(fm);
        this.context = context;
        this.showcaseItemList = showcaseItemList;
    }

//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
////        ImageView imageView = new ImageView(context);
////        Glide
////                .with(context)
////                .asBitmap()
////                .load(showcaseItemList.get(position).getImgUrl())
////                .transform(new CenterCrop(), new RoundedCorners(32))
////                .into(imageView);
////        container.addView(imageView);
////        return  imageView;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view  = inflater.inflate(R.layout.fragment_home_showcase, container, false);
//        return view;
//    }

    @Override
    public Fragment getItem(int i) {
        HomeShowcaseFragment fragment = new HomeShowcaseFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("item", showcaseItemList.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return showcaseItemList.size();
    }
}
