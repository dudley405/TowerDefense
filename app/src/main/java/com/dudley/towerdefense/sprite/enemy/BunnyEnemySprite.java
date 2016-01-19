package com.dudley.towerdefense.sprite.enemy;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.sprite.Sprite;
import com.dudley.towerdefense.sprite.SpriteMapper;

/**
 * Created by Justin on 1/3/2016.
 */
public class BunnyEnemySprite extends Sprite {

    boolean isMovingRight;
    boolean isMovingLeft;
    boolean isMovingDown;
    boolean isMovingUp;

    public int i = 0;

    Animation animationLeft = new Animation();
    Animation animationRight = new Animation();
    Animation animationUp = new Animation();
    Animation animationDown = new Animation();

    Paint paint;


    public BunnyEnemySprite(Graphics graphics, Bitmap bmp) {
        super(graphics, bmp);

        setUpAnimations();

        setSpeed(1);
        health = 100;

        paint = new Paint();

    }

    public void update() {
        getPathPoints();

        // Set animation based on direction of movement
        if (x < lastXPoint) {
            moveLeft();
        } else if (x > lastXPoint) {
            moveRight();
        } else if (y < lastYPoint) {
            moveUp();
        } else if (y > lastYPoint) {
            moveDown();
        }
    }


    @Override
    public void onDraw() {
        long gameTime = System.currentTimeMillis();

        update();

        animationLeft.update(gameTime);
        animationRight.update(gameTime);
        animationUp.update(gameTime);
        animationDown.update(gameTime);

        paint.setAlpha(30);
        paint.setColor(Color.RED);

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

    public void moveRight() {
        isMovingRight = true;
        isMovingLeft = false;
        isMovingUp = false;
        isMovingDown = false;
    }


    public void moveLeft() {
        isMovingLeft = true;
        isMovingRight = false;
        isMovingUp = false;
        isMovingDown = false;
    }

    public void moveUp() {
        isMovingUp = true;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingDown = false;
    }

    public void moveDown() {
        isMovingDown = true;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingUp = false;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished() {
        this.isFinished = true;
    }
}
