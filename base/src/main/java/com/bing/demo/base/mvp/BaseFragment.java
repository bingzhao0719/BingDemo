package com.bing.demo.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<P extends IPresent> extends Fragment implements IView<P> {

    private P mPresent;
    private UIDelegate mUIDelegate;
    private View mRootView;
    protected LayoutInflater mLayoutInflater;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        if (mRootView == null && getLayoutId() > 0) {
            mRootView = inflater.inflate(getLayoutId(), null);
            bindUI(mRootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) mRootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mRootView);
            }
        }

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
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
            mUIDelegate = BaseUIDelegate.create(mContext);
        }
        return mUIDelegate;
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresent().pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresent().resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresent().destory();
        if (getPresent() != null) {
            getPresent().detachV();
        }
        mPresent = null;
    }
}
