package com.dudley.towerdefense.framework.util;

import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Input;

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

    public static boolean inBounds(Input.TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

}
