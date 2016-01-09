package com.dudley.towerdefense;

import android.graphics.Rect;

import com.dudley.towerdefense.framework.Image;

import java.util.ArrayList;

/**
 * Created by Justin on 1/3/2016.
 */
public class Animation {

    private ArrayList frames;
    private int currentFrame;
    private long lastPolledTime;
    private long totalDuration;

    public Animation() {
        frames = new ArrayList();
        totalDuration = 0;

        synchronized (this) {
            lastPolledTime = 0;
            currentFrame = 0;
        }
    }

    public synchronized void addFrame(Rect rect, long duration) {
        totalDuration += duration;
        frames.add(new AnimFrame(rect, totalDuration));
    }

    public synchronized void update(long currentTime) {
        long elapsedTime = currentTime - lastPolledTime;
        if(frames.size() > 0 && currentFrame < frames.size()) {
            if (currentFrame == frames.size() - 1) {
                currentFrame = 0;
            }

            if (elapsedTime > getFrame(currentFrame).endTime) {

                lastPolledTime = currentTime;
                if (currentFrame < frames.size() - 2) {
                    currentFrame++;
                } else {
                    currentFrame = 0;
                }
            }
        }
    }

    public synchronized Rect getRect() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).rect;
        }
    }

    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    private class AnimFrame {

        Rect rect;
        long endTime;

        public AnimFrame(Rect rect, long endTime) {
            this.rect = rect;
            this.endTime = endTime;
        }
    }
}
