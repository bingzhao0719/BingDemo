package com.bing.demo.bingdemo.bottom.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bing.demo.bingdemo.R;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;

public class BottomTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);
        ViewPager viewPager = findViewById(R.id.viewPager);
        PageNavigationView bottomTab = findViewById(R.id.tab);
        NavigationController controller = bottomTab.custom()
                .addItem(newItem(R.mipmap.ic_launcher,R.mipmap.ic_launcher,"首页"))
                .addItem(newItem(R.mipmap.ic_launcher,R.mipmap.ic_launcher,"首页"))
                .addItem(newItem(R.mipmap.ic_launcher,R.mipmap.ic_launcher,"首页"))
                .build();
        controller.setupWithViewPager(viewPager);
        controller.setSelect(2);
    }
    //创建一个Item
    private BaseTabItem newItem(int drawable,int checkedDrawable,String text){
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable,checkedDrawable,text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(0xFF009688);
        return normalItemView;
    }
}
