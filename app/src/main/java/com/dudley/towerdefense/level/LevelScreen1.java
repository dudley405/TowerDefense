package com.dudley.towerdefense.level;

import android.graphics.Color;
import android.graphics.Path;

import com.dudley.towerdefense.Assets;
import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.util.Coordinates;
import com.dudley.towerdefense.sprite.enemy.BunnyEnemySprite;
import com.dudley.towerdefense.sprite.enemy.EnemySprite;
import com.dudley.towerdefense.sprite.util.TowerLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 1
 */
public class LevelScreen1 extends LevelScreen {

    int i = 0;
    long gameTime;
    long lastPolledTime;
    long lastShotTime;

    public List<EnemySprite> sprites = new ArrayList<EnemySprite>();

    public LevelScreen1(Game game) {
        super(game);
        // set the circles where towers can be built
        setTowerLocations();

        lastPolledTime = System.currentTimeMillis();
        lastShotTime = System.currentTimeMillis();

    }

    public void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Touch to Begin",
                640, 300, paint);
    }

    @Override
    public void drawRunningUI() {

        gameTime = System.currentTimeMillis();

        Graphics g = game.getGraphics();
        g.clearScreen(155);
        g.drawImage(Assets.map_1_1, -300, -300);

        // draw all tower locations
        for (TowerLocation location : levelTowerLocations) {
            int x = location.getCoords().getX();
            int y = location.getCoords().getY();
            int radius = location.getCoords().getRadius();

            // Draw towers
            if (location.getTower() != null) {
                location.getTower().onDraw();
                paint.setColor(Color.BLUE);
                paint.setAlpha(60);
                Coordinates shootingRadius = location.getTower().getShootingRadius();
                game.getGraphics().drawCircle(shootingRadius.getX(), shootingRadius.getY(), shootingRadius.getRadius(), paint);
                location.getTower().target(sprites);
            } else {
                paint.setColor(Color.WHITE);
                g.drawCircle(x, y, radius, paint);
            }

        }


        // create all the sprites for this level
        // Need to make sprites spawn in waves
        if (i < 21 && (gameTime - lastPolledTime) > 1000) {
            BunnyEnemySprite sprite = new BunnyEnemySprite(game.getGraphics(), Assets.spriteSheet.getBitmap());
            sprite.setPath(getPath(), false);
            sprites.add(sprite);
            i++;
            lastPolledTime = gameTime;
        }

        for (EnemySprite sprite : sprites) {
            if(sprite != null && !sprite.isFinished()) {
                sprite.onDraw();
            }
        }

    }

    /**
     * Builds the path along which the sprites will walk
     *
     * @return
     */
    @Override
    public Path buildPath() {
        Path path = new Path();
        path.moveTo(-100, 300);
        path.lineTo(700, 300);
        path.lineTo(700, -300);
        return path;
    }

    /**
     * Sets the locations that towers can be built
     */
    private void setTowerLocations() {
        Coordinates coord = new Coordinates(550, 200, 40);
        TowerLocation location1 = new TowerLocation(coord);
        Coordinates coord2 = new Coordinates(200, 550, 40);
        TowerLocation location2 = new TowerLocation(coord2);
        levelTowerLocations.add(location1);
        levelTowerLocations.add(location2);
    }


}
