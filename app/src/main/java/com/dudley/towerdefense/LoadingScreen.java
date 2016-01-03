package com.dudley.towerdefense;

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
        Assets.click = game.getAudio().createSound("explode.ogg");

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
