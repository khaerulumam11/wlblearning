package com.wlb.framework.learning.ui.main.bottommenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.FragmentMainProfileBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.bottommenu.detail.EditProfile;
import com.wlb.framework.learning.ui.main.bottommenu.navigation.FprofileNavigator;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.ProfileViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.DispatchingAndroidInjector;

public class BFragmentProfile extends BaseFragment<FragmentMainProfileBinding, ProfileViewModel> implements FprofileNavigator {
    public static BFragmentProfile newInstance() {
        Bundle args = new Bundle();
        BFragmentProfile fragment = new BFragmentProfile();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private FragmentMainProfileBinding mFragmentProfileBinding;
    private ProfileViewModel profileViewModel;
    private Activity mActivity;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_profile;
    }

    @Override
    public ProfileViewModel getViewModel() {
        profileViewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel.class);
        return profileViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentProfileBinding = getViewDataBinding();
        mFragmentProfileBinding.imvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openeditProfile();
            }
        });
        mActivity = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mActivity = getActivity();
        profileViewModel.setNavigator(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.main_profil, menu);
    }

    @Override
    public void handleError(Throwable throwable) {
    }

    @Override
    public void openeditProfile() {
        Intent intent = EditProfile.newIntent(mActivity);
        mActivity.startActivity(intent);
    }
}
