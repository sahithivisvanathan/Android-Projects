package com.example.sahithi.fadingshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Rectangle extends Shape {

    public Rectangle(Context context) {
        super(context);
        this.border= new Paint();
        this.fill= new Paint();


    }

    @Override
    String getShapeType() {
        return "RECTANGLE";
    }

    @Override
    public void onDraw(Canvas canvas)

    {
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(20);
        fill.setStyle(Paint.Style.FILL);
        Random rand = new Random();
        int left = rand.nextInt(getWidth()-10)+10;
        int top = rand.nextInt(getHeight()-10)+10;
        int right = left + rand.nextInt(getWidth()+10);
        int bottom = top + rand.nextInt(getHeight()+10);



        canvas.drawRect(left,top,right,bottom,border);
        canvas.drawRect(left,top,right,bottom,fill);

    }



}
