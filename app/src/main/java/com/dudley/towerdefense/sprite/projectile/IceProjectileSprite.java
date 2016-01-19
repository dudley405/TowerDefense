package com.dudley.towerdefense.sprite.projectile;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.sprite.Sprite;

/**
 * Created by lenovo on 1/11/2016.
 */
public class IceProjectileSprite extends Sprite {

    Sprite target;
    Animation shootingAnimation = new Animation();
    Paint paint;
    long aliveTime;
    long lastPolledTime;
    long gameTime;
    private int damage;

    public IceProjectileSprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);

        BMP_ROWS = 4;
        BMP_COLUMNS = 4;

        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;;

        setUpAnimations();

        setSpeed(10);
        damage = 50;
        health = 100;
        aliveTime = 0;
        lastPolledTime = System.currentTimeMillis();

        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    public void onDraw() {
        update();

        gameTime = System.currentTimeMillis();
        aliveTime += gameTime - lastPolledTime;

        Rect dst = new Rect(x, y, x + width, y + height);

        graphics.drawBitmap(bmp, shootingAnimation.getRect(), dst, paint);

    }

    public void update() {
        getPathPoints();
    }

    private void setUpAnimations() {
        int srcX = 0;
        int srcY = 0;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        shootingAnimation.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        shootingAnimation.addFrame(src,200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        shootingAnimation.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        shootingAnimation.addFrame(src, 200);
    }

    public void setTarget(Sprite enemySprite) {
        this.target = enemySprite;
    }

    public Sprite getTarget() {
        return this.target;
    }

    @Override
    public int getXCoord() {
        return this.x;
    }

    @Override
    public int getYCoord(){
        return this.y;
    }

    public boolean checkCollision(Rect projectile, Rect enemy) {
        if(projectile.intersect(enemy)) {
            return true;
        } else {
            return false;
        }
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
