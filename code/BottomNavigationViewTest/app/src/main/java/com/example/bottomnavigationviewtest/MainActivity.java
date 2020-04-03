package com.example.bottomnavigationviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    List<Fragment> list;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        list=new ArrayList<Fragment>();
        list.add(new MyFragment1());
        list.add(new MyFragment2());
        list.add(new MyFragment3());
        list.add(new MyFragment4());
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        //让菜单项和页面对应
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.item2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.item3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.item4:
                        viewPager.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
        //
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem==null){
                    menuItem=bottomNavigationView.getMenu().getItem(0);
                }
                //将上次的选择设置为false，等待下次的选择
                menuItem.setChecked(false);
                menuItem=bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private class MyAdapter extends FragmentPagerAdapter
    {
        List list;
        public MyAdapter(@NonNull FragmentManager fm, List list) {
            super(fm);
            this.list=list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return (Fragment) list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
