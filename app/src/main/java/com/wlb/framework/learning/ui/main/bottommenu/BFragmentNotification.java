package com.wlb.framework.learning.ui.main.bottommenu;

import android.os.Bundle;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.FragmentMainNotificationBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.NotificationViewModel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class BFragmentNotification extends BaseFragment<FragmentMainNotificationBinding, NotificationViewModel> {

    public static BFragmentNotification newInstance() {
        Bundle args = new Bundle();
        BFragmentNotification fragment = new BFragmentNotification();
        fragment.setArguments(args);
        return fragment;
    }
    @Inject
    ViewModelProviderFactory factory;
    private NotificationViewModel NotifViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_notification;
    }

    @Override
    public NotificationViewModel getViewModel() {
        NotifViewModel = ViewModelProviders.of(this, factory).get(NotificationViewModel.class);
        return NotifViewModel;
    }


}
