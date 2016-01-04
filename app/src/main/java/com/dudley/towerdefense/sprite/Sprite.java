package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class Sprite {

    protected static final int BMP_ROWS = 8;
    protected static final int BMP_COLUMNS = 12;
    protected int x =  0;
    protected int y = 0;
    protected Graphics graphics;
    protected Bitmap bmp;
    protected int currentFrame = 0;
    protected int width;
    protected int height;
    private int speed = 2;
    long lastPolledTime;


    Paint paint;

    public Sprite(Graphics graphics, Bitmap bmp) {
        this.graphics = graphics;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    protected void update(long gameTime) {
        moveRight();

        if(currentFrame == 2) {
            currentFrame = 0;
        }

        if (gameTime > lastPolledTime + 100) {
            lastPolledTime = gameTime;
            if (currentFrame < 3) {
                currentFrame++;
            } else {
                currentFrame = 0;
            }
        }
    }

    public void moveRight() {
        if (x < graphics.getWidth()){
            x += speed;
        }
    };

    public void moveLeft() {
        if (x > 0) {
           x -= speed;
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
}
