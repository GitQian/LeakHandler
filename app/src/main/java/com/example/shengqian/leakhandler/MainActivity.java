package com.example.shengqian.leakhandler;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler mHandler = new Handler();
    private TextView mHelloTV;
    private Button mJumpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTV = (TextView) findViewById(R.id.tv_hello);
        mJumpBtn = (Button) findViewById(R.id.btn_Jump);
        mJumpBtn.setOnClickListener(this);

        mHandler.postDelayed(new DoRunAble(mHelloTV), 15000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Jump:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }


    }

    /**
     * 静态内部类
     */
    private static class DoRunAble implements Runnable {
        private WeakReference<TextView> mTextView;

        public DoRunAble(TextView textView) {
            mTextView = new WeakReference<TextView>(textView);
        }

        @Override
        public void run() {
            TextView textView = mTextView.get();
            if (textView != null) {
                textView.setText("十年后..");
            }
        }
    }


}
