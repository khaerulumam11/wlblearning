package com.wlb.framework.learning.ui.main.timeline.tfragmentMenu;

import android.os.Bundle;
import android.view.View;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.CtimelinePostingBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.PostingViewModel;
import javax.inject.Inject;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

public class MPostingFragment extends BaseFragment<CtimelinePostingBinding, PostingViewModel> {
    public static MPostingFragment newInstance() {
        Bundle args = new Bundle();
        MPostingFragment fragment = new MPostingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    private PostingViewModel CViewModel;
    private CtimelinePostingBinding TBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ctimeline_posting;
    }

    @Override
    public PostingViewModel getViewModel() {
        CViewModel = ViewModelProviders.of(this, factory).get(PostingViewModel.class);
        return CViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TBinding = getViewDataBinding();
    }
}
