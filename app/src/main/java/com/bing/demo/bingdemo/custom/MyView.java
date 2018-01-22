package com.bing.demo.bingdemo.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by wubz on 2018/1/3.
 */

public class MyView extends TextView {
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.d("wubingzhao", "myview onMeasure before: ");

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("wubingzhao", "myview onMeasure after: ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("wubingzhao", "myview onAttachedToWindow: "+getWidth());
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.e("wubingzhao", "myview onWindowVisibilityChanged visibility: "+visibility+" :"+getWidth());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("wubingzhao", "myview onDetachedFromWindow: ");
    }
}
