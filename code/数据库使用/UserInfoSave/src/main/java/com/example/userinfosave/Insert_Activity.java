package com.example.userinfosave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Insert_Activity extends AppCompatActivity {
    private EditText name_Edit,password_Edit,age_Edit;//
    private Spinner spinner;
    private Button save_btn;
    private String select_sex="男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_);

        name_Edit=findViewById(R.id.name);
        password_Edit=findViewById(R.id.password);
        age_Edit=findViewById(R.id.age);
        save_btn=findViewById(R.id.button);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select_sex=Insert_Activity.this.getResources().getStringArray(R.array.sex)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_Edit.getText().toString();
                String password=password_Edit.getText().toString();
                String age=age_Edit.getText().toString();
                User_Database user_database=new User_Database(Insert_Activity.this);
                SQLiteDatabase sqLiteDatabase=user_database.getReadableDatabase();
                user_database.adddata(sqLiteDatabase,name,password,select_sex,age);
                Intent intent=new Intent(Insert_Activity.this,Search_Delete_Activity.class);
                startActivity(intent);
            }
        });
    }
}
