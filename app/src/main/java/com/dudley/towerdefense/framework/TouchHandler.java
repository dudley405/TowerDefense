package com.dudley.towerdefense.framework;

import android.view.View;

import java.util.List;

/**
 * Created by lenovo on 12/30/2015.
 */
public interface TouchHandler extends View.OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}