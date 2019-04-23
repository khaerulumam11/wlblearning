package com.wlb.framework.learning.ui.main.timeline.viewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

public class CompaniesViewModel extends BaseViewModel {
    public CompaniesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
