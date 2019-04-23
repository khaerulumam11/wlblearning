package com.wlb.framework.learning.ui.learning.detail.custom_view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;
import com.mindorks.placeholderview.annotations.expand.Toggle;
import com.wlb.framework.learning.R;

@Parent
@SingleTop
@Layout(R.layout.list_item_lessons_heading)
public class HeadingLessons {

    @View(R.id.headingTxt)
    private TextView headingTxt;

    @View(R.id.toggleIcon)
    private ImageView toggleIcon;


    @Toggle(R.id.toggleView)
    private LinearLayout toggleView;

    @ParentPosition
    private int mParentPosition;

    private Context mContext;
    private String mHeading,Duration;

    public HeadingLessons(Context context, String heading) {
        mContext = context;
        mHeading = heading;
    }

    @Resolve
    private void onResolved() {
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_primary_24dp));
        headingTxt.setText(mHeading);
    }

    @Expand
    private void onExpand() {
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_arrow_down_primary_24dp));
    }

    @Collapse
    private void onCollapse() {
        toggleIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_primary_24dp));
    }
}