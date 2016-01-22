package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;

import java.util.Random;

/**
 * Created by Justin on 1/3/2016.
 */
public class Sprite {

    protected int BMP_ROWS = 8;
    protected int BMP_COLUMNS = 12;
    protected Graphics graphics;
    protected Bitmap bmp;
    public int x;
    public int y;
    protected int[] mX;
    protected int[] mY;
    public int lastXPoint;
    public int lastYPoint;
    protected int width;
    protected int height;
    public int health;
    Path path;
    PathMeasure pathMeasure = new PathMeasure();
    int speed;
    private boolean isReady = false;

    public boolean isFinished = false;

    public int i = 0;

    Paint paint;

    public Sprite(Graphics graphics, Bitmap bmp) {
        this.graphics = graphics;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    /**
     * Set the path the sprite will follow
     * @param path
     * @param isEnemy
     */
    public void setPath(Path path, boolean isEnemy) {
        if(isEnemy) {
            this.path = path;
            // if its an enemy sprite, we want some variance
            // so that you can see each sprite
            Random rand = new Random();
            int xOffset = rand.nextInt(30) - 15;
            int yOffset = rand.nextInt(30) - 15;
            this.path.offset(xOffset, yOffset);
            pathMeasure.setPath(this.path, false);
        } else {
            this.path = path;
            pathMeasure.setPath(this.path, false);
        }
    }

    public void onDraw() {
        update();
    }

    public void update() {

    }

    /**
     * Get the path that the sprite will follow. The sprite will follow
     * the path at what speed is set
     */
    protected void getPathPoints() {

        final float pathLength = pathMeasure.getLength();
        final int numPoints = (int) (pathLength / speed) + 1;

        if (mX == null || mY == null) {
            mX = new int[numPoints];
            mY = new int[numPoints];
        }

        final float[] position = new float[2];
        if (i < numPoints && !isFinished && health > 0) {
            final float distance = (i * pathLength) / (numPoints - 1);
            pathMeasure.getPosTan(distance, position, null /* tangent */);

            mX[i] = (int) position[0];
            this.x = (int) position[0];
            mY[i] = (int) position[1];
            this.y = (int) position[1];

            if (i > 0) {
                lastXPoint = mX[i - 1];
                lastYPoint = mY[i - 1];
            }

            i++;

        } else {
            isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished() {
        this.isFinished = true;
    }

    public int getXCoord() {
        return x;
    }

    public int getYCoord() {
        return y;
    }


    public void hit(int damage) {
        health -= damage;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setReady() {
        isReady = true;
    }

    public boolean isReady() {
        return isReady;
    }
}
