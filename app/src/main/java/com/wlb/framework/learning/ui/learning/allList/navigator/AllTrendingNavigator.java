package com.wlb.framework.learning.ui.learning.allList.navigator;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;

public interface AllTrendingNavigator {
    void handleError(Throwable throwable);
    void updateUI(CourseModelTrending courseModelTrending);
    void handleErrorNetwork(ANError error);
}
