package com.example.floatingactionbuttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show1(View view)
    {
        Toast.makeText(MainActivity.this,"普通toast提示",Toast.LENGTH_SHORT).show();
    }
    public void show2(View view)
    {
        Snackbar.make(view,"Snackbar测试",Snackbar.LENGTH_SHORT)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"【确定】",Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
