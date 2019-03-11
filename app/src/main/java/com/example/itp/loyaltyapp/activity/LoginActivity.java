package com.example.itp.loyaltyapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseActivity;
import com.example.itp.loyaltyapp.base.helpers.UIHelper;
import com.example.itp.loyaltyapp.base.helpers.ValidationHelper;
import com.example.itp.loyaltyapp.databinding.ActivityLoginBinding;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.analytics.FirebaseAnalytics;

public class LoginActivity extends BaseActivity{

    private static final String TAG = "LoginActivity";

    //init helpers objects
    ValidationHelper validationHelper = new ValidationHelper();
    UIHelper uiHelper = new UIHelper();

    ActivityLoginBinding binding;

    TextView tvSeperatorOr;
    LoginButton btnFacebookSignIn;
    SignInButton btnGoogleSignIn;
    //bottom container (email login & signup) components
    Button btnEmailSignIn;
    TextView tvForgetPass;
    TextView tvSignUp;

    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
//        setContentView(R.layout.activity_login);

        initComponents();
        initFacebookLoginComponents();

        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.logEvent("tester", null);
    }

    private void initFacebookLoginComponents(){
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        btnFacebookSignIn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //When user login/register using facebook successfully
                Log.d(TAG, "onSuccess: " + loginResult.getAccessToken().getUserId());
                Log.d(TAG, "onSuccess: " + loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel: ");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError: ");
            }
        });
    }

    //abstracts method from BaseActivity
    @Override
    public void bindComponents() {
        tvSeperatorOr = binding.tvLoginOrSeperator;
        btnFacebookSignIn = binding.btnSignInFacebook;
        btnGoogleSignIn = binding.btnSignInGoogle;
        btnEmailSignIn = binding.btnLoginEmail;
        tvForgetPass = binding.tvLoginForgetPass;
        tvSignUp = binding.tvSignUp;
    }

    @Override
    public void setupListener() {
        tvForgetPass.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        btnEmailSignIn.setOnClickListener(this);
    }

    @Override
    public void initComponents() {
        bindComponents();
        setupListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login_forget_pass:
            break;

            case R.id.tv_sign_up:
            break;

            case R.id.btn_login_email:
                //test finish activity
                startMainActivity();
        }
    }
    //TODO facebook, google, or email login, signup, forgetpass
    //TODO validation for email and password before button click
    //TODO implement viewmodel for retaining user data, and ui text

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        //TODO pass user data to main
        startNewActivityWithFinish(this, intent);
    }

    @Override
    public void toolbarSettings() {
        //Login page, doesn't have toolbar
    }
}
