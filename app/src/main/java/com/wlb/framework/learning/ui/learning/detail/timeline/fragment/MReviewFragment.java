package com.wlb.framework.learning.ui.learning.detail.timeline.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.databinding.FragmentMreviewBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.learning.allList.adapter.ReviewAdapter;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.ReviewViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MReviewFragment extends BaseFragment<FragmentMreviewBinding, ReviewViewModel> {

    public static MReviewFragment newInstance() {
        Bundle args = new Bundle();
        MReviewFragment fragment = new MReviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    private ReviewViewModel timelineViewModel;
    private FragmentMreviewBinding fragmentMreviewBinding;
    private ProgressBar pb1,pb2,pb3,pb4,pb5;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mreview;
    }

    @Override
    public ReviewViewModel getViewModel() {
        timelineViewModel = ViewModelProviders.of(this, factory).get(ReviewViewModel.class);
        return timelineViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMreviewBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        pb1 = fragmentMreviewBinding.pbPersentse;
        pb2 = fragmentMreviewBinding.pbPersentase1;
        pb3 = fragmentMreviewBinding.pbPersentse2;
        pb4 = fragmentMreviewBinding.pbPersentse3;
        pb5 = fragmentMreviewBinding.pbPersentse4;

        pb1.setProgress(60);
        pb2.setProgress(20);
        pb3.setProgress(10);
        pb4.setProgress(6);
        pb5.setProgress(4);
    }

    public void updateUi(ReviewRespMdl reviewRespMdl){
        if(isAdded()){
            configReviewRv(reviewRespMdl.getData());
        }
    }

    ReviewAdapter goalAdapter;

    private void configReviewRv(List<ReviewRespMdl.Data> goals){
        fragmentMreviewBinding.reviewRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
//        fragmentMreviewBinding.reviewRv.setItemAnimator(new DefaultItemAnimator());
        goalAdapter = new ReviewAdapter(goals);
        fragmentMreviewBinding.reviewRv.setAdapter(goalAdapter);
        fragmentMreviewBinding.reviewRv.setHasFixedSize(false);

        goalAdapter.notifyDataSetChanged();
    }

}
