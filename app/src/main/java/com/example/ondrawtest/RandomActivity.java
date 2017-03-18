package com.example.ondrawtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ondrawtest.view.MyRandomView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 区枫华 on 2017/3/18.
 */

public class RandomActivity extends Activity {

    MyRandomView myRandomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_activity);

        myRandomView=(MyRandomView)findViewById(R.id.myrandomview);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myRandomView.invalidate();
                    }
                });
            }
        };
        timer.schedule(task,1000,1000);
    }
}
