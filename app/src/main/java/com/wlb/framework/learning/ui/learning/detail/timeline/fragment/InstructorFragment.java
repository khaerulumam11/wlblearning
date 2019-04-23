package com.wlb.framework.learning.ui.learning.detail.timeline.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.databinding.FragmentInstructorBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.AboutViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.InstructorViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstructorFragment extends BaseFragment<FragmentInstructorBinding, InstructorViewModel> {

    public static InstructorFragment newInstance() {
        Bundle args = new Bundle();
        InstructorFragment fragment = new InstructorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    private InstructorViewModel timelineViewModel;
    FragmentInstructorBinding fragmentInstructorBinding;




    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_instructor;
    }

    @Override
    public InstructorViewModel getViewModel() {
        timelineViewModel = ViewModelProviders.of(this, factory).get(InstructorViewModel.class);
        return timelineViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentInstructorBinding = getViewDataBinding();
    }

    public void updateInstruc(AboutRespMdl aboutRespMdl){
        if(isAdded()){
            setInstructor(aboutRespMdl);
        }
    }


    private void setInstructor(AboutRespMdl aboutRespMdl){
        if(aboutRespMdl.getCreatorUser() != null){
            if(aboutRespMdl.getCreatorUser().getName() != null){
                fragmentInstructorBinding.nameInstructor.setText(
                        aboutRespMdl.getCreatorUser().getName()
                );
            }
        }
    }



}
