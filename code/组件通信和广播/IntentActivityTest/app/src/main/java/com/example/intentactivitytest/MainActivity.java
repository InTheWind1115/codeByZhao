package com.example.intentactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View view){
        Intent intent=new Intent();
        intent.setAction("edu.njut.zhaoyanhong");
        startActivity(intent);

    }
    public void click2(View view){
        Intent intent=new Intent();
        intent.setAction("edu.njut.computer");
        intent.addCategory("edu.njut.category");
        startActivity(intent);

    }
}
