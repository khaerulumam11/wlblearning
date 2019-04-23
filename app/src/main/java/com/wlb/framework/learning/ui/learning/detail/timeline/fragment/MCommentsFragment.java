package com.wlb.framework.learning.ui.learning.detail.timeline.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentResponseRespMdl;
import com.wlb.framework.learning.databinding.FragmentMcommentsBinding;
import com.wlb.framework.learning.databinding.FragmentMreviewBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.learning.allList.adapter.CommentAdapter;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.CommentsViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.ReviewViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.wlb.framework.learning.ui.learning.allList.adapter.CommentAdapter.COMMENT_TYPE_NORMAL;
import static com.wlb.framework.learning.ui.learning.allList.adapter.CommentAdapter.RESPONSE_TYPE_NORMAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class MCommentsFragment extends BaseFragment<FragmentMcommentsBinding, CommentsViewModel> {


    public static MCommentsFragment newInstance() {
        Bundle args = new Bundle();
        MCommentsFragment fragment = new MCommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    ViewModelProviderFactory factory;
    private CommentsViewModel timelineViewModel;
    private FragmentMcommentsBinding binding;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mcomments;
    }

    @Override
    public CommentsViewModel getViewModel() {
        timelineViewModel = ViewModelProviders.of(this, factory).get(CommentsViewModel.class);
        return timelineViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
    }


    public void updateUi(CommentRespMdl commentRespMdl){

        if(isAdded()){
            configCommentRv(commentRespMdl.getData());
        }
    }

    CommentAdapter commentAdapter;


    private ArrayList<CommentMdl> comments;
    private void configCommentRv(List<CommentRespMdl.Data> cmmnts){
        binding.commentRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
//        binding.goalRv.setItemAnimator(new DefaultItemAnimator());
        comments = new ArrayList<>();
        commentAdapter = new CommentAdapter(comments);
        binding.commentRv.setAdapter(commentAdapter);
        binding.commentRv.setHasFixedSize(false);

        mapComment(cmmnts);
        commentAdapter.notifyDataSetChanged();
    }

    private void mapComment(List<CommentRespMdl.Data> cmmnts){
        for(CommentRespMdl.Data data: cmmnts){
            CommentMdl comment = new CommentMdl();
            comment.setStudent(data.getStudent());
            comment.setCountHelpful(0);
            comment.setLastModified(data.getLastModified());
            comment.setDateAdded(data.getDateAdded());
            comment.setFulltext(data.getFulltext());
            comment.setUserId(data.getUserId());
            comment.setLessonId(data.getLessonId());
            comment.setTitle(data.getTitle());
            comment.setDiscussionId(0);
            comment.setId(data.getId());
            comment.setItemType(COMMENT_TYPE_NORMAL);
            comments.add(comment);

            if(!data.getResponses().isEmpty()) {
                for(CommentResponseRespMdl resp : data.getResponses()){
                    CommentMdl response = new CommentMdl();
                    response.setStudent(resp.getStudent());
                    response.setId(resp.getId());
                    response.setCountHelpful(resp.getCountHelpful());
                    response.setLastModified(resp.getLastModified());
                    response.setDateAdded(resp.getDateAdded());
                    response.setFulltext(resp.getFulltext());
                    response.setUserId(resp.getUserId());
                    response.setDiscussionId(resp.getDiscussionId());
                    response.setItemType(RESPONSE_TYPE_NORMAL);
                    comments.add(response);

                }
            }
        }

    }

}
