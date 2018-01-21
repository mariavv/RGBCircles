package com.exsample.maria.rgbcircles;

import android.graphics.Color;

/**
 * Created by maria on 14.01.2018.
 * Главный круг
 */

class MainCircle extends SimpleCircle{

    private static final int INIT_RADIUS = 50;
    private static final int MAIN_SPEED = 30;
    private static final int COLOR = Color.BLUE;

    private int r;
    private int ms;

    MainCircle(int x, int y) {
        super(x, y, CanvasView.adjustSizeForScreenResolution(INIT_RADIUS));
        r = radius;
        ms = CanvasView.adjustSizeForScreenResolution(MAIN_SPEED);
        setColor(COLOR);
    }

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * ms / GameManager.getWidth();
        int dy = (y1 - y) * ms / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    void initRadius() {
        radius = r;
    }

    void growRadius(EnemyCircle circle) {
        // pi * newr ^ 2 == pi * r ^ 2 + pi * reat ^ 2;
        // newr = sqrt(r ^ 2 + reat ^ 2);
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));
    }
}
