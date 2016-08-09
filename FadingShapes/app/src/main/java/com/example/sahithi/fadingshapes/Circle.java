package com.example.sahithi.fadingshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import java.util.Random;

/**
 * Created by adi on 3/19/2016.
 */
public class Circle extends Shape
{


    public Circle(Context context) {

        super(context);
        this.border= new Paint();
        this.fill= new Paint();



    }



    @Override
    public void onDraw(Canvas canvas)

    {
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(20);
        fill.setStyle(Paint.Style.FILL);
        Random rand= new Random();

        canvas.drawCircle(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(150),border);
        canvas.drawCircle(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(150),fill);


    }


    @Override
    String getShapeType()
    {
        return "CIRCLE";
    }
}
