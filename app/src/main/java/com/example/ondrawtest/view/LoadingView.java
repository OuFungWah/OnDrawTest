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
    private final int REFRASHTIME = 1;
    /**
     * 加速度
     */
    private final int ACELERATION = 10;
    private final int OFFSET=5;
    boolean flag = true;
    boolean start = true;
    Random random = new Random();
    int colorA = random.nextInt(256);
    int colorR = random.nextInt(256);
    int colorG = random.nextInt(256);
    int colorB = random.nextInt(256);
    int radiu;
    int pointRadiu = 200;
    int changeOffset = OFFSET;

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
        radiu = x / 2;
        if (start) {
            dx = x-radiu;
            dy=y;
            start = false;
        }

        //初始化画笔
        paint.setARGB(colorA, colorR, colorG, colorB);
        paint.setStrokeWidth(pointRadiu);
        paint.setStrokeCap(Paint.Cap.ROUND);


        canvas.drawPoint(dx, dy, paint);
        if (flag) {
            if (dy >= y-radiu) {
                dy -= changeOffset;
                dx = x - (int) Math.sqrt(Math.pow(radiu, 2) - Math.pow(dy-y, 2));
            } else {
                dy += changeOffset;
                dx = (int) Math.sqrt(Math.pow(radiu, 2) - Math.pow(dy-y, 2)) + x;
                flag = false;
            }
        } else {
            if (dy <= y+radiu) {
                dy += changeOffset;
                dx = (int) Math.sqrt(Math.pow(radiu, 2) - Math.pow(dy-y, 2)) + x;
            } else {
                dy -= changeOffset;
                dx = x - (int) Math.sqrt(Math.pow(radiu, 2) - Math.pow(dy-y, 2));
                flag = true;
            }
        }
        postInvalidateDelayed(REFRASHTIME);
    }


}
