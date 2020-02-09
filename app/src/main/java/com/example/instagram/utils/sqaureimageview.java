package com.example.instagram.utils;

import android.content.Context;
//import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class sqaureimageview extends AppCompatImageView {

    public sqaureimageview(Context context) {
        super (context);
    }

    public sqaureimageview(Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    public sqaureimageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure (widthMeasureSpec, widthMeasureSpec);
    }
}
