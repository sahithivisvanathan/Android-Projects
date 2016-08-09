package com.example.sahithi.fadingshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


public abstract class Shape extends View
{
    public float alpha;
    public Paint border;
    public Paint fill;

    public Shape(Context context) {
        super(context);
        setShapeAlpha(1.0f);

    }
    void setShapeAlpha(float alpha1)
    {

       alpha=alpha1;
    }
    public float getShapeAlpha()
    {
        return alpha;
    }
    void removeShape()
    {
        setVisibility(View.GONE);
        destroyDrawingCache();


    }
    void setStyle(int bColor, int fColor)
    {
        border.setColor(bColor);
        fill.setColor(fColor);
    }
    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);

}
