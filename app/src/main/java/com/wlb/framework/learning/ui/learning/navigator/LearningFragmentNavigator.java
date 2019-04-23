package com.wlb.framework.learning.ui.learning.navigator;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.data.model.api.wlb.course.CourseRespMdl;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;

public interface LearningFragmentNavigator {

    void onPergi(CourseRespMdl.Data course);
    void handleErrorNetwork(ANError error);
    void updateCourse(CourseRespMdl courseRespMdl);
    void updateCategory(CategoryModel categoryModel);
    void onAllTrending();
    void onAllCategory();

}
