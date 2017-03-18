package com.example.ondrawtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button randomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomBtn=(Button)findViewById(R.id.random_color_btn);
        randomBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.random_color_btn:
                Intent i = new Intent(MainActivity.this,RandomActivity.class);
                startActivity(i);
                break;
        }
    }
}
