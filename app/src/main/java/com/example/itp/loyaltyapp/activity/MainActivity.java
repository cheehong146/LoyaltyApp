package com.example.itp.loyaltyapp.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseActivity;
import com.example.itp.loyaltyapp.databinding.ActivityMainBinding;
import com.example.itp.loyaltyapp.fragment.HomeFragment;
import com.example.itp.loyaltyapp.model.Customer;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;



    FrameLayout frameMain;
    BottomNavigationView navBar;

//TODO VIEW MODEL
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initComponents();

        setupHomePage();
    }

    private void setupHomePage(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        HomeFragment homeFragment = HomeFragment.newInstance(getDummyCustomer(), getDummyData());
        ft.replace(R.id.frame_tab_frame, homeFragment);
        ft.commit();
    }

    private Customer getDummyCustomer (){
        Customer customer = new Customer("1", "Adam Settler", "https://www.morpht.com/sites/morpht/files/styles/landscape/public/dalibor-matura_1.jpg?itok=gxCAhwAV", "9999");
        return customer;
    }

//    private void setupHeaderDataAdapter(){
//        //TODO setup user
//        Customer customer = getDummyCustomer();
//
//        CustomerHeaderFragment homeHeaderFragment = CustomerHeaderFragment.newInstance(customer);
//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frame_home_header, homeHeaderFragment);
//        fragmentTransaction.commit();
//
//    }

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
        navBar = binding.navBar;


    }

    @Override
    public void setupListener() {
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()){
                    case R.id.menu_item_foodmenu:
                        return true;
                    case R.id.menu_item_redeem:
                        return true;
                    case R.id.menu_item_voucher:
                        return true;
                    case R.id.menu_item_located:
                        return true;
                    case R.id.menu_item_setting:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
        toolbarSettings();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            default:
                Log.d(TAG, "onClick: " + v.getId());
        }
    }

    @Override
    public void toolbarSettings() {
        Toolbar toolbar = binding.toolbarHome;
        setSupportActionBar(toolbar);
        //TODO title setting here
        TextView tvTitle = binding.tvToolbarHomeTitle;
        tvTitle.setText("Lekkers Cafe");

    }


}
