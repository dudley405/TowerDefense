package com.dudley.towerdefense.framework.impl;

import android.graphics.Bitmap;

import com.dudley.towerdefense.framework.Image;
import com.dudley.towerdefense.framework.Graphics.ImageFormat;

/**
 * Created by lenovo on 12/30/2015.
 */
public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }

    @Override
    public Bitmap getBitmap() {
        return this.bitmap;
    }

}
