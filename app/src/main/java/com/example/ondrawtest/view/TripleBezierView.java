package com.example.ondrawtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 区枫华 on 2017/3/20.
 */

public class TripleBezierView extends View {

    private Path mPath = new Path();
    private float mAuxiliaryOneX;
    private float mAuxiliaryOneY;
    private float mAuxiliaryTwoX=0;
    private float mAuxiliaryTwoY=0;
    private float mStartPointX;
    private float mStartPointY;
    private float mEndPointX;
    private float mEndPointY;
    private int touchId1;
    private int touchId2;

    private Paint auxiliaryLinePaint;
    private Paint mainLinePaint;
    private Paint textPaint;

    public TripleBezierView(Context context) {
        super(context);
    }

    public TripleBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        auxiliaryLinePaint= new Paint(Paint.ANTI_ALIAS_FLAG);
        auxiliaryLinePaint.setStrokeWidth(2);
        auxiliaryLinePaint.setStyle(Paint.Style.STROKE);

        mainLinePaint= new Paint(Paint.ANTI_ALIAS_FLAG);
        mainLinePaint.setStrokeWidth(8);
        mainLinePaint.setStyle(Paint.Style.STROKE);

        textPaint= new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(20);
        textPaint.setStyle(Paint.Style.STROKE);
    }

    public TripleBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();
        mPath.moveTo(mStartPointX,mStartPointY);

        canvas.drawText("开始点",mStartPointX,mStartPointY,textPaint);
        canvas.drawText("结束点",mEndPointX,mEndPointY,textPaint);
        canvas.drawText("辅助点1",mAuxiliaryOneX, mAuxiliaryOneY,textPaint);
        canvas.drawText("辅助点2",mAuxiliaryTwoX, mAuxiliaryTwoY,textPaint);

        canvas.drawLine(mStartPointX,mStartPointY,mAuxiliaryOneX,mAuxiliaryOneY,auxiliaryLinePaint);
        canvas.drawLine(mEndPointX,mEndPointY,mAuxiliaryTwoX,mAuxiliaryTwoY,auxiliaryLinePaint);
        canvas.drawLine(mAuxiliaryOneX,mAuxiliaryOneY,mAuxiliaryTwoX,mAuxiliaryTwoY,auxiliaryLinePaint);

        mPath.cubicTo(mAuxiliaryOneX,mAuxiliaryOneY,mAuxiliaryTwoX,mAuxiliaryTwoY,mEndPointX,mEndPointY);
        canvas.drawPath(mPath,mainLinePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchId1=event.getPointerId(0);

        if(event.getPointerCount()==1){

            if(event.getPointerId(0)==touchId1){
                mAuxiliaryOneX=event.getX(event.findPointerIndex(touchId1));
                mAuxiliaryOneY=event.getY(event.findPointerIndex(touchId1));
            }
            if(event.getPointerId(0)==touchId2){
                mAuxiliaryTwoX=event.getX(event.findPointerIndex(touchId2));
                mAuxiliaryTwoY=event.getY(event.findPointerIndex(touchId2));
            }

            invalidate();
        }

        if(event.getPointerCount()==2){
            touchId2=event.getPointerId(1);
            mAuxiliaryOneX=event.getX(0);
            mAuxiliaryOneY=event.getY(0);
            mAuxiliaryTwoX=event.getX(1);
            mAuxiliaryTwoY=event.getY(1);
            invalidate();
        }


        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mStartPointX =w/4;
        mStartPointY = h/2-200;

        mEndPointX = w/4*3;
        mEndPointY = h/2-200;
    }

}
