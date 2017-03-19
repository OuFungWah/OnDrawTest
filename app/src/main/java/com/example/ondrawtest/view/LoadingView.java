package com.example.ondrawtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by 区枫华 on 2017/3/18.
 */

public class LoadingView extends View {

    /**
     * 刷新时间
     */
    private final int REFRASHTIME = 5;
    /**
     * 加速度
     */
    private double ACELERATION = 1;
    private double OFFSET = 1;
    boolean flag = true;
    boolean start = true;
    Random random = new Random();
    int colorA = random.nextInt(256);
    int colorR = random.nextInt(256);
    int colorG = random.nextInt(256);
    int colorB = random.nextInt(256);
    int radiu;
    double angle = 0;
    int pointRadiu = 200;


    int dx = 0;
    int dy = 0;
    int x;
    int y;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = getWidth() / 2;
        y = getHeight() / 2;
        if (x >= y)
            radiu = y / 2;
        else
            radiu = x / 2;

        if (start) {
            dx = x - radiu;
            dy = y;
            start = false;
        }

        //初始化画笔
        paint.setARGB(colorA, colorR, colorG, colorB);
        paint.setStrokeWidth(pointRadiu);
        paint.setStrokeCap(Paint.Cap.ROUND);


        canvas.drawPoint(dx, dy, paint);
        //自动回转
//        dy = y - (int) (radiu * Math.sin(angle));
//        dx = x - (int) (radiu * Math.cos(angle));
//        OFFSET+=ACELERATION;
//        angle += OFFSET;
        dy = y - (int) (radiu * Math.sin(Math.toRadians(angle)));
        dx = x - (int) (radiu * Math.cos(Math.toRadians(angle)));

        angle += 1;
        if (angle == 359) angle = 0;

        postInvalidateDelayed(REFRASHTIME);

    }
}