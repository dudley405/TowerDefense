package com.dudley.towerdefense.level;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.dudley.towerdefense.Assets;
import com.dudley.towerdefense.MainMenuScreen;
import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Screen;
import com.dudley.towerdefense.framework.Input.TouchEvent;
import com.dudley.towerdefense.framework.util.UiUtil;
import com.dudley.towerdefense.sprite.tower.IceTowerSprite;
import com.dudley.towerdefense.sprite.util.TowerLocation;
import com.dudley.towerdefense.sprite.util.TowerType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 1/2/2016.
 */
public class LevelScreen extends Screen {

    List<TowerLocation> levelTowerLocations = new ArrayList<>();
    public List<IceTowerSprite> iceTowerSprites = new ArrayList<IceTowerSprite>();

    Path path;

    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

    // Variable Setup
    // You would create game objects here.

    int livesLeft = 1;
    Paint paint;

    public LevelScreen(Game game) {
        super(game);

        setPath(buildPath());

        // Initialize game objects here

        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);


    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {

       // Game staging screen..user must click to start level

        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

        // 1. All touch input is handled here:
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);


            // Check to see if a user has click a tower location
            if (event.type == TouchEvent.TOUCH_DOWN) {
                for(TowerLocation location : levelTowerLocations) {
                    if(UiUtil.inBounds(event, location.getCoords().getX(), location.getCoords().getY(), location.getCoords().getRadius())) {
                        if(location.getTower() == null) {
                            // TODO need to give user the option of which type of tower they would like to build
                            IceTowerSprite sprite = new IceTowerSprite(game.getGraphics(), Assets.spriteSheet.getBitmap(), location.getCoords());
                            sprite.setTowerType(TowerType.ICE);
                            location.setTower(sprite);
                        } else {
                            // TODO logic for upgrading towers
                        }
                    }
                }
            }
        }


        // TODO
        if (livesLeft == 0) {
            state = GameState.GameOver;
        }

    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 300 && event.x < 980 && event.y > 100
                        && event.y < 500) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        // First draw the game elements.

        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    public void drawReadyUI() {
        String test = "test";
    }

    public void drawRunningUI() {
        String test = "test";
    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 640, 300, paint);

    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }

    private void setPath(Path path){
        this.path = path;
    }

    protected Path getPath() {
        return this.path;
    }

    public Path buildPath() {
       return new Path();
    }
}

