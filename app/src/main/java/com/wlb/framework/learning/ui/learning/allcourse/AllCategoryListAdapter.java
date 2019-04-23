package com.wlb.framework.learning.ui.learning.allcourse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wlb.framework.learning.databinding.ActivityAllCourseBinding;
import com.wlb.framework.learning.databinding.AllItemListBinding;
import com.wlb.framework.learning.databinding.ItemBlogEmptyViewBinding;
import com.wlb.framework.learning.databinding.ItemBlogLoadViewBinding;
import com.wlb.framework.learning.databinding.ItemCategoryBinding;
import com.wlb.framework.learning.databinding.ItemCategoryFullBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewLoadModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllTrendingListViewModel;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningAcitivity;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;
import com.wlb.framework.learning.ui.learning.viewmodel.AllItemCategoryFullViewModel;
import com.wlb.framework.learning.ui.learning.viewmodel.AllItemCategoryViewModel;
import com.wlb.framework.learning.utils.NetworkUtils;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

public class AllCategoryListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_LOAD= 2;


    private List<CategoryModel.Data> mBlogResponseList;

    private AllCategoryListener mListener;




    Context mContext;

    public AllCategoryListAdapter(List<CategoryModel.Data> blogResponseList, Context mContext) {
        this.mBlogResponseList = blogResponseList;
        this.mContext = mContext;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mContext.getApplicationContext());
    }

    @Override
    public int getItemCount() {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return mBlogResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBlogResponseList != null && !mBlogResponseList.isEmpty() && isNetworkConnected()) {
            return VIEW_TYPE_NORMAL;
        } else if (!isNetworkConnected()){
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_LOAD;
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
                ItemCategoryFullBinding blogViewBinding = ItemCategoryFullBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AllCategoryListAdapter.ItemListViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
//                ItemBlogLoadViewBinding blogLoadViewBinding1 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
//                        parent, false);
//                return new AllTrendingListAdapter.LoadViewHolder(blogLoadViewBinding1);
                ItemBlogEmptyViewBinding blogViewBinding1 = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AllCategoryListAdapter.EmptyViewHolder(blogViewBinding1,mContext);
            case VIEW_TYPE_LOAD:
                ItemBlogLoadViewBinding blogLoadViewBinding = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AllCategoryListAdapter.LoadViewHolder(blogLoadViewBinding);
            default:
                ItemBlogLoadViewBinding blogViewBinding2 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new AllCategoryListAdapter.LoadViewHolder(blogViewBinding2);
        }
    }

    public void addItems(List<CategoryModel.Data> blogList) {
        mBlogResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogResponseList.clear();
    }

    public void setListener(AllCategoryListener listener) {
        this.mListener = listener;
    }

    public interface AllCategoryListener {

    }

    public class ItemListViewHolder extends BaseViewHolder implements AllItemCategoryFullViewModel.AllItemCategoryViewModelListener {

        private ItemCategoryFullBinding mBinding;

        private AllItemCategoryFullViewModel mBlogItemViewModel;

        public ItemListViewHolder(ItemCategoryFullBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        CategoryModel.Data course;
        @Override
        public void onBind(int position) {
            CategoryModel.Data blog = mBlogResponseList.get(position);
            mBlogItemViewModel = new AllItemCategoryFullViewModel(course, this);
            mBinding.setViewModel(mBlogItemViewModel);
            mBinding.nameCategory.setText(blog.getName());
            Glide.with(mContext).load(blog.getThumbnail()).into(mBinding.logoCategory);
//            mBinding.author.setText(getTutorName(position));

//            itemView.setOnClickListener( view -> {
//                        mBlogItemViewModel.onItemClick(position);
//                    }
//            );

            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(int position) {
//            Intent intent = new Intent(itemView.getContext(), DetailLearningAcitivity.class);
//            intent.putExtra("id", mBlogResponseList.get(position).getId());
//            intent.putExtra("title", mBlogResponseList.get(position).getTitle());
//            itemView.getContext().startActivity(intent);
        }
    }

    public static class EmptyViewHolder extends BaseViewHolder implements BlogEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private ItemBlogEmptyViewBinding mBinding;

        private BlogEmptyItemViewModel mBlogItemViewModel;

        Context mContext;

        public EmptyViewHolder(ItemBlogEmptyViewBinding binding, Context mContext) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mContext = mContext;
        }

        AllTrendingListViewModel allTrendingListViewModel;
        @Override
        public void onBind(int position) {
            BlogEmptyItemViewModel emptyItemViewModel = new BlogEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
//            allTrendingListViewModel = ViewModelProviders.of(this, factory).get(AllTrendingListViewModel.class);
//            mBinding.btnRetry.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    emptyItemViewModel.onRetryClick();
//                }
//            });

        }

        @Override
        public void onRetry() {
            allTrendingListViewModel.fetchBlogs();
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

}