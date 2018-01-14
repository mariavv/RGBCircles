package com.exsample.maria.rgbcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by maria on 14.01.2018.
 * Класс рисует круги
 */

class CanvasView extends View {
    private GameManager gameManager;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gameManager = new GameManager();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}
