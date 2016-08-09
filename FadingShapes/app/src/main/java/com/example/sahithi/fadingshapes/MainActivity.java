package com.example.sahithi.fadingshapes;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Button circle, Rectangle,clear, style;
    private RelativeLayout DrawView;
    private Shape circ, rect;
    public Vector<Shape> ShapeVector = new Vector();
    private TextView myView;
    int currentStyle =0;
    final AbstractShapeFactory StyleFactory = new AbstractShapeFactory();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle= (Button) findViewById(R.id.GetCircle);
        Rectangle= (Button) findViewById(R.id.GetRect);
        clear= (Button) findViewById(R.id.Clear);
        style= (Button) findViewById(R.id.style);
        DrawView=(RelativeLayout) findViewById(R.id.DrawView);

        myView=(TextView) findViewById(R.id.textView);



        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adjustShapeAlpha();
                ShapeFactory currentFactory=StyleFactory.getShapeFactory(AbstractShapeFactory.Style.values()[currentStyle]);
                circ= currentFactory.getShape(v.getContext(),ShapeFactory.ShapeType.CIRCLE);
                ShapeVector.add(circ);
                DrawView.addView(circ);
                updateShapeCount();







            }
        });
        Rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                adjustShapeAlpha();
                ShapeFactory currentFactory=StyleFactory.getShapeFactory(AbstractShapeFactory.Style.values()[currentStyle]);
                rect= currentFactory.getShape(v.getContext(),ShapeFactory.ShapeType.RECTANGLE);
                ShapeVector.add(rect);
                DrawView.addView(rect);
                updateShapeCount();

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            DrawView.removeAllViews();
            ShapeVector.removeAll(ShapeVector);
            updateShapeCount();
            myView.setText("screen is cleared");




            }
        });
        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                changeStyle();


            }
        });

    }
    void adjustShapeAlpha() {
        for (Shape shape2 : ShapeVector) {
            shape2.setShapeAlpha(shape2.getShapeAlpha() - 0.1f);
            if (shape2.getShapeAlpha() < 0.1f) {
                shape2.removeShape();
            }
        }
    }
    void updateShapeCount()
    {
        Shape shapes;
        String typeShape, count;
        int rCount=0;
        int cCount=0;

        for(int i=0; i<ShapeVector.size();i++)
        {
            shapes= ShapeVector.get(i);
            typeShape= shapes.getShapeType();
            if(typeShape.equalsIgnoreCase("Rectangle"))
            {
                rCount++;

            }
            if (typeShape.equalsIgnoreCase("Circle"))
            {
                cCount++;

            }
            count="Rectangles:-"+ rCount+ "Circles:-" +cCount+"Style"+AbstractShapeFactory.Style.values()[currentStyle].name();
            myView.setText(count);
        }

    }
    void changeStyle(){
        if(this.currentStyle==4)
        {
            currentStyle=0;
        }
        else {
            currentStyle++;
        }
    }

}
