/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.wlb.framework.learning.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.google.gson.JsonObject;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.ApiError;
import com.wlb.framework.learning.databinding.ActivityLoginWlbBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.LearningActivity;
import com.wlb.framework.learning.ui.login.modelui.LoginFields;
import com.wlb.framework.learning.ui.main.MainActivity;
import com.wlb.framework.learning.ui.register.RegisterActivity;
import com.wlb.framework.learning.utils.AppLogger;

import javax.inject.Inject;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by MHBX on 12/03/19.
 */

public class LoginActivity extends BaseActivity<ActivityLoginWlbBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginWlbBinding mActivityLoginBinding;
    private String[] language = {"English (US)", "Bahasa Indonesia"};

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_wlb;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
        AppLogger.e(throwable,"Login Error",LoginActivity.this);
    }

    @Override
    public void handleErrorNetwork(ANError error) {
        ApiError apiError = error.getErrorAsObject(ApiError.class);
        ShowSnackBar(mActivityLoginBinding.cdlLogin,apiError.getMessage());
    }

    private void setupLanguage() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language);
        mActivityLoginBinding.spinLanguage.setAdapter(adapter);
    }
    @Override
    public void login() {
        String email = mActivityLoginBinding.etEmail.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();
        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            if (isNetworkConnected()){
                mLoginViewModel.Loginv2(email, password);
            }else{
                ShowSnackBar(mActivityLoginBinding.cdlLogin,getString(R.string.no_internet));
            }
        } else {
            hideKeyboard();
            ShowSnackBar(mActivityLoginBinding.cdlLogin,getString(R.string.invalid_email_password));
        }
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLearning() {
        Intent intent = LearningActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openRegister() {
        Log.i("Login", "openRegister");
        Intent intent = RegisterActivity.newIntent(LoginActivity.this);
        startActivity(intent);
    }

    @Override
    public void openSnack(String message) {
        ShowSnackBar(mActivityLoginBinding.cdlLogin,message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
        setupLanguage();
    }
}
