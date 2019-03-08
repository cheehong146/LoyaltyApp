package com.example.itp.loyaltyapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.itp.loyaltyapp.base.BaseActivity;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    ActivitySplashBinding binding;

    ProgressBar loadingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        initComponents();

        handleUserLoginAccess();
    }

    private void handleUserLoginAccess(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("userData", Context.MODE_PRIVATE);
        Boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if(isLoggedIn){
            //validate with API using userId and password
            String userId = sharedPreferences.getString("userId", null);
            String password = sharedPreferences.getString("userPassword", null);

            if (isUserValidatedWithApi(userId, password)){
                Intent launchMainActivity = new Intent (this, MainActivity.class);
                Bundle userDetailBundle = new Bundle();
                userDetailBundle.putString("userId", userId);
                launchMainActivity.putExtras(userDetailBundle);
                startNewActivityWithFinish(this, launchMainActivity);
            }else{
                //TODO prompt something wrong with validating cur userid and pass with server
            }
        }else{
            //no userId Found in internal storage, bring up login options activity
            Intent loginSignupIntent = new Intent(this, LoginActivity.class);
            startNewActivityWithFinish(this, loginSignupIntent);
        }
    }

    private void login(){

    }

    private boolean isUserValidatedWithApi(String userId, String password){
        //TODO call api
        boolean isValidated = false;
        return isValidated;
    }

    private void retrieveUserData(){

    }

    private void errorLogin(){

    }

//    private void isLastestVersion(){
//
//    }
//
//    private void verifyVersion(){
//
//    }


    //abstract method from BaseActivity
    @Override
    public void bindComponents() {
        loadingSpinner = binding.progressCircularSplashScreen;
    }

    @Override
    public void setupListener() {

    }

    @Override
    public void initComponents() {
        bindComponents();
    }

    @Override
    public void onClick(View v) {

    }
}
