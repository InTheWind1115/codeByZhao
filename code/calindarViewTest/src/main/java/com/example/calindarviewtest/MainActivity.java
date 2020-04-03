package com.example.calindarviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String strTime;
    CalendarView calendarView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView=findViewById(R.id.calendarView);
        button=findViewById(R.id.button);
        //日期格式化对象
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");

        strTime=format.format(calendarView.getDate());
//        监听器CalendarView.OnDateChangeListener负责处理CalendarView对象的日期选择变化事件
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                strTime=year+"年"+(month+1)+"月"+dayOfMonth+"日";
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,strTime,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
