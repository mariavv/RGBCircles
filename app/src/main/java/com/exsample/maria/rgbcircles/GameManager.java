package com.exsample.maria.rgbcircles;

import java.util.ArrayList;

/**
 * Created by maria on 14.01.2018.
 * Логика игры
 */

class GameManager {
    private static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnamyCircles();
    }

    private void initEnamyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnamyOrFoodColorDependsOn(mainCircle);
        }
    }

    static int getWidth() {
        return width;
    }

    static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        EnemyCircle circleForDel = null;
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThen(mainCircle)) {
                    mainCircle.growRadius(circle);
                    circleForDel = circle;
                    calculateAndSetCirclesColor();
                    break;
                } else {
                    gameEnd("GAME OVER!");
                    return;
                }
            }
        }
        if (circleForDel != null) {
            circles.remove(circleForDel);
        }
        if (circles.isEmpty()) {
            gameEnd("WIN!");
        }
    }

    private void gameEnd(String s) {
        canvasView.showMessage(s);
        mainCircle.initRadius();
        initEnamyCircles();
        canvasView.reDraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {
            circle.moveOneStep();
        }
    }
}
