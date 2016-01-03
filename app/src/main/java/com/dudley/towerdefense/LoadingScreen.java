package com.dudley.towerdefense;

import android.graphics.Color;
import android.graphics.Paint;

import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Screen;

/**
 * Created by Justin on 1/2/2016.
 */
public class LoadingScreen extends Screen {

    public LoadingScreen(Game game) {
       super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", Graphics.ImageFormat.RGB565);
        Assets.click = game.getAudio().createSound("click.ogg");
        Assets.map_1_1 = g.newImage("map_1_1.jpg", Graphics.ImageFormat.RGB565);

        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}
