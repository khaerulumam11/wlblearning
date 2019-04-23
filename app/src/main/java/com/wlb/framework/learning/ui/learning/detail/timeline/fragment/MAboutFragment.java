package com.wlb.framework.learning.ui.learning.detail.timeline.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.databinding.FragmentMaboutBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.learning.allList.adapter.GoalAdapter;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.AboutViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MAboutFragment extends BaseFragment<FragmentMaboutBinding, AboutViewModel> {

    public static MAboutFragment newInstance() {
        Bundle args = new Bundle();
        MAboutFragment fragment = new MAboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    GoalAdapter goalAdapter;
    GoalAdapter requestAdapter;
    GoalAdapter targetAdapter;

    private AboutViewModel timelineViewModel;
    private FragmentMaboutBinding binding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mabout;
    }

    @Override
    public AboutViewModel getViewModel() {
        timelineViewModel = ViewModelProviders.of(this, factory).get(AboutViewModel.class);
        return timelineViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
    }

    public void updateUi(AboutRespMdl aboutRespMdl){

        if(isAdded()){
            binding.description.setText(aboutRespMdl.getDescription());
            configGoalRv(aboutRespMdl.getGoals());
            configRequirementRv(aboutRespMdl.getRequirements());
            configTargeRv(aboutRespMdl.getTargetAudience());
        }
    }

    private void configGoalRv(List<String> goals){
        binding.goalRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
//        binding.goalRv.setItemAnimator(new DefaultItemAnimator());
        goalAdapter = new GoalAdapter(goals);
        binding.goalRv.setAdapter(goalAdapter);
        binding.goalRv.setHasFixedSize(false);

        goalAdapter.notifyDataSetChanged();
    }

    private void configRequirementRv(List<String> requirements){
        binding.requirementRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
//        binding.goalRv.setItemAnimator(new DefaultItemAnimator());
        requestAdapter = new GoalAdapter(requirements);
        binding.requirementRv.setAdapter(requestAdapter);
        binding.requirementRv.setHasFixedSize(false);

        requestAdapter.notifyDataSetChanged();
    }

    private void configTargeRv(List<String> targets){
        binding.targeRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
//        binding.goalRv.setItemAnimator(new DefaultItemAnimator());
        targetAdapter = new GoalAdapter(targets);
        binding.targeRv.setAdapter(targetAdapter);
        binding.targeRv.setHasFixedSize(false);

        targetAdapter.notifyDataSetChanged();
    }

}
