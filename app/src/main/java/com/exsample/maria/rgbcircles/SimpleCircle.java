package com.exsample.maria.rgbcircles;

/**
 * Created by maria on 17.01.2018.
 * Предок всех кругов
 */

public class SimpleCircle {
    int x, y, radius;
    private int color;

    SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    boolean isIntersect(SimpleCircle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
    }
}
