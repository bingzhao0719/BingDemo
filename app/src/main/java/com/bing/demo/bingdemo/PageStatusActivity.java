package com.bing.demo.bingdemo;

import com.free.statuslayout.manager.StatusLayoutManager;

/**
 * Created by wubz on 2017/12/30.
 */

public class PageStatusActivity extends BaseActivity {
    @Override
    protected StatusLayoutManager initStatusManager() {
        return StatusLayoutManager.newBuilder(this)
                .contentView(initContentView())
                .emptyDataView(initEmptyView())
                .errorView(initErrorView())
                .loadingView(initLoadingView())
                .netWorkErrorView(initNetworkErrorView())
                .build();
    }

    protected int initNetworkErrorView() {
        return R.layout.activity_networkerror;
    }

    protected int initLoadingView() {
        return R.layout.activity_loading;
    }

    protected int initErrorView() {
        return R.layout.activity_error;
    }

    protected int initEmptyView() {
        return R.layout.activity_emptydata;
    }

    protected int initContentView() {
        return R.layout.activity_content;
    }
}
