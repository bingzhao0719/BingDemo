package com.bing.demo.base.mvp;

import java.lang.ref.WeakReference;

public class BasePresent<V extends IView> implements IPresent<V> {

    private WeakReference<V> v;
    @Override
    public void attachV(V view) {
        v = new WeakReference<>(view);
    }

    @Override
    public void detachV() {
        if (v.get() != null){
            v.clear();
        }
        v = null;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destory() {

    }

    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v.get();
    }
}
