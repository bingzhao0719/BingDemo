package com.bing.demo.bingdemo.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bing.demo.bingdemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import static android.R.layout.simple_list_item_2;

public class ListActivity extends AppCompatActivity {

    private BaseQuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView listView = (RecyclerView) findViewById(R.id.listview);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(mAdapter = new BaseQuickAdapter(simple_list_item_2,initData()) {
            @Override
            protected void convert(BaseViewHolder holder, Object item) {
                holder.setText(android.R.id.text1,String.format(Locale.CHINA, "第%02d条数据", holder.getLayoutPosition()));
                holder.setText(android.R.id.text2,String.format(Locale.CHINA, "这是测试的第%02d条数据", holder.getLayoutPosition()));
            }
        });
        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
//        refreshLayout.setEnableLoadmore(false);
//        refreshLayout.setEnableAutoLoadmore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setNewData(initData());
                        refreshlayout.finishRefresh();
                        refreshlayout.setLoadmoreFinished(false);
                    }
                }, 2000);
            }
        });
//        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                Log.e("wubingzhao", "onLoadMoreRequested: ");
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mAdapter.addData(initData());
//                        mAdapter.loadMoreComplete();
//                        if (mAdapter.getItemCount() > 60) {
//                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
//                            mAdapter.loadMoreEnd(true);
//                        }
//                    }
//                }, 2000);
//            }
//        },listView);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.addData(initData());
                        refreshlayout.finishLoadmore();
                        if (mAdapter.getItemCount() > 60) {
                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
//                            refreshlayout.setEnableLoadmore(false);
                            refreshlayout.finishLoadmoreWithNoMoreData();
                        }
                    }
                }, 2000);
            }
        });

        //触发自动刷新
        refreshLayout.autoRefresh();
    }
    private ArrayList<Object> initData() {
        return new ArrayList<>(Arrays.asList(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
    }
}
