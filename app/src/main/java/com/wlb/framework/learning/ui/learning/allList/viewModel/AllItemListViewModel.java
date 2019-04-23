package com.wlb.framework.learning.ui.learning.allList.viewModel;

import com.wlb.framework.learning.data.model.api.BlogResponse;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;

public class AllItemListViewModel {
//    public final ObservableField<String> author;
//
//    public final ObservableField<String> content;
//
//    public final ObservableField<String> date;
//
//    public final ObservableField<String> imageUrl;

    public final AllItemListViewModelListener mListener;
//
//    public final ObservableField<String> title;

    private final CourseModelTrending.Data mBlog;

    public AllItemListViewModel(CourseModelTrending.Data blog, AllItemListViewModelListener listener) {
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
    public interface AllItemListViewModelListener {

        void onItemClick(int position);
    }
}
