package com.dudley.towerdefense.framework.util;

/**
 * Created by Justin on 1/8/2016.
 */
public class Coordinates {

    private int x;
    private int y;
    private int radius;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
