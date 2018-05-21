package com.bing.demo.base.mvp;

public interface IPresent<V> {
    void attachV(V view);
    void detachV();
    void resume();
    void pause();
    void destory();
}
