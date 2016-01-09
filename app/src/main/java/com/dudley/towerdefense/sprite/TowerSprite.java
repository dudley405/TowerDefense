package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.util.Coordinates;

/**
 * Created by Justin on 1/6/2016.
 */
public class TowerSprite extends Sprite {

    private Coordinates locationCoords;

    Animation animationDefault = new Animation();

    public TowerSprite(Graphics graphics, Bitmap bmp, Coordinates coords) {
        super(graphics, bmp);

        this.locationCoords = coords;

        setUpAnimations();
    }

    public void onDraw() {
        update();

        long gameTime = System.currentTimeMillis();
        animationLeft.update(gameTime);
        animationRight.update(gameTime);
        animationUp.update(gameTime);
        animationDown.update(gameTime);
        animationDefault.update(gameTime);

        x = locationCoords.getX();
        y = locationCoords.getY();

        Rect dst = new Rect(x, y, x + width, y + height);

        graphics.drawBitmap(bmp, animationDefault.getRect(), dst, paint);

    }

    private void setUpAnimations() {
        int srcX = SpriteMapper.frogRightStartX * width;
        int srcY = SpriteMapper.frogRightStartY * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationDefault.addFrame(src, 200);
    }

    public Coordinates getCoords() {
        return locationCoords;
    }

    public void setCoords(Coordinates coords) {
        this.locationCoords = coords;
    }
}
