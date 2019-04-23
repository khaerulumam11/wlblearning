package com.wlb.framework.learning.ui.learning.allList.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wlb.framework.learning.databinding.ItemGoalBinding;
import com.wlb.framework.learning.databinding.NoItemAboutBinding;
import com.wlb.framework.learning.databinding.NoItemAboutBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.viewModel.GoalViewModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.GoalViewModel;
import com.wlb.framework.learning.utils.AppLogger;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

public class GoalAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<String> goals;

    private AllTrendingListListener mListener;

    public GoalAdapter(List<String> goals) {
        this.goals = goals;
    }

    @Override
    public int getItemCount() {
        if (goals != null && goals.size() > 0) {
            return goals.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (goals != null && !goals.isEmpty()) {
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
                ItemGoalBinding blogViewBinding = ItemGoalBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new GoalAdapter.ItemListViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                NoItemAboutBinding blogViewBinding1 = NoItemAboutBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new GoalAdapter.EmptyViewHolder(blogViewBinding1);
        }
    }

//    public void addItems(List<CourseModelTrending.Data> blogList) {
//        goals.addAll(blogList);
//        notifyDataSetChanged();
//    }

    public void clearItems() {
        goals.clear();
    }

    public void setListener(AllTrendingListListener listener) {
        this.mListener = listener;
    }

    public interface AllTrendingListListener {

        void onRetryClick();
    }

    public class ItemListViewHolder extends BaseViewHolder implements GoalViewModel.GoalViewModelListener {

        private ItemGoalBinding mBinding;

        private GoalViewModel mBlogItemViewModel;

        public ItemListViewHolder(ItemGoalBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            String blog = goals.get(position);
            mBlogItemViewModel = new GoalViewModel(blog);
            mBinding.setModel(mBlogItemViewModel);

            mBinding.goal.setText(blog);
            mBinding.executePendingBindings();
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

        @Override
        public void onRetry() {
        }

//        @Override
//        public void onRetryClick() {
//            mListener.onRetryClick();
//        }
    }
//
//    public void updateList(List<CourseModelTrending.Data> dataList){
//
//    }


    private String getTutorName(int position){
        if(goals.get(position) != null){
            return goals.get(position);
        }

        return "";
    }

    private String getPrice(CourseModelTrending.Data course){

        if(course.getPrice() != null){
            if(course.getPrice().getPricing() != null){
                return addRp(course.getPrice().getPricing().getIDR());
            }
        }
        return "";
    }
}