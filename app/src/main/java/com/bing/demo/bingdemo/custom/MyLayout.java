package com.bing.demo.bingdemo.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by wubz on 2018/1/3.
 */

public class MyLayout extends FrameLayout {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String str = "ACTION_DOWN";
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                str = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                str = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                str = "ACTION_UP";
                break;
            default:
                break;

        }
        Log.d("wubingzhao", "MyLayout dispatchTouchEvent:"+str);
//        super.dispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String str = "ACTION_DOWN";
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                str = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                str = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                str = "ACTION_UP";
                break;
            default:
                break;

        }
        Log.d("wubingzhao", "MyLayout onInterceptTouchEvent:"+str);
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        String str = "ACTION_DOWN";
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                str = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                str = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                str = "ACTION_UP";
                break;
            default:
                break;

        }
        Log.d("wubingzhao", "MyLayout onTouchEvent:"+str);
        return super.onTouchEvent(ev);
//        return true;
    }

}
