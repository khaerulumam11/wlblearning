package com.wlb.framework.learning.ui.learning.allList.viewModel;

import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;

public class ReviewViewModel {
    private final ReviewRespMdl.Data mBlog;

    public ReviewViewModel(ReviewRespMdl.Data blog) {
        this.mBlog = blog;
//        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
    }

//    public void onItemClick() {
//        mListener.onItemClick(mBlog.getBlogUrl());
//    }
//
    public interface ReviewViewModelListener {

        void onItemClick(String blogUrl);
    }
}
