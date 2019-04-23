package com.wlb.framework.learning.ui.learning.navigator;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.model.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public interface FragmentWishlistNavigator {
    void handleError(Throwable throwable);
    void updateWishlist(ArrayList<WishlistModel.Course> courseModelTrending);
    void handleErrorNetwork(ANError error);
}
