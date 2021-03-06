package com.dudley.towerdefense.sprite.tower;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import com.dudley.towerdefense.Animation;
import com.dudley.towerdefense.Assets;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.util.Coordinates;
import com.dudley.towerdefense.framework.util.UiUtil;
import com.dudley.towerdefense.sprite.Sprite;
import com.dudley.towerdefense.sprite.projectile.IceProjectileSprite;
import com.dudley.towerdefense.sprite.SpriteMapper;
import com.dudley.towerdefense.sprite.util.TowerType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 1/6/2016.
 */
public class IceTowerSprite extends Sprite {

    List<IceProjectileSprite> projectiles = new ArrayList<IceProjectileSprite>();
    // Default animation is tower doing nothing
    Animation animationLevel1Tower = new Animation();
    // Default animation is tower doing nothing
    Animation animationLevel2Tower = new Animation();
    private Coordinates locationCoords;
    private String towerType;
    private Coordinates shootingRadius;
    protected int shotDelay;
    protected long gameTime;
    protected long lastPolledTime;

    Paint paint;

    public IceTowerSprite(Graphics graphics, Bitmap bmp, Coordinates coords) {
        super(graphics, bmp);

        this.locationCoords = coords;
        lastPolledTime = System.currentTimeMillis();
        shotDelay = 1000;
        shootingRadius = new Coordinates(locationCoords.getX(), locationCoords.getY(), 200);

         paint = new Paint();

        setUpAnimations();
    }

    public void onDraw() {
        update();

        for (IceProjectileSprite projectile : projectiles) {
            if ((projectile != null) && (!projectile.isFinished())) {
                if ((UiUtil.inBounds(projectile.getXCoord(), projectile.getYCoord(), shootingRadius.getX(), shootingRadius.getY(), shootingRadius.getRadius()) || 0 == projectile.getXCoord() && projectile.getYCoord() == 0)) {
                    projectile.onDraw();
                }
                Sprite enemy = projectile.getTarget();
                Rect enemyRect = new Rect(enemy.getXCoord(), enemy.getYCoord(), enemy.getXCoord() + enemy.getWidth(), enemy.getYCoord() + enemy.getHeight());
                Rect projectileRect = new Rect(projectile.getXCoord(), projectile.getYCoord(), projectile.getXCoord() + projectile.getWidth() , projectile.getYCoord() + projectile.getHeight());
                boolean hit = projectile.checkCollision(projectileRect, enemyRect);
                if (hit) {
                    enemy.hit(projectile.getDamage());
                    projectiles.remove(projectile);
                }
            }

        }

            long gameTime = System.currentTimeMillis();
            animationLevel1Tower.update(gameTime);
            animationLevel2Tower.update(gameTime);

            // get coordinates based on which tower build location
            // was selected. Draw tower at that location
            x = locationCoords.getX() - locationCoords.getRadius();
            y = locationCoords.getY() - locationCoords.getRadius();

            Rect dst = new Rect(x, y, x + width, y + height);

            // Draw differnt towers based on type selected by user
            if (towerType.equals(TowerType.FIRE)) {
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


    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public Coordinates getShootingRadius() {
        return this.shootingRadius;
    }

    public void shoot(Sprite target) {
        gameTime = System.currentTimeMillis();
        if (gameTime - lastPolledTime > shotDelay) {
            IceProjectileSprite iceProjectileSprite = new IceProjectileSprite(graphics, Assets.projectileSheet.getBitmap());
            Path projectilePath = new Path();
            projectilePath.moveTo(locationCoords.getX() - locationCoords.getRadius(), locationCoords.getY() - locationCoords.getRadius());
            projectilePath.lineTo(target.getXCoord() + (target.getWidth() / 2), target.getYCoord() + (target.getHeight() / 2));
            iceProjectileSprite.setPath(projectilePath, false);
            iceProjectileSprite.setTarget(target);
            projectiles.add(iceProjectileSprite);
            lastPolledTime = gameTime;
        }
    }

    public void target(List<Sprite> enemies) {
        for (Sprite enemy : enemies) {
            if (!enemy.isFinished() && UiUtil.inBounds(enemy.getXCoord() + (enemy.getWidth() / 2), enemy.getYCoord() + (enemy.getHeight() / 2), shootingRadius.getX(), shootingRadius.getY(), shootingRadius.getRadius())) {
                shoot(enemy);
            }
        }
    }

}
