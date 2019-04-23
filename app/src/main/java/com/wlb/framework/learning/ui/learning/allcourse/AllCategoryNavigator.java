package com.wlb.framework.learning.ui.learning.allcourse;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;

public interface AllCategoryNavigator {
    void handleError(Throwable throwable);
    void updateUI(CategoryModel courseModelTrending);
    void handleErrorNetwork(ANError error);
}
