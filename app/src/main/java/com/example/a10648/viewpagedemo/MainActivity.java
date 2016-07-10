package com.example.a10648.viewpagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_one)
    Button btnOne;
    @InjectView(R.id.btn_two)
    Button btnTwo;
    @InjectView(R.id.btn_three)
    Button btnThree;
    @InjectView(R.id.btn_four)
    Button btnFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                Intent intent = new Intent(MainActivity.this, OneActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, TwoActivity.class));
                break;
            case R.id.btn_three:
                break;
            case R.id.btn_four:
                break;
        }
    }
}
