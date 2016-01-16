package com.dudley.towerdefense.sprite.tower;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;

import java.util.Random;

/**
 * Created by Justin on 1/3/2016.
 */
public class TowerSprite {

    protected int BMP_ROWS = 8;
    protected int BMP_COLUMNS = 12;
    protected int x = 0;
    protected int y = 0;
    protected Graphics graphics;
    protected Bitmap bmp;
    protected int width;
    protected int height;
    private int speed = 2;
    protected int shotDelay;
    protected long gameTime;
    protected long lastPolledTime;

    public int i = 0;

    Path path;
    PathMeasure pathMeasure = new PathMeasure();

    Paint paint;

    public TowerSprite(Graphics graphics, Bitmap bmp) {
        this.graphics = graphics;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    protected void update() {

    }

    /*
     * Here we want to distinguish which direction the sprite is moving
     * so that we can display the appropriate animation (bunny is moving right
     * animation, bunny is moving left animiation, etc.)
     */


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    /**
     * Set the path the sprite will follow
     * @param path
     * @param isEnemy
     */
    public void setPath(Path path, boolean isEnemy) {
            this.path = path;
            pathMeasure.setPath(this.path, false);
    }

    protected Path getPath() {
        return this.path;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
