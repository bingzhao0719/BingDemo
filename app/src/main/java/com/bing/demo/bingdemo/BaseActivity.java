package com.bing.demo.bingdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.free.statuslayout.manager.StatusLayoutManager;

/**
 * Created by wubz on 2017/12/30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected StatusLayoutManager mStatusManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mStatusManager = initStatusManager();

        LinearLayout mainLl = (LinearLayout) findViewById(R.id.main_rl);
        mainLl.addView(mStatusManager.getRootLayout());

        initToolBar();
    }

    protected abstract StatusLayoutManager initStatusManager();

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_bar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_content) {
                    showContent();
                }
                if(item.getItemId() == R.id.action_emptyData) {
                    showEmptyData();
                }
                if(item.getItemId() == R.id.action_error) {
                    showError();
                }
                if(item.getItemId() == R.id.action_networkError) {
                    mStatusManager.showNetWorkError();
                }
                if(item.getItemId() == R.id.action_loading) {
                    mStatusManager.showLoading();
                }
                return true;
            }
        });
    }

    protected void showContent() {
        mStatusManager.showContent();
    }

    protected void showEmptyData() {
        mStatusManager.showEmptyData();
    }

    protected void showError() {
        mStatusManager.showError();
    }
}
