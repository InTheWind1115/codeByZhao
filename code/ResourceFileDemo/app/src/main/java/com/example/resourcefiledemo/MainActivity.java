package com.example.resourcefiledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //定义Resources资源对象
    private Resources resources;

    private TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button readRawButton = (Button)findViewById(R.id.read_raw);
        Button readXmlButton = (Button)findViewById(R.id.read_xml);
        Button clearButton = (Button)findViewById(R.id.clear);
        readRawButton.setOnClickListener(readRawButtonListener);
        readXmlButton.setOnClickListener(readXmlButtonListener);
        clearButton.setOnClickListener(clearButtonListener);

        this.displayView = (TextView)findViewById(R.id.display);
        //获得资源实例
        this.resources = this.getResources();
    }
    OnClickListener readRawButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            InputStream inputStream = null;
            try {
                //以二进制流的形式打开指定的原始格式文件
                inputStream = resources.openRawResource(R.raw.raw_file);
                byte[] reader = new byte[inputStream.available()];
                while (inputStream.read(reader) != -1) {
                }
                //表示以UTF-8的编码方式从字节数组中实例化一个字符串
                String str=new String(reader,"utf-8");
                displayView.setText(str);
            } catch (IOException e) {
                Log.e("ResourceFileDemo", e.getMessage(), e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (IOException e) { }
                }
            }
        }
    };


    OnClickListener readXmlButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //调用资源实例的getXml()函数，获取到XML解析器XmlPullParser
            XmlPullParser parser = resources.getXml(R.xml.people);
            String msg = "";
            try {
                //parser.next()方法可以获取到高等级的解析事件
                while (parser.next() != XmlPullParser.END_DOCUMENT) {
                    String people = parser.getName();
                    String name = null;
                    String age = null;
                    String height = null;
                    if ((people != null) && people.equals("person")) {
                        int count = parser.getAttributeCount();
                        for (int i = 0; i < count; i++) {
                            String attrName = parser.getAttributeName(i);
                            String attrValue = parser.getAttributeValue(i);
                            if ((attrName != null) && attrName.equals("name")) {
                                name = attrValue;
                            } else if ((attrName != null) && attrName.equals("age")) {
                                age = attrValue;
                            } else if ((attrName != null) && attrName.equals("height")) {
                                height = attrValue;
                            }
                        }
                        if ((name != null) && (age != null) && (height != null)) {
                            msg += "姓名："+name+"，年龄："+age+"，身高："+height+"\n";
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("ResourceFileDemo", e.getMessage(), e);
            }
            displayView.setText(msg);
        }
    };

    OnClickListener clearButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            displayView.setText("");
        }
    };
}
