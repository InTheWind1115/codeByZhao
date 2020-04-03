package com.example.toolbartest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("子标题");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String str="";
                switch (item.getItemId())
                {
                    case R.id.item1:
                        str="您选择了编辑1";
                        break;
                    case R.id.item2:
                        str="您选择了编辑2";
                        break;
                    case R.id.item3:
                        str="您选择了编辑3";

                }
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    //让菜单起作用的方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
