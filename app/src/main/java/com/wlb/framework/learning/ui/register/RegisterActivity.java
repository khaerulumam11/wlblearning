package com.wlb.framework.learning.ui.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityRegisterBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.login.LoginActivity;
import com.wlb.framework.learning.ui.main.MainActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

/**
 * Created by MHBX on 08/03/19.
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> implements RegisterNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private RegisterViewModel mRegViewModel;
    private ActivityRegisterBinding mActivityRegister;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterViewModel getViewModel() {
        mRegViewModel = ViewModelProviders.of(this, factory).get(RegisterViewModel.class);
        return mRegViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityRegister = getViewDataBinding();
        mRegViewModel.setNavigator(this);
    }

    @Override
    public void handleError(Throwable throwable) {
        ShowMessages(this, throwable.getMessage());
    }

    @Override
    public void oPenlogin() {
        Intent intent = LoginActivity.newIntent(RegisterActivity.this);
        startActivity(intent);
        finish();
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void FormValidation() {
        String email = mActivityRegister.etRegEmail.getText().toString();
        String fname = mActivityRegister.etRegFname.getText().toString();
        String lname = mActivityRegister.etRegLname.getText().toString();
        String password = mActivityRegister.etRegPwd1.getText().toString();
        String password2 = mActivityRegister.etRegPwd2.getText().toString();

        if (!mRegViewModel.isEmailValid(email)) {
            mActivityRegister.etRegEmail.setError(getResources().getString(R.string.not_valid, "email"));
        } else if (fname.isEmpty()) {
            mActivityRegister.etRegFname.setError(getResources().getString(R.string.cannot_empty));
        } else if (lname.isEmpty()) {
            mActivityRegister.etRegLname.setError(getResources().getString(R.string.cannot_empty));
        } else if (password.isEmpty()) {
            mActivityRegister.etRegPwd1.setError(getResources().getString(R.string.cannot_empty));
        } else if (mActivityRegister.etRegPwd1.length() <= 8) {
            mActivityRegister.etRegPwd1.setError(getResources().getString(R.string.cant_lesthan, "password", "8 Character"));
        } else if (password2.isEmpty()) {
            mActivityRegister.etRegPwd2.setError(getResources().getString(R.string.cannot_empty));
        } else if (mActivityRegister.etRegPwd1.length() <= 8) {
            mActivityRegister.etRegPwd2.setError(getResources().getString(R.string.cant_lesthan, "password", "8 Character"));
        } else if (!password.equals(password2)) {
            mActivityRegister.etRegLname.setError(getResources().getString(R.string.not_same, "Password"));
        } else {
            mRegViewModel.Register(email, password, fname + " " + lname);
        }
    }
}
