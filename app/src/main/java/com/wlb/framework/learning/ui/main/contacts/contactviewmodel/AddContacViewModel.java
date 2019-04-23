package com.wlb.framework.learning.ui.main.contacts.contactviewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

public class AddContacViewModel extends BaseViewModel {
    public AddContacViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
