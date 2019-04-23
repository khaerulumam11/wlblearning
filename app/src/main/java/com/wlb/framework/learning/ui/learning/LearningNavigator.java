package com.wlb.framework.learning.ui.learning;

public interface LearningNavigator {
    void handleError(Throwable throwable);

    void openLoginActivity();

    void openProfileFragment();
}
