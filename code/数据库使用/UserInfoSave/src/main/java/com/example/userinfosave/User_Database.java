package com.example.userinfosave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public final class User_Database extends SQLiteOpenHelper {
    static int counter=0;
    public User_Database(Context context)
    {
        super(context,"user-db.db",null,1);
    }
    //数据库第一次创建时调用该方法
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table user(id integer primary key autoincrement," +
                "username text not null," +
                "paswd text not null," +
                "sex text not null," +
                "age text not null);";
        sqLiteDatabase.execSQL(sql);

    }
    //数据库版本号更新时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //添加数据
    public void adddata(SQLiteDatabase sqLiteDatabase,String name,String password,String sex,String age){//
        counter++;
        ContentValues values=new ContentValues();
        values.put("id",counter);
        values.put("username",name);
        values.put("paswd",password);
        values.put("sex",sex);
        values.put("age",age);
        sqLiteDatabase.insert("user",null,values);
        sqLiteDatabase.close();
    }
    //删除数据方法
    public void delete(SQLiteDatabase sqLiteDatabase,int id) {
        sqLiteDatabase.delete("user","id=?", new String[]{id+""});
        sqLiteDatabase.close();
    }
    //修改数据方法
    public void update(SQLiteDatabase sqLiteDatabase,int id,String name,String paswd,String sex,String age){
        //创建一个ContentValues对象
        ContentValues values=new ContentValues();
        //以键值对的形式插入
        values.put("username",name);
        values.put("sex",sex);
        values.put("paswd",paswd);
        values.put("age",age);
        sqLiteDatabase.update("user",values,"id=?",new String[]{id+""});
        sqLiteDatabase.close();
    }
    //查询数据
    public List<UserInfo> queryData(SQLiteDatabase sqLiteDatabase)
    {
        Cursor cursor=sqLiteDatabase.query("user",null,null,null,null,null,"id ASC");
        List<UserInfo> list= new ArrayList<UserInfo>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String username=cursor.getString(1);
            String password=cursor.getString(2);
            String sex=cursor.getString(3);
            String age=cursor.getString(4);
            list.add(new UserInfo(id,username,password,sex,age));
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }


}
