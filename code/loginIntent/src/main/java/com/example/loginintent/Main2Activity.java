package com.example.loginintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        String userName=intent.getStringExtra("userName");
        String password=intent.getStringExtra("password");
        textView.setText("用户名；"+userName+"\n"+"密码："+password);
    }
}
