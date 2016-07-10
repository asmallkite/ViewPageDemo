package com.example.a10648.viewpagedemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MyPagerAdapter extends PagerAdapter {
    private ArrayList<View> viewLists;

    public MyPagerAdapter() {
    }

    public MyPagerAdapter(ArrayList<View> viewLists) {
        super();
        this.viewLists = viewLists;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(viewLists.get(position));
        /*会抛出一个空指针异常，调试模式到这一步时，会观察到通过findViewbyId方法得到的listview是一个空对象。
原来findviewById是View这个类中的方法，默认调用时其实应该是：
this.findviewById();

由于上图代码中的R.id.herolist这个listview的声明并不在当前的viewPager所在的xml布局中，所以直接通过findviewById方法是不能得到该listview的实例的。*/
//        Button button = (Button)viewLists.get(position).findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(viewLists.get(position).getContext(), "test ok", Toast.LENGTH_SHORT).show();
//            }
//        });
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }
}
