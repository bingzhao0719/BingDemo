package com.bing.demo.bingdemo.shortcut;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bing.demo.bingdemo.R;
import com.bing.demo.bingdemo.bottom.tab.BottomTabActivity;

/**
 * Created by wubz on 2018/1/4.
 */

public class ShortCutUtils {

    public static void createShortCut(Context context,String title) {
//        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        Intent shortcut = new Intent(Intent.ACTION_CREATE_SHORTCUT);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context, R.mipmap.icon_network_error));
        shortcut.putExtra("duplicate", 0); // 不允许重复创建
        Intent intent = new Intent(context, BottomTabActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
//                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//        intent.setAction("android.intent.action.MAIN");
//        intent.addCategory("android.intent.category.LAUNCHER");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        context.sendBroadcast(shortcut);
        Log.e("wubingzhao", "createShortCut 创建快捷方式成功: ");

    }
    public static void delShortcut(Context context)
    {
        Intent shortcut = new Intent(
                "com.android.launcher.action.UNINSTALL_SHORTCUT");

        //快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,"我是快捷方式1");
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(context,
                R.mipmap.icon_network_error );
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        Intent intent = new Intent(context, BottomTabActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");

        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);

        context.sendBroadcast(shortcut);

    }

    public static void createShortCut2(Context context) {

        Intent shortcut = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
        // 快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                "我是快捷方式");
        shortcut.putExtra("duplicate", false); // 不允许重复创建
        // 快捷方式的图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(context,
                R.mipmap.icon_network_error);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        Intent intent = new Intent(context, BottomTabActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        context.sendBroadcast(shortcut);

    }
}
