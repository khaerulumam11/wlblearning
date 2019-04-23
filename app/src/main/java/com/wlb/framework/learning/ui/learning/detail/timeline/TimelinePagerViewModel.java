package com.wlb.framework.learning.ui.learning.detail.timeline;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.detail.TimelineNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import androidx.lifecycle.ViewModel;

public class TimelinePagerViewModel extends BaseViewModel<TimelineNavigator> {
    public TimelinePagerViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    // TODO: Implement the ViewModel
}
