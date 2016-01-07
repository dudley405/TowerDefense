package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/6/2016.
 */
public class TowerSprite extends Sprite {

    public TowerSprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);

        setUpAnimations();
    }

    public void onDraw() {
        update();

        long gameTime = System.currentTimeMillis();
        animationLeft.update(gameTime);
        animationRight.update(gameTime);
        animationUp.update(gameTime);
        animationDown.update(gameTime);

        Rect dst = new Rect(x, y, x + width, y + height);
        if (isMovingRight) {
            graphics.drawBitmap(bmp, animationRight.getRect(), dst, paint);
        } else if (isMovingLeft) {
            graphics.drawBitmap(bmp, animationLeft.getRect(), dst, paint);
        } else if (isMovingUp) {
            graphics.drawBitmap(bmp, animationUp.getRect(), dst, paint);
        } else if (isMovingDown) {
            graphics.drawBitmap(bmp, animationDown.getRect(), dst, paint);
        }
    }

    private void setUpAnimations() {

    }
}
