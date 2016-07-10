package com.example.a10648.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TwoActivity extends AppCompatActivity {

    @InjectView(R.id.vpager_two)
    ViewPager vpagerTwo;

    View view1, view2, view3;
    ArrayList<View> views = new ArrayList<>();
    ArrayList<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);


        view1 = LayoutInflater.from(this).inflate(R.layout.view_one, null, false);
        view2 = LayoutInflater.from(this).inflate(R.layout.view_two, null, false);
        view3 = LayoutInflater.from(this).inflate(R.layout.view_three, null, false);

        views.add(view1);
        views.add(view2);
        views.add(view3);


        titleList.add("橘黄");
        titleList.add("淡黄");
        titleList.add("浅棕");


        MyPagerAdapter2 myPagerAdapter2 = new MyPagerAdapter2(views, titleList);
        vpagerTwo.setAdapter(myPagerAdapter2);
    }


}
