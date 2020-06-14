package com.example.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText entryText ;
    private IntentFilter intentFilter;
    private MyBroadcastReceiver2 myBroadcastReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entryText = (EditText)findViewById(R.id.entry);
        //Android 8.0以上BroadcastReceiver静态注册无法使用，因此要使用动态注册
        intentFilter=new IntentFilter();
        intentFilter.addAction("njut.computer.hello");
        myBroadcastReceiver2=new MyBroadcastReceiver2();
        registerReceiver(myBroadcastReceiver2,intentFilter);
    }
    public void send(View view){
//        Intent intent = new Intent(MainActivity.this,MyBroadcastReceiver.class);

        Intent intent=new Intent();
        ComponentName componentName=new ComponentName(MainActivity.this,MyBroadcastReceiver.class);
        intent.setComponent(componentName);
        intent.putExtra("message", entryText.getText().toString());
        sendBroadcast(intent);
    }
    public void send1(View view){
        Intent intent=new Intent();
        intent.setAction("njut.computer.hello");
        sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver2);
    }
}
