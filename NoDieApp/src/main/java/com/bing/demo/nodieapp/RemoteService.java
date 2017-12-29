package com.bing.demo.nodieapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wubz on 2017/10/27.
 */

public class RemoteService extends Service {
    private MyBinder binder;
    private MyConn myConn;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new MyBinder();
        if (myConn == null) {
            myConn = new MyConn();
        }

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        RemoteService.this.bindService(new Intent(RemoteService.this,LocalService.class),myConn, Context.BIND_IMPORTANT);

    }

    class MyBinder extends IRemote.Stub {

        @Override
        public String getName() throws RemoteException {
            return "RemoteService";
        }
    }

    class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("wubingzhao", "连接本地服务成功");
            Toast.makeText(RemoteService.this,"连接本地服务成功",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(RemoteService.this,"本地服务被杀死",Toast.LENGTH_LONG).show();
            RemoteService.this.startService(new Intent(RemoteService.this,LocalService.class));
            RemoteService.this.bindService(new Intent(RemoteService.this,LocalService.class),myConn, Context.BIND_IMPORTANT);

        }
    }
}
