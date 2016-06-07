package com.example.b_corporation.ptanugerahgenerasibersama.Model;

/**
 * Created by B-Corporation on 5/30/2016.
 */

import android.content.Context;
import android.graphics.Bitmap;

public class ImageItem {
    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }


}