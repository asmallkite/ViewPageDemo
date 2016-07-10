package com.example.a10648.viewpagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ViewOneActivity extends AppCompatActivity {

    @InjectView(R.id.recycle_view)
    RecyclerView recycleView;
    @InjectView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_one);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.recycle_view, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recycle_view:
                break;
            case R.id.button:
                Toast.makeText(this, "dd", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
