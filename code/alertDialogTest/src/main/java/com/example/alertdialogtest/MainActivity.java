package com.example.alertdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String str[]=new String[]{"数据","分层","位置","视频","通知","购物车","信息","点赞"};
    int []image=new int[]{R.drawable.img01,
            R.drawable.img02,
            R.drawable.img03,
            R.drawable.img04 ,
            R.drawable.img05,
            R.drawable.img06,
            R.drawable.img07,
            R.drawable.img08
    };
    boolean flag[]=new boolean[]{true,true,false,false,false,true,false,false};
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dialog1(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("对话框");
        builder.setMessage("Hello");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"确定" ,Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void dialog2(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表对话框");
        builder.setItems(str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,str[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void dialog3(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("单选列表对话框");
        builder.setSingleChoiceItems(str, 2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,str[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void dialog4(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多选列表对话框");
        builder.setMultiChoiceItems(str, flag, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                flag[which]=isChecked;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<flag.length;i++)
                {
                    if (flag[i]==true)
                        content+=str[i]+"\n";
                }
                Toast.makeText(MainActivity.this,content,Toast.LENGTH_SHORT).show();
                content="";
            }
        });
        builder.show();

    }
    public void dialog5(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自定义对话框");
        List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<str.length;i++)
        {
            Map<String,Object> map=new HashMap<>();
            map.put("title",str[i]);
            map.put("image",image[i]);
            list.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,list,
                R.layout.item,
                new String[]{"title","image"},
                new int[]{R.id.textView,R.id.imageView});
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,str[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();


    }
}
