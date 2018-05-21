package com.bing.demo.base.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity<P extends IPresent> extends AppCompatActivity implements IView<P> {
    private P mPresent;
    private UIDelegate mUIDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(null);
        }
        initData(savedInstanceState);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void bindUI(View rootView) {

    }

    @Override
    public P newP() {
        return null;
    }

    protected P getPresent() {
        if (mPresent == null) {
            mPresent = newP();
            if (mPresent != null) {
                mPresent.attachV(this);
            }
        }
        return mPresent;
    }

    protected UIDelegate getUIDelegate() {
        if (mUIDelegate == null) {
            mUIDelegate = BaseUIDelegate.create(this);
        }
        return mUIDelegate;
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresent().pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresent().resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresent().destory();
        if (getPresent() != null) {
            getPresent().detachV();
        }
        mPresent = null;
    }
}
