package com.example.intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView5);
        editText=findViewById(R.id.editText2);
        button=findViewById(R.id.button2);
        final Intent intent=getIntent();
        String value=intent.getStringExtra("value");
        textView.setText(value);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value2",editText.getText().toString());
                setResult(0x02,intent);
                finish();
            }
        });
    }
}
