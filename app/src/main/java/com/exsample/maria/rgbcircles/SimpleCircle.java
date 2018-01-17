package com.exsample.maria.rgbcircles;

/**
 * Created by maria on 17.01.2018.
 * Предок всех кругов
 */

public class SimpleCircle {
    protected int x, y, radius;
    private int color;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    public boolean isIntersect(SimpleCircle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
    }
}
