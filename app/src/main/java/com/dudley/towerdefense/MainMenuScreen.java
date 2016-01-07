package com.dudley.towerdefense;

import android.graphics.Color;
import android.graphics.Paint;

import com.dudley.towerdefense.framework.Game;
import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Input.TouchEvent;
import com.dudley.towerdefense.framework.Screen;
import com.dudley.towerdefense.framework.util.UiUtil;
import com.dudley.towerdefense.level.LevelScreen;
import com.dudley.towerdefense.level.LevelScreen1;

import java.util.List;

/**
 * Created by Justin on 1/2/2016.
 */
public class MainMenuScreen extends Screen {

    Paint paint;

    public MainMenuScreen(Game game) {
        super(game);

        paint = new Paint();
        paint.setTextSize(48);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

                int width = 400;
                int height = 75;

                int x = UiUtil.getCenterXCoord(game.getGraphics(), width);
                int y = UiUtil.getCenterYCoord(game.getGraphics(), height);

                if (UiUtil.inBounds(event, x, y, width, height)) {
                    //START GAME
                    Assets.click.play(100);
                    game.setScreen(new LevelScreen1(game));
                }
            }
        }
    }




    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, 0, 0);

        int width = 400;
        int height = 75;

        int x = game.getGraphics().getWidth() / 2 - (width / 2);
        int y = game.getGraphics().getHeight() / 2 - (height / 2);

        g.drawRect(x,y,width,height,Color.BLUE);
        g.drawString("Start",(game.getGraphics().getWidth() / 2) + 10 , (game.getGraphics().getHeight() + 10) / 2,paint);
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
        //Display "Exit Game?" Box
    }




}
