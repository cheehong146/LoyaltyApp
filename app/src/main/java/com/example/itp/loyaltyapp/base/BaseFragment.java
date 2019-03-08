package com.example.itp.loyaltyapp.base;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onClick(View v) {

    }

    public abstract void bindComponents();

    public abstract void setupListener();

    public abstract void initComponents();
}
