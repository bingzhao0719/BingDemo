package com.bing.demo.base.utils;

import android.content.Context;

public class DialogUtils {

    public static CommonDialog.Builder with(Context context) {
        return new CommonDialog.Builder(context);
    }
}
