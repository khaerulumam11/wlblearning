package com.wlb.framework.learning.ui.learning.allList.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wlb.framework.learning.data.model.api.wlb.course.CommentMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;
import com.wlb.framework.learning.databinding.ItemCommentBinding;
import com.wlb.framework.learning.databinding.ItemCommentBinding;
import com.wlb.framework.learning.databinding.ItemCommentResponseBinding;
import com.wlb.framework.learning.databinding.NoItemAboutBinding;
import com.wlb.framework.learning.ui.base.BaseViewHolder;
import com.wlb.framework.learning.ui.feed.blogs.BlogEmptyItemViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.viewModel.CommentViewModel;
import com.wlb.framework.learning.utils.AppLogger;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import static com.wlb.framework.learning.utils.ManipulateUtils.addRp;

public class CommentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int COMMENT_TYPE_NORMAL = 1;
    public static final int RESPONSE_TYPE_NORMAL = 2;

    private List<CommentMdl> comments;

    private AllTrendingListListener mListener;

    public CommentAdapter(List<CommentMdl> comments) {
        this.comments = comments;
    }

    @Override
    public int getItemCount() {
        if (comments != null && comments.size() > 0) {
            return comments.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (comments != null && !comments.isEmpty()) {
            return comments.get(position).getItemType();
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
            case COMMENT_TYPE_NORMAL:
                ItemCommentBinding itemCommentBinding = ItemCommentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CommentAdapter.CommentViewHolder(itemCommentBinding);
            case RESPONSE_TYPE_NORMAL:
                ItemCommentResponseBinding itemCommentResponseBinding= ItemCommentResponseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CommentAdapter.CommentResponseViewHolder(itemCommentResponseBinding);
            case VIEW_TYPE_EMPTY:
            default:
                NoItemAboutBinding blogViewBinding1 = NoItemAboutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CommentAdapter.EmptyViewHolder(blogViewBinding1);
        }
    }

//    public void addItems(List<CourseModelTrending.Data> blogList) {
//        comments.addAll(blogList);
//        notifyDataSetChanged();
//    }

    public void clearItems() {
        comments.clear();
    }

    public void setListener(AllTrendingListListener listener) {
        this.mListener = listener;
    }

    public interface AllTrendingListListener {

        void onRetryClick();
    }

    public class CommentViewHolder extends BaseViewHolder implements CommentViewModel.CommentViewModelListener {

        private ItemCommentBinding mBinding;

        private CommentViewModel mBlogItemViewModel;

        public CommentViewHolder(ItemCommentBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            CommentMdl comment = comments.get(position);
            mBlogItemViewModel = new CommentViewModel(comment);
            mBinding.setModel(mBlogItemViewModel);

            mBinding.comment.setText(comment.getFulltext());
            mBinding.name.setText(comment.getStudent().getName());
            mBinding.date.setText(comment.getDateAdded());

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

    public class CommentResponseViewHolder extends BaseViewHolder implements CommentViewModel.CommentViewModelListener {

        private ItemCommentResponseBinding mBinding;

        private CommentViewModel mBlogItemViewModel;

        public CommentResponseViewHolder(ItemCommentResponseBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            CommentMdl comment = comments.get(position);
            mBlogItemViewModel = new CommentViewModel(comment);
            mBinding.setModel(mBlogItemViewModel);

            mBinding.response.setText(comment.getFulltext());
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
    
}