package com.example.itp.loyaltyapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.adapter.ShowcaseViewPagerAdapter;
import com.example.itp.loyaltyapp.base.BaseFragment;
import com.example.itp.loyaltyapp.databinding.FragmentHomeBinding;
import com.example.itp.loyaltyapp.model.Customer;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    //data
    Customer customer;
    List<ShowcaseItem> showcaseItems;

    //binding
    FragmentHomeBinding binding;

    //ui components
    ViewPager viewpagerShowcase;
    TabLayout tabDotsShowcase;

    //listener for when users click on the image of the food
    OnShowcaseItemSelectedListener showcaseItemSelectedListener;

    public static HomeFragment newInstance(Customer customer, List<ShowcaseItem> item) {
        Bundle args = new Bundle();
        args.putParcelable("customer", customer);
        args.putParcelableArrayList("showcaseItems", new ArrayList<Parcelable>(item));
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            customer = getArguments().getParcelable("customer");
            showcaseItems = getArguments().getParcelableArrayList("showcaseItems");
        } catch (NullPointerException e) {
            e.printStackTrace();//TODO EH
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        initComponents();
        setupShowcaseDataAdapter();

        return binding.getRoot();
    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
    }

    @Override
    public void bindComponents() {
        viewpagerShowcase = binding.viewpagerShowcase;
        tabDotsShowcase = binding.tabDots;

    }

    @Override
    public void setupListener() {
        viewpagerShowcase.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                
            }

            @Override
            public void onPageSelected(int i) {
                showcaseItemSelectedListener.onShowcaseItemSelected(showcaseItems.get(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void setupShowcaseDataAdapter() {
        //      viewpager and tabDots linkage
        tabDotsShowcase.setupWithViewPager(viewpagerShowcase, true);
        ShowcaseViewPagerAdapter showcaseViewPagerAdapter = new ShowcaseViewPagerAdapter(getChildFragmentManager(), getActivity(), showcaseItems);
        viewpagerShowcase.setAdapter(showcaseViewPagerAdapter);
    }

    public interface OnShowcaseItemSelectedListener {
        void onShowcaseItemSelected(ShowcaseItem showcaseItem);
    }
}
