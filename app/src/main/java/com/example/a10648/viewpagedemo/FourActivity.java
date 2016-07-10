package com.example.a10648.viewpagedemo;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class FourActivity extends AppCompatActivity {

    @InjectView(R.id.tv_one)
    TextView tvOne;
    @InjectView(R.id.tv_two)
    TextView tvTwo;
    @InjectView(R.id.tv_three)
    TextView tvThree;
    @InjectView(R.id.img_cursor)
    ImageView imgCursor;
    @InjectView(R.id.vpager_four)
    ViewPager vpagerFour;


    View view1, view2, view3;
    ArrayList<View> views = new ArrayList<>();
    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面编号
    private int bmpWidth;//移动条长度
    private int oneDistance = 0;//移动条滑动一页的距离
    private int twoDistance = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.inject(this);

        //下划线动画的相关设置：
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.drawable.line)
                .getWidth();//获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);//dm is object to receive the metrics
        int screenW = dm.widthPixels;//获取分辨率率宽度
        offset = (screenW / 3 - bmpWidth) / 2 ;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imgCursor.setImageMatrix(matrix); //设置动画初始位置
        oneDistance = offset * 2 + bmpWidth;
        twoDistance = oneDistance * 2;




        view1 = LayoutInflater.from(this).inflate(R.layout.view_one, null, false);
        view2 = LayoutInflater.from(this).inflate(R.layout.view_two, null, false);
        view3 = LayoutInflater.from(this).inflate(R.layout.view_three, null, false);

        RecyclerView recyclerView = (RecyclerView)view1.findViewById(R.id.recycle_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<String> Nolist = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            Nolist.add(i + "");
        }

        List<String> linklist = new ArrayList<>();
        for (int i = 0; i < 100; i ++){
            linklist.add("www.baidu.com");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter2(linklist, this));

        views.add(view1);
        views.add(view2);
        views.add(view3);
        vpagerFour.setAdapter(new MyPagerAdapter(views));
        vpagerFour.setCurrentItem(0);//设置ViewPager当前页，从0开始算

        vpagerFour.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Animation animation = null;
                switch (position) {
                    case 0 :
                        if (currIndex == 1){
                            animation = new TranslateAnimation(oneDistance, 0, 0, 0);
                        }else if (currIndex == 2){
                            animation = new TranslateAnimation(twoDistance, 0, 0, 0);
                        }
                        break;
                    case 1:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, oneDistance, 0, 0);
                        } else if (currIndex == 2) {
                            animation = new TranslateAnimation(twoDistance, oneDistance, 0, 0);
                        }
                        break;
                    case 2:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, twoDistance, 0, 0);
                        } else if (currIndex == 1) {
                            animation = new TranslateAnimation(oneDistance, twoDistance, 0, 0);
                        }
                        break;
                }
                currIndex = position;
                animation.setFillAfter(true);// true表示图片停在动画结束位置
                animation.setDuration(300); //设置动画时间为300毫秒
                imgCursor.startAnimation(animation);//开始动画
                }




            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.vpager_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                vpagerFour.setCurrentItem(0);
                break;
            case R.id.tv_two:
                vpagerFour.setCurrentItem(1);
                break;
            case R.id.tv_three:
                vpagerFour.setCurrentItem(2);
                break;
            case R.id.vpager_four:
                break;
        }
    }
}
