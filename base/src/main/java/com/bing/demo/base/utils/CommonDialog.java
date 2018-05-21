package com.bing.demo.base.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.bing.demo.base.R;

public class CommonDialog extends Dialog {

    private Context mContext;
    private SparseArray<View> mViews;
    private View mContentView;

    public CommonDialog(Builder builder) {
        this(builder.context);
        this.mContentView = builder.contentView;
        int size = builder.views.size();
        for (int i = 0; i < size; i++) {
            int key = builder.views.keyAt(i);
            final ItemView item = builder.views.get(key);
            mViews.put(key, item.view);
            if (item.callback != null) {
                item.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.callback.callback();
                        if (CommonDialog.this.isShowing()) {
                            CommonDialog.this.dismiss();
                        }
                    }
                });
            }
        }
    }

    public CommonDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
        this.setCanceledOnTouchOutside(false);
        init();
    }

    public boolean isPortrait() {
        DisplayMetrics dm = mContext.getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels < dm.heightPixels;
    }

    public CommonDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
        this.setCanceledOnTouchOutside(false);
        init();
    }

    public CommonDialog(Context context, int theme, int layoutRes) {
        super(context, theme);
        this.mContext = context;
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        if (isPortrait()) {
            lp.width = width * 203 / 240;
        } else {
            lp.width = width * 123 / 240;
        }

        setContentView(mContentView, lp);

    }

    private void init() {
        mViews = new SparseArray<>();
    }

    public View getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    public CommonDialog setView(@IdRes int viewId, String text) {
        initView(viewId, text);
        return this;
    }

    public CommonDialog setView(@IdRes int viewId, int resId) {
        initView(viewId, mContext.getString(resId));
        return this;
    }

    private void initView(@IdRes int viewId, String text) {
        if (mViews == null) {
            mViews = new SparseArray<>();
        }
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            view.setVisibility(View.VISIBLE);
            mViews.put(viewId, view);
        }
        if (!TextUtils.isEmpty(text)) {
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            } else if (view instanceof Button) {
                ((Button) view).setText(text);
            }
        }
    }

    public CommonDialog setView(@IdRes int viewId, final ViewCallback callback) {
        if (mViews == null) {
            mViews = new SparseArray<>();
        }
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            view.setVisibility(View.VISIBLE);
            if (callback != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.callback();
                        dismiss();
                    }
                });
            }
            mViews.put(viewId, view);
        }
        return this;
    }

    public CommonDialog setView(@IdRes int viewId) {
        if (mViews == null) {
            mViews = new SparseArray<>();
        }
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            view.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public CommonDialog setView(@IdRes int viewId, String text, final ViewCallback callback) {
        initView(viewId, text, callback);
        return this;
    }

    public CommonDialog setView(@IdRes int viewId, int resId, final ViewCallback callback) {
        initView(viewId, mContext.getString(resId), callback);
        return this;
    }

    private void initView(@IdRes int viewId, String text, final ViewCallback callback) {
        if (mViews == null) {
            mViews = new SparseArray<>();
        }
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            view.setVisibility(View.VISIBLE);
            if (callback != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.callback();
                        dismiss();
                    }
                });
            }
            mViews.put(viewId, view);
        }
        if (!TextUtils.isEmpty(text)) {
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            } else if (view instanceof Button) {
                ((Button) view).setText(text);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public interface ViewCallback {
        void callback();
    }

    public static class Builder {
        Context context;
        View contentView;
        SparseArray<ItemView> views;

        public Builder(Context context) {
            this.context = context;
            views = new SparseArray<>();
        }
        public Builder() {
            views = new SparseArray<>();
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }


        public Builder contentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public Builder contentView(int layoutId) {
            this.contentView = LayoutInflater.from(context).inflate(layoutId, null);
            return this;
        }

        public Builder setView(@IdRes int viewId, String text) {
            initView(viewId, text);
            return this;
        }

        public Builder setView(@IdRes int viewId, int resId) {
            initView(viewId, context.getString(resId));
            return this;
        }

        private void initView(@IdRes int viewId, String text) {
            if (views == null) {
                views = new SparseArray<>();
            }
            ItemView item = views.get(viewId);
            if (item == null) {
                item = new ItemView();
                item.view = contentView.findViewById(viewId);
                item.view.setVisibility(View.VISIBLE);
                views.put(viewId, item);
            }
            if (!TextUtils.isEmpty(text)) {
                if (item.view instanceof TextView) {
                    ((TextView) item.view).setText(text);
                } else if (item.view instanceof Button) {
                    ((Button) item.view).setText(text);
                }
            }
        }

        public Builder setView(@IdRes int viewId, final ViewCallback callback) {
            if (views == null) {
                views = new SparseArray<>();
            }
            ItemView item = views.get(viewId);
            if (item == null) {
                item = new ItemView();
                item.view = contentView.findViewById(viewId);
                item.view.setVisibility(View.VISIBLE);
                item.callback = callback;
                views.put(viewId, item);
            }
            return this;
        }

        public Builder setView(@IdRes int viewId) {
            if (views == null) {
                views = new SparseArray<>();
            }
            ItemView item = views.get(viewId);
            if (item == null) {
                item = new ItemView();
                item.view = contentView.findViewById(viewId);
                item.view.setVisibility(View.VISIBLE);
                views.put(viewId, item);
            }
            return this;
        }

        public Builder setView(@IdRes int viewId, String text, final ViewCallback callback) {
            initView(viewId, text, callback);
            return this;
        }

        public Builder setView(@IdRes int viewId, int resId, final ViewCallback callback) {
            initView(viewId, context.getString(resId), callback);
            return this;
        }

        private void initView(@IdRes int viewId, String text, ViewCallback callback) {
            if (views == null) {
                views = new SparseArray<>();
            }
            ItemView item = views.get(viewId);
            if (item == null) {
                item = new ItemView();
                item.view = contentView.findViewById(viewId);
                item.view.setVisibility(View.VISIBLE);
                item.callback = callback;
                views.put(viewId, item);
            }
            if (!TextUtils.isEmpty(text)) {
                if (item.view instanceof TextView) {
                    ((TextView) item.view).setText(text);
                } else if (item.view instanceof Button) {
                    ((Button) item.view).setText(text);
                }
            }
        }

        public CommonDialog build() {
            if (context == null) {
                throw new RuntimeException("context can't be null!");
            }
            return new CommonDialog(this);
        }
    }


}
