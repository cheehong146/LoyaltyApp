package com.example.itp.loyaltyapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseFragment;
import com.example.itp.loyaltyapp.databinding.FragmentHomeHeaderBinding;
import com.example.itp.loyaltyapp.model.Customer;

public class CustomerHeaderFragment extends BaseFragment {

    FragmentHomeHeaderBinding binding;

    private Customer customer;

    TextView tvTitle, tvUsername, tvPoints;
    ImageView ivProfilePic;

    public static CustomerHeaderFragment newInstance(Customer customer){
        CustomerHeaderFragment customerHeaderFragment = new CustomerHeaderFragment();
        Bundle args = new Bundle();
        args.putParcelable("customer", customer);
        customerHeaderFragment.setArguments(args);
        return customerHeaderFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.customer = getArguments().getParcelable("customer");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_header, container, false);

        initComponents();

        setupViewsWithData(customer);

        return binding.getRoot();
    }

    private void setupViewsWithData(Customer customer) {
        try {
            tvUsername.setText(customer.getUsername());
            tvPoints.setText(customer.getPoints());
            Glide
                    .with(this)
                    .asBitmap()
                    .transform(new CircleCrop())
                    .load(customer.getImgUrl())
                    .into(ivProfilePic);
            //todo if customer img invalid
        } catch (NullPointerException e) {
            //TODO EH
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public void bindComponents() {
        tvPoints = binding.tvHomeHeaderPointsVal;
        tvUsername = binding.tvHomeHeaderUsername;
        ivProfilePic = binding.ivHomeHeaderProfilePic;
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void initComponents() {
        bindComponents();
    }
}
