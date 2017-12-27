package com.example.shengqian.leakhandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private TextView mSecondTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSecondTv = (TextView) findViewById(R.id.tv_second);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondTv.setText("llllll");
            }
        }, 100000);
    }
}
