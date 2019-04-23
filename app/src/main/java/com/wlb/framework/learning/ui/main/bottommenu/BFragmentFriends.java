package com.wlb.framework.learning.ui.main.bottommenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.FragmentMainFriendsBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.bottommenu.detail.EditProfile;
import com.wlb.framework.learning.ui.main.bottommenu.navigation.FfriendsNavigator;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.FriendsViewModel;
import com.wlb.framework.learning.ui.main.contacts.MyContact;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.DispatchingAndroidInjector;

public class BFragmentFriends extends BaseFragment<FragmentMainFriendsBinding,FriendsViewModel> implements FfriendsNavigator {

    public static BFragmentFriends newInstance() {
        Bundle args = new Bundle();
        BFragmentFriends fragment = new BFragmentFriends();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private FriendsViewModel friendsViewModel;
    private FragmentMainFriendsBinding mFragmentFriendsBinding;
    private Activity mActivity;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_friends;
    }

    @Override
    public FriendsViewModel getViewModel() {
        friendsViewModel = ViewModelProviders.of(this, factory).get(FriendsViewModel.class);
        return friendsViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
    }

    @Override
    public void openMycontacts() {
        Intent intent = MyContact.newIntent(mActivity);
        mActivity.startActivity(intent);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentFriendsBinding = getViewDataBinding();
        mFragmentFriendsBinding.llMycontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMycontacts();
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        friendsViewModel.setNavigator(this);
    }
}
