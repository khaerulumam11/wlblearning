package com.wlb.framework.learning.ui.main.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityMyContactBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.main.contacts.contactviewmodel.MyContacsViewModel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class MyContact extends BaseActivity<ActivityMyContactBinding, MyContacsViewModel>   {
    @Inject
    ViewModelProviderFactory factory;
    private ActivityMyContactBinding myContactBinding;
    private MyContacsViewModel myContacsViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyContact.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_contact;
    }

    @Override
    public MyContacsViewModel getViewModel() {
        myContacsViewModel = ViewModelProviders.of(this, factory).get(MyContacsViewModel.class);
        return myContacsViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContactBinding=getViewDataBinding();
    }

}
