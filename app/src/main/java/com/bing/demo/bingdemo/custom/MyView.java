package com.bing.demo.bingdemo.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wubz on 2018/1/3.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        Log.i("wubingzhao", "MyView dispatchTouchEvent:"+str);
        return super.dispatchTouchEvent(ev);
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
        Log.i("wubingzhao", "MyView onTouchEvent:"+str);
        return super.onTouchEvent(ev);
//        return false;
    }
}
