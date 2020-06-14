package com.example.bindservicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    MyService.MyBind myBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(MainActivity.this,MyService.class);
    }
    public void bind(View view){
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
    public void unbind(View view){
        unbindService(serviceConnection);
    }
    public void setValue(View view)
    {
        myBind.setValue(0);
    }
    public void getValue(View view)
    {
        Toast.makeText(MainActivity.this,myBind.getValue()+"",Toast.LENGTH_SHORT).show();
    }
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBind= (MyService.MyBind) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
