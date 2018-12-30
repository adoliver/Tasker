package com.example.allenoliver.tasker.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.allenoliver.tasker.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    private boolean mAllowSwipe = true;

    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomViewPager,
                0,0);

        try {
            mAllowSwipe = arr.getBoolean(R.styleable.CustomViewPager_allowSwipe, true);
        } finally {
            arr.recycle();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // This is part of the code needed to toggle off the swipe functionality
        // all touch gestures are ignored
        if (mAllowSwipe) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // This is part of the code needed to toggle off the swip functionality
        // all touch gesture events are ignored
        if (mAllowSwipe) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    public boolean isAllowSwipe() {
        return mAllowSwipe;
    }

    public void setAllowSwipe(boolean mAllowSwipe) {
        this.mAllowSwipe = mAllowSwipe;
    }
}
