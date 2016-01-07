package com.dudley.towerdefense.level;

import android.graphics.Path;

import com.dudley.towerdefense.Assets;
import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.sprite.TowerSprite;

/**
 * Created by Justin on 1/6/2016.
 */
public class LevelScreen1 extends LevelScreen {

    public LevelScreen1(Game game) {
        super(game);

        Assets.bunnySprite.setPath(getPath());
    }

    public void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Touch to Begin",
                640, 300, paint);
    }

    public void drawRunningUI() {
        Graphics g = game.getGraphics();
        g.clearScreen(155);
        g.drawImage(Assets.map_1_1, -300, -300);
        g.drawCircle(550,200,40, paint);
        Assets.bunnySprite.onDraw();
    }

    public Path buildPath() {
        Path path = new Path();
        path.moveTo(-100, 300);
        path.lineTo(700, 300);
        path.lineTo(700, -100);
        return path;
    }

    public int getTowerLocations() {
        return 1;
    }

}
