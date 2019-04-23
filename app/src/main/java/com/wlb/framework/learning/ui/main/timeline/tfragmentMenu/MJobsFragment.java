package com.wlb.framework.learning.ui.main.timeline.tfragmentMenu;

import android.os.Bundle;
import android.view.View;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.CtimelineCompaniesBinding;
import com.wlb.framework.learning.databinding.CtimelineJobsBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.CompaniesViewModel;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.JobsViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

public class MJobsFragment extends BaseFragment<CtimelineJobsBinding, JobsViewModel> {
    public static MJobsFragment newInstance() {
        Bundle args = new Bundle();
        MJobsFragment fragment = new MJobsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Inject
    ViewModelProviderFactory factory;
    private JobsViewModel CViewModel;
    private CtimelineJobsBinding TBinding;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ctimeline_jobs;
    }

    @Override
    public JobsViewModel getViewModel() {
        CViewModel = ViewModelProviders.of(this, factory).get(JobsViewModel.class);
        return CViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TBinding = getViewDataBinding();
    }
}
