package com.maxdream.unkgame.gmaeobj;

import android.app.Activity;
import android.graphics.drawable.Drawable;

public abstract class StoneBase {
    private Activity activity;

    public StoneBase(Activity activity) {
        this.activity = activity;
    }

    public abstract int getStonePicRes();
}
