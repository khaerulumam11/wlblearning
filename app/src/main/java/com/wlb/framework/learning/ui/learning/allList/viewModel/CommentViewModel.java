package com.wlb.framework.learning.ui.learning.allList.viewModel;

import com.wlb.framework.learning.data.model.api.wlb.course.CommentMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;

public class CommentViewModel {
    private final CommentMdl mBlog;

    public CommentViewModel(CommentMdl blog) {
        this.mBlog = blog;
//        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
    }

//    public void onItemClick() {
//        mListener.onItemClick(mBlog.getBlogUrl());
//    }
//
    public interface CommentViewModelListener {

        void onItemClick(String blogUrl);
    }
}
