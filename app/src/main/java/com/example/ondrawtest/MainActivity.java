package com.example.ondrawtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button randomBtn;
    private Button circleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomBtn=(Button)findViewById(R.id.random_color_btn);
        circleBtn=(Button)findViewById(R.id.circle_btn);
        randomBtn.setOnClickListener(this);
        circleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.random_color_btn:
                Intent i = new Intent(MainActivity.this,RandomActivity.class);
                startActivity(i);
                break;
            case R.id.circle_btn:
                Intent i1 = new Intent(MainActivity.this,CircleActivity.class);
                startActivity(i1);
                break;

        }
    }
}
