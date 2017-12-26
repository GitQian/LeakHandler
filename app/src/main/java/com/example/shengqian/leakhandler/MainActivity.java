package com.example.shengqian.leakhandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private TextView mHelloTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTV = (TextView) findViewById(R.id.tv_hello);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHelloTV.setText("十年后..");
            }
        }, 15000);
    }


}
