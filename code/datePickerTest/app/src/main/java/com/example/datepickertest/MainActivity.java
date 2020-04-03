package com.example.datepickertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button button;
    String strTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=findViewById(R.id.datePicker);
        button=findViewById(R.id.button);
        strTime=datePicker.getYear()+"年" +(datePicker.getMonth()+1)+"月"+datePicker.getDayOfMonth()+"日";
//        监听器DatePicker.OnDateChangedListener负责处理日期选择变化事件
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                strTime=year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日";
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
