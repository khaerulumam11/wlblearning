package com.wlb.framework.learning.ui.learning.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wlb.framework.learning.databinding.AllItemListBinding;
import com.wlb.framework.learning.databinding.ItemBlogEmptyViewBinding;
import com.wlb.framework.learning.databinding.ItemBlogLoadViewBinding;
import com.wlb.framework.learning.databinding.ListWishlistContentCatalogBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewLoadModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllTrendingListViewModel;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningAcitivity;
import com.wlb.framework.learning.ui.learning.model.WishlistModel;
import com.wlb.framework.learning.ui.learning.viewmodel.AllWishlistViewModel;
import com.wlb.framework.learning.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

public class WishlistAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_LOAD= 2;


    private ArrayList<WishlistModel.Course> mBlogResponseList;

    private AllWishlistViewModel.AllWishItemListener mListener;

    Context mContext;

    public WishlistAdapter(ArrayList<WishlistModel.Course> blogResponseList, Context mContext) {
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
                ListWishlistContentCatalogBinding blogViewBinding = ListWishlistContentCatalogBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new WishlistAdapter.ItemListViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
//                ItemBlogLoadViewBinding blogLoadViewBinding1 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
//                        parent, false);
//                return new AllTrendingListAdapter.LoadViewHolder(blogLoadViewBinding1);
                ItemBlogEmptyViewBinding blogViewBinding1 = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new WishlistAdapter.EmptyViewHolder(blogViewBinding1,mContext);
            case VIEW_TYPE_LOAD:
                ItemBlogLoadViewBinding blogLoadViewBinding = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new WishlistAdapter.LoadViewHolder(blogLoadViewBinding);
            default:
//                ListWishlistContentCatalogBinding blogViewBinding2 = ListWishlistContentCatalogBinding.inflate(LayoutInflater.from(parent.getContext()),
//                        parent, false);
//                return new WishlistAdapter.ItemListViewHolder(blogViewBinding2);
                ItemBlogLoadViewBinding blogViewBinding2 = ItemBlogLoadViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new WishlistAdapter.LoadViewHolder(blogViewBinding2);
        }
    }

    public void addItems(List<WishlistModel.Course> blogList) {
        mBlogResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogResponseList.clear();
    }

    public void setListener(AllWishlistViewModel.AllWishItemListener listener) {
        this.mListener = listener;
    }

    public interface AllTrendingListListener {

    }

    public class ItemListViewHolder extends BaseViewHolder implements AllWishlistViewModel.AllWishItemListener {

        private ListWishlistContentCatalogBinding mBinding;

        private AllWishlistViewModel mBlogItemViewModel;

        public ItemListViewHolder(ListWishlistContentCatalogBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        List<WishlistModel.Course> course;
        @Override
        public void onBind(int position) {
            WishlistModel.Course blog = mBlogResponseList.get(position);
            mBlogItemViewModel = new AllWishlistViewModel(course, this);
            mBinding.setViewModel(mBlogItemViewModel);
            mBinding.title.setText(blog.getTitle());
            mBinding.creator.setText(getTutorName(position));
            mBinding.hargaAwal.setText("Rp. 150.000");
            mBinding.hargaDisc.setText("Rp. 150.000");
            mBinding.ratingbar.rate(blog.getAverageRating());

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


    private String getTutorName(int position){
        if(mBlogResponseList.get(position).getCreatorUser() != null){
            return mBlogResponseList.get(position).getCreatorUser().getName();
        }

        return "";
    }

//    private String getPrice(WishlistModel.Course course){
//
//        if(course.getPrice() != null){
//            if(course.getPrice().getPricing() != null){
//                return addRp(course.getPrice().getPricing().getIDR());
//            }
//        }
//        return "";
//    }
}