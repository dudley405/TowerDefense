package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class Sprite {

    protected static final int BMP_ROWS = 8;
    protected static final int BMP_COLUMNS = 12;
    protected int x =  0;
    protected int y = 0;
    protected int[] mX;
    protected int[] mY;
    protected int lastXPoint;
    protected int lastYPoint;
    protected Graphics graphics;
    protected Bitmap bmp;
    protected int width;
    protected int height;
    private int speed = 2;

    boolean isMovingRight;
    boolean isMovingLeft;
    boolean isMovingDown;
    boolean isMovingUp;

    public int i = 0;

    Animation animationLeft = new Animation();
    Animation animationRight = new Animation();
    Animation animationUp = new Animation();
    Animation animationDown = new Animation();

    Path path;
    PathMeasure pathMeasure = new PathMeasure();

    Paint paint;

    public Sprite(Graphics graphics, Bitmap bmp) {
        this.graphics = graphics;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    protected void update() {
        getPathPoints();

        // Set animation based on direction of movement
        if (x < lastXPoint) {
            moveLeft();
        } else if (x > lastXPoint) {
            moveRight();
        } else if (y < lastYPoint) {
            moveUp();
        } else if (y > lastYPoint) {
            moveDown();
        }

    }

    public void moveRight() {
        isMovingRight = true;
        isMovingLeft = false;
        isMovingUp = false;
        isMovingDown = false;
    };

    public void moveLeft() {
        isMovingLeft = true;
        isMovingRight = false;
        isMovingUp = false;
        isMovingDown = false;
    }

    public void moveUp() {
        isMovingUp = true;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingDown = false;
    }

    public void moveDown() {
        isMovingDown = true;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingUp = false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setPath(Path path){
        this.path = path;
        pathMeasure.setPath(this.path, false);
    }

    protected Path getPath() {
        return this.path;
    }

    protected void getPathPoints() {

        final float pathLength = pathMeasure.getLength();
        final int numPoints = (int) (pathLength / speed) + 1;

        if (mX == null || mY == null) {
            mX = new int[numPoints];
            mY = new int[numPoints];
        }

        final float[] position = new float[2];
        if (i < numPoints) {
            final float distance = (i * pathLength) / (numPoints - 1);
            pathMeasure.getPosTan(distance, position, null /* tangent */);

            x = mX[i] = (int) position[0];
            y = mY[i] = (int) position[1];

            if(i > 0) {
                lastXPoint = mX[i - 1];
                lastYPoint = mY[i - 1];
            }
            if(i != (numPoints - 1)) {
                i++;
            }
        }
    }

    public int getXCoord() {
        return x;
    }

    public int getYCoord(){
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
