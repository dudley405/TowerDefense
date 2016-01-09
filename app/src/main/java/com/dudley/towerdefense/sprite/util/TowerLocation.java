package com.dudley.towerdefense.sprite.util;

import com.dudley.towerdefense.framework.util.Coordinates;
import com.dudley.towerdefense.sprite.TowerSprite;

/**
 * Needed to keep track of the tower locations and what type of towers
 * exist at those locations
 */
public class TowerLocation {

    private Coordinates coords;
    private TowerSprite tower;

    public TowerLocation(Coordinates coords) {
        this.coords = coords;
    }

    public Coordinates getCoords() {
        return this.coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    public TowerSprite getTower() {
        return tower;
    }

    public void setTower(TowerSprite tower) {
        this.tower = tower;
    }
}
