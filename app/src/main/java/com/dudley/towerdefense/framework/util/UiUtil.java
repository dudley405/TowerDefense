package com.dudley.towerdefense.framework.util;

import com.dudley.towerdefense.framework.Graphics;

/**
 * Created by Justin on 1/3/2016.
 */
public class UiUtil {

    private UiUtil() {

    }

    public static int getCenterXCoord(Graphics graphics, int width) {
        return graphics.getWidth() / 2 - (width / 2);
    }

    public static int getCenterYCoord(Graphics graphics, int height) {
        return graphics.getHeight() / 2 - (height / 2);
    }

}
