package com.wlb.framework.learning.ui.main.bottommenu.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.EditProfileContactInfoBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.login.LoginActivity;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.EditProfileViewModel;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

public class EditProfile extends BaseActivity<EditProfileContactInfoBinding, EditProfileViewModel> {
    @Inject
    ViewModelProviderFactory factory;
    private EditProfileViewModel mProfileViewModel;
    private EditProfileContactInfoBinding mBinding;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        return new Intent(context, EditProfile.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.edit_profile_contact_info;
    }

    @Override
    public EditProfileViewModel getViewModel() {
        mProfileViewModel = ViewModelProviders.of(this, factory).get(EditProfileViewModel.class);
        return mProfileViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        mToolbar = mBinding.toolbar;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
