package com.example.ondrawtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button randomBtn;
    private Button circleBtn;
    private Button bezierBtn;
    private Button tripleBezierBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomBtn=(Button)findViewById(R.id.random_color_btn);
        circleBtn=(Button)findViewById(R.id.circle_btn);
        bezierBtn= (Button)findViewById(R.id.bezier_btn);
        tripleBezierBtn= (Button)findViewById(R.id.triple_bezier_btn) ;
        randomBtn.setOnClickListener(this);
        circleBtn.setOnClickListener(this);
        bezierBtn.setOnClickListener(this);
        tripleBezierBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.random_color_btn:
                startActivity(new Intent(MainActivity.this,RandomActivity.class));
                break;
            case R.id.circle_btn:
                startActivity(new Intent(MainActivity.this,CircleActivity.class));
                break;
            case R.id.bezier_btn:
                startActivity(new Intent(MainActivity.this,DoubleBezierActivity.class));
                break;
            case R.id.triple_bezier_btn:
                startActivity(new Intent(MainActivity.this,TripleBezierActivity.class));
                break;
        }
    }
}
