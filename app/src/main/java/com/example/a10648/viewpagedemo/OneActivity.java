package com.example.a10648.viewpagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        //测试button是否可以响应
        Button button = (Button)view1.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OneActivity.this, "it is ok ", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView)view1.findViewById(R.id.recycle_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<String> Nolist = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            Nolist.add(i + "");
        }

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new MyRecyclerAdapter(this, Nolist));

        views.add(view1);
        views.add(view2);
        views.add(view3);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(views);
        vpagerOne.setAdapter(myPagerAdapter);


    }
}
