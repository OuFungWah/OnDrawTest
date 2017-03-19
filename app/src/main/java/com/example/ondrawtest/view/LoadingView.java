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
    private final int REFRASHTIME = 10;
    /**
     * 加速度
     */
    private final double ACELERATION = 0.3;
    private double OFFSET = 0.8;
    boolean start = true;
    int radius;
    static int pointRadius = 50;

    private static Paint paintGroup[] = {new Paint(), new Paint(), new Paint(), new Paint(), new Paint(), new Paint()};
    private static int paintARGB[][] = {{255, 255, 168, 1}, {255, 255, 244, 1}, {255, 203, 255, 1}, {255, 89, 222, 157}, {255, 97, 157, 255}, {255, 209, 128, 254}};
    private double angleGroup[] = {0, 0, 0, 0, 0, 0};
    private boolean zeroGroup[] = {true, true, true, true, true, true};
    private int xyGroup[][] = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    private double offsetGroup[] = {OFFSET, OFFSET, OFFSET, OFFSET, OFFSET, OFFSET};
    int x;
    int y;

    static {
        for (int i = 0; i < paintGroup.length; i++) {
            paintGroup[i].setARGB(paintARGB[i][0], paintARGB[i][1], paintARGB[i][2], paintARGB[i][3]);
            paintGroup[i].setStrokeWidth(pointRadius);
            paintGroup[i].setStrokeCap(Paint.Cap.ROUND);
        }
    }

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
            radius = y / 2;
        else
            radius = x / 2;

        if (start) {
            for (int i = 0; i < xyGroup.length; i++) {
                xyGroup[i][0] = x - radius;
                xyGroup[i][1] = y;
            }
            start = false;
        }

        for (int i = paintGroup.length - 1; i >= 0; i--) {
            paintGroup[i].setStrokeWidth(radius/3);
                canvas.drawPoint(xyGroup[i][0], xyGroup[i][1], paintGroup[i]);
        }

        for (int i = 0; i < paintGroup.length; i++) {
            if (zeroGroup[i]){
                if (i == 0 || angleGroup[i - 1] >= 15) {
                    xyGroup[i][0] = x - (int) (radius * Math.cos(Math.toRadians(angleGroup[i])));
                    xyGroup[i][1] = y - (int) (radius * Math.sin(Math.toRadians(angleGroup[i])));

                    angleGroup[i] += offsetGroup[i];
                    if (angleGroup[i] <= 180)
                        offsetGroup[i] += ACELERATION;
                    else
                        offsetGroup[i] -= ACELERATION;
                    if (angleGroup[i] >= 359&&angleGroup[angleGroup.length-1]<=359) {
                        angleGroup[i] =360;
                        offsetGroup[i] =360;
                        zeroGroup[i]=false;
                    }
                    if(angleGroup[i] >= 359&&angleGroup[angleGroup.length-1]>359){
                        angleGroup =new double[]{0,0,0,0,0,0};
                        offsetGroup =new double[]{OFFSET,OFFSET,OFFSET,OFFSET,OFFSET,OFFSET};
                        zeroGroup =new boolean[]{true, true, true, true, true, true};
                    }
                }
            }

        }

        postInvalidateDelayed(REFRASHTIME);

    }
}