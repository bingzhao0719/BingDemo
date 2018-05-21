package com.bing.demo.base.mvp;

import android.content.Context;
import android.widget.Toast;

public class BaseUIDelegate implements UIDelegate {
    private Context mContext;
    public BaseUIDelegate(Context context){
        this.mContext = context;
    }
    public static BaseUIDelegate create(Context context){
        return new BaseUIDelegate(context);
    }
    @Override
    public void toastShort(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toastLong(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }
}
