package com.example.sahithi.fadingshapes;


public class AbstractShapeFactory {
    public enum Style
    {
        REDBLUE, YELLOWGREEN, BLACKWHITE, BLUEWHITE, BLUEPURPLE
    }
    public ShapeFactory getShapeFactory(Style style)
    {
        switch (style)
        {
            case REDBLUE:
                return new RedBlue();
            case YELLOWGREEN:
                return new YellowGreen();
            case BLACKWHITE:
                return new BlackWhite();
            case BLUEWHITE:
                return new BlueWhite();
            case BLUEPURPLE:
                return new BluePurple();

        }
        return null;
    }







}
