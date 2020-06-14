package com.example.readwritefile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
    }
    public void click0(View view) throws IOException {
        String environment = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(environment)) {
//
            //外部设备可以进行读写操作
            File sd_path =new File(getExternalFilesDir("exter_test").getAbsolutePath()); // //Environment.getExternalStorageDirectory();//new File(getExternalFilesDir("exter_test").getAbsolutePath()); //Environment.getExternalStorageDirectory();
            Log.i("====",sd_path.toString());
//            Log.i("====", "getFilesDir = "  + getFilesDir());
//
//            Log.i("====", "getExternalFilesDir = "  + getExternalFilesDir("exter_test").getAbsolutePath());
//
//            Log.i("====", "getDownloadCacheDirectory = "  + Environment.getDownloadCacheDirectory().getAbsolutePath());
//
//            Log.i("====", "getDataDirectory = "  + Environment.getDataDirectory().getAbsolutePath());
//
//            Log.i("====", "getExternalStorageDirectory = "  + Environment.getExternalStorageDirectory().getAbsolutePath());

            File file = new File(sd_path, "test.txt");

            String str = editText.getText().toString();
            FileOutputStream fos;
            try {
                //写入数据
                fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                osw.write(str);
                osw.flush();
                osw.close();
                fos.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public void click1(View view) throws IOException {

        String environment=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(environment)) {
            //外部设备可以进行读写操作
            File sd_path= new File(getExternalFilesDir("exter_test").getAbsolutePath());//Environment.getExternalStorageDirectory();//new File(getExternalFilesDir("exter_test").getAbsolutePath());//getFilesDir();//Environment.getExternalStorageDirectory();

            //if (!sd_path.exists()) {return; }
            File file=new File(sd_path,"test.txt");
            FileInputStream fis;
            try{
                //读取文件
                fis=new FileInputStream(file);
                InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
                char[] input=new char[fis.available()];
                isr.read(input);
                String s=new String(input);
                editText.setText(s);
                isr.close();
                fis.close();
            }
            catch(Exception exception){  exception.printStackTrace(); 		}
        }
    }


    public void click2(View view){
        //文件名称
        String file_name="test.txt";
        //写入文件的数据
        String str=editText.getText().toString();
        FileOutputStream fi_out;
        try{
            fi_out=openFileOutput (file_name, MODE_PRIVATE);
            fi_out.write(str.getBytes());
            fi_out.close();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void click3(View view){
        String file_name="test.txt";
        //保存读取的数据
        String str="";
        FileInputStream fi_in;
        try{
            fi_in=openFileInput(file_name);
            //fi_in.available()返回的实际可读字节数
            byte[] buffer=new byte[fi_in.available()];
            fi_in.read(buffer);
            str=new String(buffer);
            editText.setText(str);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
