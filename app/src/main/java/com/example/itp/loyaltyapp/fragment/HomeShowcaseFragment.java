package com.example.itp.loyaltyapp.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseFragment;
import com.example.itp.loyaltyapp.databinding.FragmentHomeShowcaseBinding;
import com.example.itp.loyaltyapp.model.Customer;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

public class HomeShowcaseFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "HomeShowcaseFragment";

    Customer customer;
    ShowcaseItem showcaseItem;

    FragmentHomeShowcaseBinding binding;

    TextView tvValidity, tvTitle;
    ImageView ivItem;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home_showcase, container, false);
        View view = binding.getRoot();

        initComponents();

        //TODO CHANGE TO VIEW MODEL
        showcaseItem = getArguments().getParcelable("showcaseItem");
        customer = getArguments().getParcelable("customer");

        if (showcaseItem != null)
            setupShowcaseAdapter();//TODO EH , views still visible, dots and validity date, with user header. imageview put placeholder

        if(customer != null)
            setupCustomerHeader();

        return view;
    }

    private void setupCustomerHeader(){
//        CustomerHeaderFragment customerHeaderFragment = CustomerHeaderFragment.newInstance(customer);
//        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_showcase_customer_header, customerHeaderFragment);
//        ft.commit();
        //TODO customer header dynamic
    }

    private void setupShowcaseAdapter() {
        //TODO DATA BIND INSTEAD OF SET TEXT
        try {

            handleValidityText();

            tvTitle.setText(showcaseItem.getName());
            Glide.with(this)
                    .asBitmap()
                    .transform(new CenterCrop(), new RoundedCorners(32))
                    .load(showcaseItem.getImgUrl())
                    .into(ivItem);
        } catch (NullPointerException e) {
            e.printStackTrace();
            //TODO HANDLE ERROR
        }

    }

    private void handleValidityText() {
        if (showcaseItem.getValidityDate() == null) {
            tvValidity.setVisibility(View.INVISIBLE);
        } else {
            if (!showcaseItem.getValidityDate().equals("")) {
                tvValidity.setText("Validity Date: " + showcaseItem.getValidityDate());
            } else {
                tvValidity.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void bindComponents() {
        tvValidity = binding.tvShowcaseValidity;
        tvTitle = binding.tvShowcaseTitle;
        ivItem = binding.ivShowcase;
    }

    @Override
    public void setupListener() {
        tvValidity.setOnClickListener(this);
        tvTitle.setOnClickListener(this);
        ivItem.setOnClickListener(this);
    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: " + v.getId());
    }
}
