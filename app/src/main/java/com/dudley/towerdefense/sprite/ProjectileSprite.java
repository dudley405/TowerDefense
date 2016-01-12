package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.sprite.util.TowerType;

/**
 * Created by lenovo on 1/11/2016.
 */
public class ProjectileSprite extends Sprite {

    public ProjectileSprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);

        BMP_ROWS = 4;
        BMP_COLUMNS = 4;

        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;;

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

        graphics.drawBitmap(bmp, animationLeft.getRect(), dst, paint);

    }

    private void setUpAnimations() {
        int srcX = 0;
        int srcY = 0;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationLeft.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationLeft.addFrame(src,200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationLeft.addFrame(src,200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationLeft.addFrame(src,200);
    }
}
