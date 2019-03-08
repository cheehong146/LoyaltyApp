package com.example.itp.loyaltyapp.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseFragment;
import com.example.itp.loyaltyapp.databinding.FragmentHomeHeaderBinding;

public class HomeHeaderAdapter extends BaseFragment implements View.OnClickListener{

    FragmentHomeHeaderBinding binding;

    TextView tvUsername, tvPoints;
    ImageView ivProfilePic;
    TextView tvHeaderTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_header, container, false);

        initComponents();

        //TODO populate data here

        return view;
    }

    @Override
    public void bindComponents() {
        tvUsername = binding.tvHomeHeaderUsername;
        tvPoints = binding.tvHomeHeaderPointsVal;
        tvHeaderTitle = binding.tvHomeHeaderTitle;
        ivProfilePic = binding.ivHomeHeaderProfilePic;
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
