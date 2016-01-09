package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.util.Coordinates;
import com.dudley.towerdefense.sprite.util.TowerType;

/**
 * Created by Justin on 1/6/2016.
 */
public class TowerSprite extends Sprite {

    private Coordinates locationCoords;
    private String towerType;

    // Default animation is tower doing nothing
    Animation animationLevel1Tower = new Animation();
    // Default animation is tower doing nothing
    Animation animationLevel2Tower = new Animation();

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
        animationLevel1Tower.update(gameTime);
        animationLevel2Tower.update(gameTime);

        // get coordinates based on which tower build location
        // was selected. Draw tower at that location
        x = locationCoords.getX() - locationCoords.getRadius();
        y = locationCoords.getY() - locationCoords.getRadius();

        Rect dst = new Rect(x, y, x + width, y + height);

        // Draw differnt towers based on type selected by user
        if(towerType.equals(TowerType.FIRE)) {
            // TODO in here we need to check which level tower it is
            graphics.drawBitmap(bmp, animationLevel1Tower.getRect(), dst, paint);
        } else {
            graphics.drawBitmap(bmp, animationLevel2Tower.getRect(), dst, paint);
        }
    }

    private void setUpAnimations() {
        int srcX = SpriteMapper.frogRightStartX * width;
        int srcY = SpriteMapper.frogRightStartY * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationLevel1Tower.addFrame(src, 200);

        srcX = SpriteMapper.birdDownStartX * width;
        srcY = SpriteMapper.birdDownStartY * height;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationLevel2Tower.addFrame(src, 200);
    }

    public Coordinates getCoords() {
        return locationCoords;
    }

    public void setCoords(Coordinates coords) {
        this.locationCoords = coords;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }
}
