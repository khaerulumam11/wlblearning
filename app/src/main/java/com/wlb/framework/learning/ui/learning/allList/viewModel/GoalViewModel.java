package com.wlb.framework.learning.ui.learning.allList.viewModel;

import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;

public class GoalViewModel {
    private final String mBlog;

    public GoalViewModel(String blog) {
        this.mBlog = blog;
//        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
    }

//    public void onItemClick() {
//        mListener.onItemClick(mBlog.getBlogUrl());
//    }
//
    public interface GoalViewModelListener {

        void onItemClick(String blogUrl);
    }
}
