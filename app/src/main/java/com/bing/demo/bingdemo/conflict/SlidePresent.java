package com.bing.demo.bingdemo.conflict;

import android.os.Handler;
import android.os.Message;

import com.bing.demo.base.mvp.BasePresent;


public class SlidePresent extends BasePresent<SlideConflictActivity> {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public void loadData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getV().refreshUI();
            }
        },2000);
    }

    @Override
    public void destory() {
        super.destory();
        handler.removeCallbacksAndMessages(this);
    }
}
