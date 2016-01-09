package com.dudley.towerdefense;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;

import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Image;
import com.dudley.towerdefense.framework.Screen;
import com.dudley.towerdefense.framework.impl.AndroidImage;
import com.dudley.towerdefense.framework.util.UiUtil;
import com.dudley.towerdefense.sprite.BunnySprite;
import com.dudley.towerdefense.sprite.FrogSprite;

/**
 * Created by Justin on 1/2/2016.
 */
public class LoadingScreen extends Screen {

    Paint paint;

    public LoadingScreen(Game game) {
       super(game);

        paint = new Paint();
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", Graphics.ImageFormat.RGB565);
        Assets.click = game.getAudio().createSound("click.ogg");

        Assets.map_1_1 = g.newImage("map_1_1.jpg", Graphics.ImageFormat.ARGB8888);

        // Load bunny assets
        Bitmap sprite = g.newImage("animalSprites.png", Graphics.ImageFormat.ARGB8888).getBitmap();
        sprite = sprite.createScaledBitmap(sprite,768,512, false);
        Assets.spriteSheet = new AndroidImage(sprite, Graphics.ImageFormat.ARGB8888);

        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawString("Loading...", UiUtil.getCenterXCoord(g, 400), UiUtil.getCenterYCoord(g, 75), paint);
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
