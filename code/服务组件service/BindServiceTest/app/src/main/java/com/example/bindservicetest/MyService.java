package com.example.bindservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.LinearLayout;

public class MyService extends Service {
    int value;
    boolean flag;

    public MyService() {
    }
    class MyBind extends Binder{

        public void setValue(int i)
        {
            value=i;
        }
        public int getValue()
        {
            return value;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i("======","绑定成功");
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("======","解除绑定");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        flag=true;
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                while (flag){
                    value++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;
    }
}
