package com.wlb.framework.learning.ui.custom;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationHorizontal extends RecyclerView.ItemDecoration{

    private int margin;
    private int stenMargin;


    public ItemDecorationHorizontal(int margin, int stenMargin){
        this.margin = margin;
        this.stenMargin = stenMargin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = stenMargin;
        outRect.bottom = stenMargin;
        int size = parent.getAdapter().getItemCount();
        if(parent.getChildAdapterPosition(view) == 0){
            outRect.left = stenMargin;
            outRect.right = margin;
        }else if(parent.getChildAdapterPosition(view) == (size-1)){
            outRect.right = stenMargin;
        }else{
            outRect.right = margin;
        }


    }
}
