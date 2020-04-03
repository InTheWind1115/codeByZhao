package com.example.activefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button;
    LinearLayout linearLayout;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        linearLayout=findViewById(R.id.line1);
        fragmentManager=getSupportFragmentManager();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources=getResources();
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(resources.getDisplayMetrics().widthPixels/3,
                        resources.getDisplayMetrics().heightPixels));
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.layout_main,new MyFragment());
                transaction.addToBackStack(null);// 添加手机回退键
                transaction.commit();


            }
        });
    }
}
