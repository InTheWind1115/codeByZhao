package com.example.progressbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button2);
    }
    public void download(View view){
        progress=new ProgressDialog(MainActivity.this);
        progress.setMessage("Downloading Music");   //设置进度条提示信息
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  //设置进度条风格
        progress.setIndeterminate(true);//设置进度条是否不明确
        progress.setProgress(0);//更新进度条
        progress.show();//显示ProgressDialog

        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumpTime += 5;
                        progress.setProgress(jumpTime);
                    }
                    catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
