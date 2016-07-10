package com.example.a10648.viewpagedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 10648 on 2016/7/10 0010.
 */
public class MyRecyclerViewAdapter2 extends RecyclerView.Adapter<MyViewHolder>{
    private List<String> linkList;
    private Context context;


    public MyRecyclerViewAdapter2(List<String> linkList, Context context) {
        this.linkList = linkList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTv.setText(linkList.get(position));

    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }
}
