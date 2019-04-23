package com.wlb.framework.learning.ui.main.timeline.tfragmentMenu;

import android.os.Bundle;
import android.view.View;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.CtimelineCompaniesBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.CompaniesViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

public class MCompaniesFragment extends BaseFragment<CtimelineCompaniesBinding, CompaniesViewModel> {
    public static MCompaniesFragment newInstance() {
        Bundle args = new Bundle();
        MCompaniesFragment fragment = new MCompaniesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Inject
    ViewModelProviderFactory factory;
    private CompaniesViewModel CViewModel;
    private CtimelineCompaniesBinding TBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ctimeline_companies;
    }

    @Override
    public CompaniesViewModel getViewModel() {
        CViewModel = ViewModelProviders.of(this, factory).get(CompaniesViewModel.class);
        return CViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TBinding = getViewDataBinding();
    }
}
