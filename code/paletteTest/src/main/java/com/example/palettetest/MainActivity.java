package com.example.palettetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView textView;
    int img[]={R.drawable.img01,R.drawable.img02,R.drawable.img03,
                R.drawable.img06,R.drawable.img07};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        toolbar=findViewById(R.id.toolbar);
        textView=findViewById(R.id.textView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                i=i%img.length;
                imageView.setImageResource(img[i]);
                Bitmap bitmap= BitmapFactory.decodeResource(getResources(),img[i]);//把图片转换为二进制图片
                Palette.Builder builder=Palette.from(bitmap);//定义颜色提取器
                Palette.Swatch swatch=builder.generate().getVibrantSwatch();//定义色板
                if(swatch!=null)  //如果色板不为空
                {
                    toolbar.setBackgroundColor(swatch.getRgb());
                    textView.setTextColor(swatch.getTitleTextColor());
                }
            }
        });
    }
}
