package com.dudley.towerdefense.framework.util;

import com.dudley.towerdefense.framework.Graphics;
import com.dudley.towerdefense.framework.Input;

/**
 * Created by Justin on 1/3/2016.
 */
public class UiUtil {

    private UiUtil() {

    }

    /**
     * Normally cooridnates are given as the top left corner of a rectangle
     * This method will return the center X of that rectangle
     * @param graphics
     * @param width
     * @return
     */
    public static int getCenterXCoord(Graphics graphics, int width) {
        return graphics.getWidth() / 2 - (width / 2);
    }

    /**
     * Normally cooridnates are given as the top left corner of a rectangle
     * This method will return the center Y of that rectangle
     * @param graphics
     * @param height
     * @return
     */
    public static int getCenterYCoord(Graphics graphics, int height) {
        return graphics.getHeight() / 2 - (height / 2);
    }

    /**
     * Check if touch is inside a rectangle
     * @param event
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public static boolean inBounds(Input.TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    /**
     * Check if touch is inside a circle
     * @param event
     * @param x
     * @param y
     * @param radius
     * @return
     */
    public static boolean inBounds(Input.TouchEvent event, int x, int y, int radius) {
        double dx = Math.pow(event.x - x, 2);
        double dy = Math.pow(event.y - y, 2);

        if ((dx + dy) < Math.pow(radius, 2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inBounds(int srcX, int srcY, int x, int y, int radius) {
        double dx = Math.pow(srcX - x, 2);
        double dy = Math.pow(srcY - y, 2);

        if ((dx + dy) < Math.pow(radius, 2)) {
            return true;
        } else {
            return false;
        }
    }

}
