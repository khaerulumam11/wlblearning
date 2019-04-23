package com.wlb.framework.learning.ui.main.timeline.tfragmentMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.CtimelineArticlesBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.ArticleViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class MArticleFragment extends BaseFragment<CtimelineArticlesBinding, ArticleViewModel> {
    public static MArticleFragment newInstance() {
        Bundle args = new Bundle();
        MArticleFragment fragment = new MArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    private ArticleViewModel timelineViewModel;
    private CtimelineArticlesBinding TBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.ctimeline_articles;
    }

    @Override
    public ArticleViewModel getViewModel() {
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TBinding = getViewDataBinding();
    }
}
