package com.wlb.framework.learning.ui.main.jajal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wlb.framework.learning.data.model.api.wlb.course.CourseRespMdl;
import com.wlb.framework.learning.databinding.ItemBlogEmptyViewBinding;
import com.wlb.framework.learning.databinding.ItemBlogLoadViewBinding;
import com.wlb.framework.learning.databinding.ItemCourseBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.feed.blogs.CourseViewModel;
import com.wlb.framework.learning.ui.learning.allList.adapter.AllTrendingListAdapter;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewLoadModel;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningAcitivity;
import com.wlb.framework.learning.utils.AppLogger;
import com.wlb.framework.learning.utils.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class CourseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    public static final int VIEW_TYPE_LOAD = 2;

    private List<CourseRespMdl.Data> courses;

    private Context mContext;

    private PlaceAdapterListener mListener;

    public CourseAdapter(List<CourseRespMdl.Data> blogResponseList, Context mContext) {
        this.courses = blogResponseList;
        this.mContext = mContext;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mContext.getApplicationContext());
    }

    @Override
    public int getItemCount() {
        if (courses != null && courses.size() > 0) {
            return courses.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (courses != null && !courses.isEmpty() && isNetworkConnected()) {
            return VIEW_TYPE_NORMAL;
        } else if (!isNetworkConnected()){
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_LOAD;
        }
    }

    @Override
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int position) {
        holder.onBind(position);


    }

    @Override
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemCourseBinding blogViewBinding = ItemCourseBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new CourseViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
//                ItemBlogLoadViewBinding blogLoadViewBinding1 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
//                        parent, false);
//                return new AllTrendingListAdapter.LoadViewHolder(blogLoadViewBinding1);
                ItemBlogEmptyViewBinding blogViewBinding1 = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new CourseAdapter.EmptyViewHolder(blogViewBinding1);
            case VIEW_TYPE_LOAD:
                ItemBlogLoadViewBinding blogLoadViewBinding = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new CourseAdapter.LoadViewHolder(blogLoadViewBinding);
            default:
                ItemBlogLoadViewBinding blogViewBinding2 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new CourseAdapter.LoadViewHolder(blogViewBinding2);
        }
    }

    public void addItems(List<CourseRespMdl.Data> blogList) {
        courses.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        courses.clear();
    }

    public void setListener(PlaceAdapterListener listener) {
        this.mListener = listener;
    }

    public interface PlaceAdapterListener {

        void onRetryClick();
    }

    public class CourseViewHolder extends BaseViewHolder implements CourseViewModel.BlogItemViewModelListener {

        private ItemCourseBinding mBinding;

        private CourseViewModel mBlogItemViewModel;

        public CourseViewHolder(ItemCourseBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        CourseRespMdl.Data course;

        @Override
        public void onBind(int position) {
            CourseRespMdl.Data course = courses.get(position);
            mBlogItemViewModel = new CourseViewModel(course, this);
            mBinding.setViewModel(mBlogItemViewModel);

            mBinding.title.setText(course.getTitle());
            mBinding.realPrice.setText(course.getTitle());
            mBinding.tutor.setText(getTutorName(position));
//            mBinding.priceDiscont.setText(getPrice());
            mBinding.realPrice.setText(getPrice(course));
            mBinding.rating.rate(course.getAverageRating());
//            mBinding.image.setTag(course.getThumbnail());
            Glide.with(mContext).load(course.getThumbnail()).into(mBinding.image);


            itemView.setOnClickListener( view -> {
                        mBlogItemViewModel.onItemClick(position);
                    }
            );

            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(int position) {
            Intent intent = new Intent(itemView.getContext(), DetailLearningAcitivity.class);
            intent.putExtra("id", ""+ courses.get(position).getId());
            intent.putExtra("title", ""+ courses.get(position).getTitle());
            intent.putExtra("video", courses.get(position).getTitle());
            itemView.getContext().startActivity(intent);
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BlogEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private ItemBlogEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemBlogEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            BlogEmptyItemViewModel emptyItemViewModel = new BlogEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }


        @Override
        public void onRetry() {

        }
    }
    public static class LoadViewHolder extends BaseViewHolder implements AllItemListViewLoadModel.AllItemListViewLoadListener {

        private ItemBlogLoadViewBinding mBinding;

        public LoadViewHolder(ItemBlogLoadViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            AllItemListViewLoadModel emptyItemViewModel = new AllItemListViewLoadModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {

        }
    }

    private String getTutorName(int position) {
        if (courses.get(position).getCreatorUser() != null) {
            return courses.get(position).getCreatorUser().getName();
        }

        return "";
    }

    private String getPrice(CourseRespMdl.Data course) {
        if (course.getPrice() != null) {
            if (course.getPrice().getPricing() != null) {
                return addRp(course.getPrice().getPricing().getIDR());
            }
        }
        return "";
    }

}