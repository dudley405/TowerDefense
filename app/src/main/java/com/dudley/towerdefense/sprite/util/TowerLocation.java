package com.dudley.towerdefense.sprite.util;

import com.dudley.towerdefense.framework.util.Coordinates;

/**
 * Created by Justin on 1/8/2016.
 */
public class TowerLocation {

    Coordinates coords;
    String towerType;

    public TowerLocation(Coordinates coords) {
        this.coords = coords;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getTowerType() {
        return this.towerType;
    }

    public Coordinates getCoords() {
        return this.coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

}
