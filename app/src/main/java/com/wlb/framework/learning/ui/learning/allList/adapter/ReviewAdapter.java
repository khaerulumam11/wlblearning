package com.wlb.framework.learning.ui.learning.allList.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.databinding.ItemBlogEmptyViewBinding;
import com.wlb.framework.learning.databinding.ItemReviewBinding;
import com.wlb.framework.learning.databinding.NoItemAboutBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.ReviewViewModel;
import com.wlb.framework.learning.utils.AppLogger;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ReviewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<ReviewRespMdl.Data> reviews;

    private AllTrendingListListener mListener;

    public ReviewAdapter(List<ReviewRespMdl.Data> reviews) {
        this.reviews = reviews;
    }

    @Override
    public int getItemCount() {
        if (reviews != null && reviews.size() > 0) {
            return reviews.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (reviews != null && !reviews.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemReviewBinding itemViewBinding = ItemReviewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ReviewAdapter.ItemListViewHolder(itemViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                NoItemAboutBinding itemViewBinding1 = NoItemAboutBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ReviewAdapter.EmptyViewHolder(itemViewBinding1);
        }
    }

//    public void addItems(List<CourseModelTrending.Data> blogList) {
//        reviews.addAll(blogList);
//        notifyDataSetChanged();
//    }

    public void clearItems() {
        reviews.clear();
    }

    public void setListener(AllTrendingListListener listener) {
        this.mListener = listener;
    }

    public interface AllTrendingListListener {

        void onRetryClick();
    }

    public class ItemListViewHolder extends BaseViewHolder implements ReviewViewModel.ReviewViewModelListener {

        private ItemReviewBinding mBinding;

        private ReviewViewModel mBlogItemViewModel;

        public ItemListViewHolder(ItemReviewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }



        @Override
        public void onBind(int position) {
            ReviewRespMdl.Data review = reviews.get(position);
            mBlogItemViewModel = new ReviewViewModel(review);
            mBinding.setModel(mBlogItemViewModel);


            mBinding.rating.setRating(review.getRating());
            setReviewer(position);
            setReviewText(position);

//            mBinding.goal.setText(review);
            mBinding.executePendingBindings();
        }

        String reviewTxt;
        String studentNameTxt;
        private void setReviewText(int position){
            reviewTxt = reviews.get(position).getReviewText();
            if(reviewTxt != null){
                mBinding.reviewText.setText(reviewTxt);
            }
        }

        private void setReviewer(int position){
            studentNameTxt= reviews.get(position).getReviewText();
            if(studentNameTxt!= null){
                mBinding.reviewer.setText(studentNameTxt);
            }
        }

        @Override
        public void onItemClick(String blogUrl) {
            if (blogUrl != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(blogUrl));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BlogEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private NoItemAboutBinding mBinding;

        public EmptyViewHolder(NoItemAboutBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            BlogEmptyItemViewModel emptyItemViewModel = new BlogEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);

        }

//        @Override
//        public void onRetryClick() {
//            mListener.onRetryClick();
//        }

        @Override
        public void onRetry() {

        }
    }
//
//    public void updateList(List<CourseModelTrending.Data> dataList){
//
//    }
    
}