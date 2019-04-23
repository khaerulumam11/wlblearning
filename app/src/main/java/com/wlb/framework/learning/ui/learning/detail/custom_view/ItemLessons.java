package com.wlb.framework.learning.ui.learning.detail.custom_view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;

@Layout(R.layout.list_item_lessons)
public class ItemLessons {

    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.tv_lesson_judul)
    private TextView titleTxt;

    @View(R.id.tv_lesson_duration)
    private TextView durationTxt;

    @View(R.id.imv_btn_play)
    private ImageView imageView;

    private AboutRespMdl.Lessons mInfo;
    private Context mContext;
    private onItemPlay actionLesson;

    public ItemLessons(Context context, AboutRespMdl.Lessons info, onItemPlay listener) {
        mContext = context;
        mInfo = info;
        actionLesson = listener;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getTitle());
        durationTxt.setText(mInfo.getDuration());
//        timeTxt.setText(mInfo.getTime());
//        Glide.with(mContext).load(mInfo.getImageUrl()).into(imageView);
    }

    @Click(R.id.tv_lesson_judul)
    private void PlayVideo() {
        actionLesson.PlayVideo(mInfo.getSummary());
    }

    public interface onItemPlay {
        void PlayVideo(String Fileurl);
    }
}
