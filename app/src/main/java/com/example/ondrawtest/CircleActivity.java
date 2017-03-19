package com.example.ondrawtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ondrawtest.view.LoadingView;

/**
 * Created by 区枫华 on 2017/3/19.
 */

public class CircleActivity extends Activity {

    LoadingView loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_activity);

        loadingView=(LoadingView)findViewById(R.id.myloading);
        //硬件加速
        loadingView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
    }
}
