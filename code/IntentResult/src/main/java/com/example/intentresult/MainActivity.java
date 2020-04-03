package com.example.intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button tijiao;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tijiao=findViewById(R.id.button);
        textView=findViewById(R.id.textView3);
        editText=findViewById(R.id.editText);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,0x01);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0x01&&resultCode==0x02)
        {
            String value2=data.getStringExtra("value2");
            textView.setText(value2);
        }
    }
}
