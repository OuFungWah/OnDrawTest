package com.example.ondrawtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by 区枫华 on 2017/3/18.
 */

public class MyRandomView extends View {

    private Paint paint= new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyRandomView(Context context) {
        super(context);
    }

    public MyRandomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRandomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long partHeight=getHeight()/2;
        long partWidth= getWidth()/2;
        Random random= new Random();
        canvas.drawColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        canvas.drawCircle(partWidth,partHeight,partWidth>partHeight?partHeight:partWidth,paint);
        canvas.drawARGB(128,random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }
}
