package com.example.userinfosave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.PriorityQueue;

public class Search_Delete_Activity extends AppCompatActivity {
    private ListView user_list;
    private List<UserInfo> list;
    private SQLiteDatabase sqLiteDatabase;
    private String user_mes[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search__delete_);
        user_list=findViewById(R.id.listview);
        User_Database users=new User_Database(Search_Delete_Activity.this);
        sqLiteDatabase=users.getReadableDatabase();
        //获取从数据库中查询到的数据
        list=users.queryData(sqLiteDatabase);
        //把获取到的信息添加到用户名数组中
        user_mes=new String[list.size()];
        for (int i=0;i<list.size();i++)
        {
            user_mes[i]=list.get(i).getId()+"  "+
                    list.get(i).getUsername()+"  "
                    +list.get(i).getPassword()+"  "
                    +list.get(i).getSex()+"  "
                    +list.get(i).getAge();
        }
        //把用户名显示到listView上
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(Search_Delete_Activity.this,
                R.layout.simple_list_item_1,user_mes);
        user_list.setAdapter(adapter);
        //为ListView每个元素添加单击事件
        user_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int id1=list.get(position).getId();
                new AlertDialog.Builder(Search_Delete_Activity.this).setTitle("系统提示")
                        .setMessage("确定删除这条数据吗！")//设置显示内容
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //删除数据操作，首先获取到id
                                User_Database user_database=new User_Database(Search_Delete_Activity.this);
                                SQLiteDatabase sqLiteDatabase=user_database.getWritableDatabase();
                                user_database.delete(sqLiteDatabase,id1);
                                refresh();
                                Toast.makeText(Search_Delete_Activity.this,"删除成功",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

    }

    private void refresh()
    {
        finish();
        Intent intent=new Intent(Search_Delete_Activity.this,Search_Delete_Activity.class);
        startActivity(intent);

    }

}
