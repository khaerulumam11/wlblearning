package com.wlb.framework.learning.ui.main.bottommenu.viewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.navigation.FfriendsNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

/**
 * Created by MHBX on 20/03/19.
 */

public class FriendsViewModel extends BaseViewModel<FfriendsNavigator> {
    public FriendsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void openMyContacts() {
        getNavigator().openMycontacts();
    }
}
