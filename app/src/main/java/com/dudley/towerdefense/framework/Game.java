package com.dudley.towerdefense.framework;

/**
 * Created by lenovo on 12/30/2015.
 */
public interface Game {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getInitScreen();
}
