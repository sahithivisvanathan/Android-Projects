package com.example.sahithi.fadingshapes;

import android.content.Context;





abstract class ShapeFactory{

    public enum ShapeType{
        RECTANGLE,CIRCLE
    }

    public abstract Shape getShape(Context context, ShapeType type);

}

class YellowGreen extends ShapeFactory {
    public Shape getShape(Context context, ShapeType type) {

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle(context);
                circle.setStyle(0xFFFF00, 0xff00ff00); //red and green Respectivlet
                return circle;

            case RECTANGLE:
                Rectangle rectangle = new Rectangle(context);
                rectangle.setStyle(0xFFFF00, 0xff00ff00);
                return rectangle;
        }
        return null;
    }

}

class BlueWhite extends ShapeFactory {
    public Shape getShape(Context context, ShapeType type) {

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle(context);
                circle.setStyle(0xff00ff00, 0xffffffff);
                return circle;

            case RECTANGLE:
                Rectangle rectangle = new Rectangle(context);
                rectangle.setStyle(0xff00ff00, 0xffffffff);
                return rectangle;
        }
        return null;
    }
}

class BlackWhite extends ShapeFactory {
    public Shape getShape(Context context, ShapeType type) {

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle(context);
                circle.setStyle(0xff000000, 0xffffffff);
                return circle;

            case RECTANGLE:
                Rectangle rectangle = new Rectangle(context);
                rectangle.setStyle(0xff000000, 0xffffffff);
                return rectangle;
        }
        return null;
    }

}

class BluePurple extends ShapeFactory {
    public Shape getShape(Context context, ShapeType type) {

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle(context);
                circle.setStyle(0xff0000ff, 0xffff00ff);
                return circle;

            case RECTANGLE:
                Rectangle rectangle = new Rectangle(context);
                rectangle.setStyle(0xff0000ff, 0xffff00ff);
                return rectangle;
        }
        return null;
    }

}

class RedBlue extends ShapeFactory {
    public Shape getShape(Context context, ShapeType type) {

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle(context);
                circle.setStyle(0xffff0000, 0xff0000ff);
                return circle;

            case RECTANGLE:
                Rectangle rectangle = new Rectangle(context);
                rectangle.setStyle(0xffff0000, 0xff0000ff);
                return rectangle;
        }
        return null;
    }
}
