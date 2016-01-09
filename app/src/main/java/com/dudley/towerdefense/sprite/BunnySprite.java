package com.dudley.towerdefense.sprite;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;

import java.util.Random;

/**
 * Created by Justin on 1/3/2016.
 */
public class BunnySprite extends Sprite {


    public BunnySprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);

        setUpAnimations();

    }

    /**
     * Add the appropriate images to be used in the animations
     * and create the animations.
     */
    private void setUpAnimations() {

        /** Right Animations **/
        int srcX = SpriteMapper.bunnyRightStartX * width;
        int srcY = SpriteMapper.bunnyRightStartY * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationRight.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationRight.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationRight.addFrame(src, 200);

        /** Left Animations **/
        srcX = SpriteMapper.bunnyLeftStartX * width;
        srcY = SpriteMapper.bunnyLeftStartY * height;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationLeft.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationLeft.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationLeft.addFrame(src, 200);

        /** Up Animations **/
        srcX = SpriteMapper.bunnyUpStartX * width;
        srcY = SpriteMapper.bunnyUpStartY * height;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationUp.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationUp.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationUp.addFrame(src, 200);

        /** Down Animations **/
        srcX = SpriteMapper.bunnyDownStartX * width;
        srcY = SpriteMapper.bunnyDownStartY * height;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);

        animationDown.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationDown.addFrame(src, 200);
        srcX += width;
        src = new Rect(srcX, srcY, srcX + width, srcY + height);
        animationDown.addFrame(src, 200);
    }

    public void onDraw() {
        long gameTime = System.currentTimeMillis();

        update();

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
}
