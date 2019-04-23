package com.wlb.framework.learning.ui.shopcart;

import android.os.Bundle;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityShoppingCartBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class ShoppingCart extends BaseActivity<ActivityShoppingCartBinding, ShopCartViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    private ShopCartViewModel mShopCartViewModel;
    private ActivityShoppingCartBinding mActivityShoppingCartBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public ShopCartViewModel getViewModel() {
        mShopCartViewModel = ViewModelProviders.of(this, factory).get(ShopCartViewModel.class);
        return mShopCartViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityShoppingCartBinding = getViewDataBinding();
    }
}
