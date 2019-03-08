package com.example.itp.loyaltyapp.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseFragment;

public class HomeHeaderAdapter extends BaseFragment implements View.OnClickListener{

    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_header, container, false);

        initComponents();

        return view;
    }

    @Override
    public void bindComponents() {

    }

    @Override
    public void setupListener() {

    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
    }
}
