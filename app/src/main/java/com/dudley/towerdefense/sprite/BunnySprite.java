package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class BunnySprite extends Sprite {

    public BunnySprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);
    }

    public void onDraw() {
        update(System.currentTimeMillis());
        int srcX = (SpriteMapper.bunnyRightStartX + currentFrame) * width;
        int srcY = SpriteMapper.bunnyRightStartY * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        graphics.drawBitmap(bmp, src, dst, paint);
    }
}
