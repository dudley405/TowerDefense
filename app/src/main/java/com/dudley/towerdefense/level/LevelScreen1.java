package com.dudley.towerdefense.level;

import android.graphics.Color;
import android.graphics.Path;

import com.dudley.towerdefense.Assets;
import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.util.Coordinates;
import com.dudley.towerdefense.sprite.BunnySprite;
import com.dudley.towerdefense.sprite.Sprite;
import com.dudley.towerdefense.sprite.TowerSprite;
import com.dudley.towerdefense.sprite.util.TowerLocation;
import com.dudley.towerdefense.sprite.util.TowerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Justin on 1/6/2016.
 */
public class LevelScreen1 extends LevelScreen {

    public List<BunnySprite> sprites = new ArrayList<BunnySprite>();
    public List<TowerSprite> towerSprites = new ArrayList<TowerSprite>();

    public LevelScreen1(Game game) {
        super(game);

        for (int i = 0; i < 21; i++) {

            BunnySprite sprite = new BunnySprite(game.getGraphics(), Assets.spriteSheet.getBitmap());
            sprite.setPath(getPath(), true);
            sprites.add(sprite);
        }
        // set the circles where towers can be built
        setTowerLocations();
    }

    public void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Touch to Begin",
                640, 300, paint);
    }

    @Override
    public void drawRunningUI() {
        Graphics g = game.getGraphics();
        g.clearScreen(155);
        g.drawImage(Assets.map_1_1, -300, -300);

        // draw all tower locations
        for (TowerLocation location : levelTowerLocations) {
            int x = location.getCoords().getX();
            int y = location.getCoords().getY();
            int radius = location.getCoords().getRadius();

            String towerType = location.getTowerType();

            if(towerType != null && towerType.equals(TowerType.FIRE)) {
                paint.setColor(Color.RED);
                TowerSprite sprite = new TowerSprite(game.getGraphics(), Assets.spriteSheet.getBitmap(), location.getCoords());
                towerSprites.add(sprite);
            } else {
                paint.setColor(Color.WHITE);
                g.drawCircle(x, y, radius, paint);
            }

        }

        for (BunnySprite sprite : sprites) {
            sprite.onDraw();
        }

        for (TowerSprite towerSprite : towerSprites) {
            towerSprite.onDraw();
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
