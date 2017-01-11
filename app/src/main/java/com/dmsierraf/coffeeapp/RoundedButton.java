package com.dmsierraf.coffeeapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * Created by danielsierraf on 1/11/17.
 */

public class RoundedButton extends ImageButton {

    Paint circlePaint;
    RectF oval1;

    public RoundedButton(Context context) {
        super(context);
        circlePaint = new Paint();
        int  h = this.getHeight();
        int  w = this.getWidth();
        oval1 = new RectF(0, 0, w, h);
    }

    public RoundedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePaint = new Paint();
        int  h = this.getHeight();
        int  w = this.getWidth();
        oval1 = new RectF(0, 0, w, h);
    }

    public RoundedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        circlePaint = new Paint();
        int  h = this.getHeight();
        int  w = this.getWidth();
        oval1 = new RectF(0, 0, w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.BLACK);
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        canvas.drawRoundRect(oval1, 50, 50, circlePaint);

        super.draw(canvas);
    }
}
