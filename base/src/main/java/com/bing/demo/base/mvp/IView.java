package com.bing.demo.base.mvp;

import android.os.Bundle;
import android.view.View;

public interface IView<P> {
    int getLayoutId();
    void bindUI(View rootView);
    void initData(Bundle savedInstanceState);
    P newP();
}
