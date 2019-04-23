package com.wlb.framework.learning.ui.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wlb.framework.learning.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RatingView extends LinearLayout {

    private int max = 5;
    private ArrayList<ImageView> rates = new ArrayList<ImageView>();


    public RatingView(Context context, AttributeSet attrs){
        super(context, attrs);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_HORIZONTAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rating_view, this, true);

        ImageView rate;
        for(int i = 0 ; i<=4 ; i++){
            rate = (ImageView) getChildAt(i);
            rates.add(rate);
        }
    }

    public void rate(double rate){
        if((rate >= 0.0) && (rate <= 5.0)){
           int rateInt = (int) rate;
            for(int i = 0 ; i < rateInt; i++){
                rates.get(i).setImageResource(R.drawable.ic_star_on);
                if(i == rateInt-1 && (rate-rateInt) > 0.5){
                    rates.get(i).setImageResource(R.drawable.ic_star_on);
                }
            }

        }
    }
}
