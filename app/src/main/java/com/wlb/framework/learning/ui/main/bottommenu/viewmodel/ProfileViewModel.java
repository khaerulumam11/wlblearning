package com.wlb.framework.learning.ui.main.bottommenu.viewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.navigation.FprofileNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;
/**
 * Created by MHBX on 20/03/19.
 */

public class ProfileViewModel extends BaseViewModel<FprofileNavigator> {
    public ProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OpenEditProfile(){
        getNavigator().openeditProfile();
    }
}
