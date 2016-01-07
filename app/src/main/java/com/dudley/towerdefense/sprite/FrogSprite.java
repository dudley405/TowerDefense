package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class FrogSprite extends Sprite {

    public FrogSprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);
    }

    public void onDraw() {
        update();
    }
}
