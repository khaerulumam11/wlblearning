package com.wlb.framework.learning.ui.learning.viewmodel;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.model.WishlistModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import java.util.List;

public class AllWishlistViewModel {
    public final AllWishItemListener mListener;
    private final List<WishlistModel.Course> mBlog;

    public AllWishlistViewModel(List<WishlistModel.Course> blog, AllWishItemListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
//        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
//        title = new ObservableField<>(mBlog.getTitle());
//        author = new ObservableField<>(mBlog.getAuthor());
//        date = new ObservableField<>(mBlog.getDate());
//        content = new ObservableField<>(mBlog.getDescription());
    }

    public void onItemClick(int position) {
        mListener.onItemClick(position);
    }
    //
    public interface AllWishItemListener {

        void onItemClick(int position);
    }
}
