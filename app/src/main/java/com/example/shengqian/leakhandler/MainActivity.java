package com.example.shengqian.leakhandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private TextView mHelloTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTV = (TextView) findViewById(R.id.tv_hello);

        mHandler.postDelayed(new DoRunAble(mHelloTV), 15000);
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
