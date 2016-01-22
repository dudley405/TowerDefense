package com.dudley.towerdefense.sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 1/21/2016.
 */
public class Group {

    long delay;
    long separationTime;
    long startTime;
    long currentTime;
    int i = 0;
    long spriteSpawnTime;
    long spriteCurrentTime;

    boolean isReady = false;

    List<Sprite> sprites;

    public Group() {
        sprites = new ArrayList<Sprite>();
        startTime = System.currentTimeMillis();
        spriteSpawnTime = System.currentTimeMillis();
        spriteCurrentTime = System.currentTimeMillis();
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    /**
     * See if every enemy in the wave is dead or finished
     * @return
     */
    public boolean isAllNull(){
        for(Sprite sprite : sprites){
            if(!sprite.isFinished())
                return false;
        }

        return true;
    }

    /**
     * Is the wave ready? (has the delay time expired)
     * @return
     */
    public boolean isReady(){
        return isReady;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Set dormant meaning all sprites are dead or done
     */
    public void setDormant() {
        currentTime = 0;
        spriteCurrentTime = 0;
        spriteSpawnTime = 0;
        startTime = 0;
        isReady = false;
        sprites = null;
    }

    /**
     * Do things like spawn enemies or wait for wave to start
     */
    public void update() {
        currentTime = System.currentTimeMillis();
        spriteCurrentTime = System.currentTimeMillis();
        if(currentTime - startTime > delay) {
            isReady = true;
            startTime = currentTime;
        }

        if(i == 0) {
            sprites.get(i).setReady();
            spriteSpawnTime = System.currentTimeMillis();
            i++;
        }

        // For each sprite in the wave, we will spawn a sprite every X (separationTime) number of milliseconds
        if (((spriteCurrentTime - spriteSpawnTime > separationTime) && i < sprites.size() && sprites.get(0).getXCoord() > 0)) {
            // equivalent of spawning a sprite
            sprites.get(i).setReady();
            spriteSpawnTime = System.currentTimeMillis();
            i++;
        }
    }

    /**
     * Set how long in milliseconds a sprite should wait to spawn after
     * a previous sprite spawns
     * @param time
     */
    public void setSeparationTime(long time) {
        this.separationTime = time;
    }

}
