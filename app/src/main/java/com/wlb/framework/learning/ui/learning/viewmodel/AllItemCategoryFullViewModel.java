package com.wlb.framework.learning.ui.learning.viewmodel;

import com.wlb.framework.learning.ui.learning.model.CategoryModel;

public class AllItemCategoryFullViewModel {
//    public final ObservableField<String> author;
//
//    public final ObservableField<String> content;
//
//    public final ObservableField<String> date;
//
//    public final ObservableField<String> imageUrl;

    public final AllItemCategoryViewModelListener mListener;
//
//    public final ObservableField<String> title;

    private final CategoryModel.Data mBlog;

    public AllItemCategoryFullViewModel(CategoryModel.Data blog, AllItemCategoryViewModelListener listener) {
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
    public interface AllItemCategoryViewModelListener {

        void onItemClick(int position);
    }
}
