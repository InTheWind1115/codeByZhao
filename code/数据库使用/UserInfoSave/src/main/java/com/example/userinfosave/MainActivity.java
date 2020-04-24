package com.example.userinfosave;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private User_Database user;
    private SQLiteDatabase sqLiteDatabase;
    private Button search_delete_btn,insert_btn,update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=new User_Database(MainActivity.this);
        sqLiteDatabase=user.getReadableDatabase();

        search_delete_btn=findViewById(R.id.search_delete);
        insert_btn=findViewById(R.id.add);
        update_btn=findViewById(R.id.update);

        search_delete_btn.setOnClickListener(this);
        insert_btn.setOnClickListener(this);
        update_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.search_delete:
                Intent intent=new Intent(MainActivity.this,Search_Delete_Activity.class);
                startActivity(intent);
                break;
            case R.id.update:
                Intent intent1=new Intent(MainActivity.this,Update_Activity.class);
                startActivity(intent1);
                break;
            case R.id.add:
                Intent intent2=new Intent(MainActivity.this,Insert_Activity.class);
                startActivity(intent2);
                break;
        }

    }
}
