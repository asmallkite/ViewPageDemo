package com.example.a10648.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class OneActivity extends AppCompatActivity {


    @InjectView(R.id.vpager_one)
    ViewPager vpagerOne;

    View view1, view2, view3;
    ArrayList<View> views = new ArrayList<>();//是否等价于 ArrayList<View> views = new ArrayList<>();若是ArrayList<View> views ;会报NPE异常


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        ButterKnife.inject(this);

        //设置recycleVIew


        view1 = LayoutInflater.from(this).inflate(R.layout.view_one, null, false);
        view2 = LayoutInflater.from(this).inflate(R.layout.view_two, null, false);
        view3 = LayoutInflater.from(this).inflate(R.layout.view_three, null, false);

        views.add(view1);
        views.add(view2);
        views.add(view3);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(views);
        vpagerOne.setAdapter(myPagerAdapter);


    }
}
