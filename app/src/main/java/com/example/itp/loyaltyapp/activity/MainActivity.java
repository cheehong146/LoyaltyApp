package com.example.itp.loyaltyapp.activity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.adapter.ShowcaseViewPagerAdapter;
import com.example.itp.loyaltyapp.base.BaseActivity;
import com.example.itp.loyaltyapp.databinding.ActivityMainBinding;
import com.example.itp.loyaltyapp.model.Customer;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    FrameLayout frameHeader;
    ViewPager viewpagerShowcase;
    TabLayout tabDotsShowcase;
    BottomNavigationView navBar;
//TODO VIEW MODEL
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initComponents();

        setupShowcaseDataAdapter();

        setupHeaderDataAdapter();
    }

    private void setupShowcaseDataAdapter(){
        ArrayList<ShowcaseItem> dummyData = getDummyData();

        ShowcaseViewPagerAdapter showcaseViewPagerAdapter = new ShowcaseViewPagerAdapter(getSupportFragmentManager(), this, dummyData);
        viewpagerShowcase.setAdapter(showcaseViewPagerAdapter);
    }

    private void setupHeaderDataAdapter(){
        //TODO setup user
        Customer customer = new Customer("1", "Lan Chee Hong", "http://blogs.cuit.columbia.edu/asj2122/files/2013/07/profile-894x1024.jpg", "9999");

    }

    private ArrayList<ShowcaseItem> getDummyData(){
        ArrayList<ShowcaseItem> items = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            items.add(new ShowcaseItem());
        }
        items.get(0).setName("Salmon seared");
        items.get(0).setImgUrl("https://images.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        items.get(0).setValidityDate("14/June-1997");
        items.get(1).setName("French Fries");
        items.get(1).setImgUrl("https://images.pexels.com/photos/70497/pexels-photo-70497.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        items.get(1).setValidityDate("14/June-1997");
        items.get(2).setName("Burrito");
        items.get(2).setImgUrl("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/2/14/0/FNK_breakfast-burrito_s4x3.jpg.rend.hgtvcom.616.462.suffix/1382542427230.jpeg");
        items.get(2).setValidityDate("14/June-1997");
        items.get(3).setName("Fried Noodles");
        items.get(3).setImgUrl("https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/02/07/15/chinese.jpg?w968h681");
        items.get(3).setValidityDate("14/June-1997");
        return items;
    }

    @Override
    public void bindComponents() {
        frameHeader = binding.frameHomeHeader;
        viewpagerShowcase = binding.viewpagerShowcase;
        tabDotsShowcase = binding.tabDots;
        navBar = binding.navBar;

        //viewpager and tabDots linkage
        tabDotsShowcase.setupWithViewPager(viewpagerShowcase, true);
    }

    @Override
    public void setupListener() {
        frameHeader.setOnClickListener(this);
        navBar.setOnClickListener(this);
        viewpagerShowcase.setOnClickListener(this);
        tabDotsShowcase.setOnClickListener(this);
    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

        }
    }
}
