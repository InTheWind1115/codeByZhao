package com.example.appbarlayouttest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> list;
    String title[]=new String[]{"经济","新闻","娱乐"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewPager);
        list=new ArrayList<Fragment>();
        list.add(new MyFragment1());
        list.add(new MyFragment2());
        list.add(new MyFragment3());
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tabLayout.setupWithViewPager(viewPager);

    }
    class MyAdapter extends FragmentPagerAdapter
    {
        List list;
        public MyAdapter(@NonNull FragmentManager fm,List list) {
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
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
