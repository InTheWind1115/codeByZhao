package com.example.intentservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService{
    int i=100;


    public MyIntentService() {
        super("");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while (i>0){
            Log.i("======",i+"");
            i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("======","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("======","onDestroy");
    }
}
