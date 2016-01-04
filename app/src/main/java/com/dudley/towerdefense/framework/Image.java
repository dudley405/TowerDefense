package com.dudley.towerdefense.framework;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 12/30/2015.
 */
public interface Image {

        public int getWidth();
        public int getHeight();
        public Graphics.ImageFormat getFormat();
        public void dispose();
        public Bitmap getBitmap();
}
