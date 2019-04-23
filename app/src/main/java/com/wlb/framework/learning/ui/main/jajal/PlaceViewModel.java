package com.wlb.framework.learning.ui.main.jajal;

import androidx.databinding.ObservableField;
import com.wlb.framework.learning.data.model.api.BlogResponse;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class PlaceViewModel {

    public final ObservableField<String> name;

    public final PlaceViewModelListener mListener;

    private final BlogResponse.Blog mBlog;

    public PlaceViewModel(BlogResponse.Blog blog, PlaceViewModelListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
        name = new ObservableField<>(mBlog.getAuthor());
    }

    public void onItemClick() {
        mListener.onItemClick(mBlog.getBlogUrl());
    }

    public interface PlaceViewModelListener {

        void onItemClick(String blogUrl);
    }
}