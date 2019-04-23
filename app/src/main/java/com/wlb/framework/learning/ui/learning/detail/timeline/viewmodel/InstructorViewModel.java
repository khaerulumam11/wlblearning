package com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

public class InstructorViewModel extends BaseViewModel {
    public InstructorViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
