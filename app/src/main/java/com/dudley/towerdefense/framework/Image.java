package com.dudley.towerdefense.framework;

/**
 * Created by lenovo on 12/30/2015.
 */
public interface Image {

        public int getWidth();
        public int getHeight();
        public Graphics.ImageFormat getFormat();
        public void dispose();
}
