package com.wlb.framework.learning.ui.learning.detail;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.jw.VideoDetail;

public interface DetailLearningNavigator {
    void handleError(Throwable throwable);

    void openLoginActivity();

    void openProfileFragment();
    void handleErrorNetwork(ANError error);
    void updateAbout(AboutRespMdl aboutRespMd);
    void updateReview(ReviewRespMdl reviewRespMdl);
    void updateComment(CommentRespMdl commentRespMdl);
    void onUpdateVideo(VideoDetail videoDetail);
}
