package com.bing.demo.bingdemo.conflict;

import android.os.Bundle;
import android.util.Log;

import com.bing.demo.base.mvp.BaseActivity;
import com.bing.demo.bingdemo.R;

public class SlideConflictActivity extends BaseActivity<SlidePresent> {

    private HScrollView mListContainer;

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        getPresent().loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("wubingzhao", "onDestroy===: ");
    }
    protected void refreshUI(){
        getUIDelegate().toastLong("hahah");
    }

    @Override
    public SlidePresent newP() {
        return new SlidePresent();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_slide_conflict;
    }
}
