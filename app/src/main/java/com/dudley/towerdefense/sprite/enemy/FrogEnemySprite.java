package com.dudley.towerdefense.sprite.enemy;

import android.graphics.Bitmap;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class FrogEnemySprite extends EnemySprite {

    public FrogEnemySprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);
    }

    public void onDraw() {
        update();
    }
}
