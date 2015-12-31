package com.dudley.towerdefense.framework;

/**
 * Created by lenovo on 12/30/2015.
 */
public interface Sound {

    public void play();

    public void stop();

    public void pause();

    public void setLooping(boolean looping);

    public void setVolume(float volume);

    public boolean isPlaying();

    public boolean isStopped();

    public boolean isLooping();

    public void dispose();

    void seekBegin();
}
