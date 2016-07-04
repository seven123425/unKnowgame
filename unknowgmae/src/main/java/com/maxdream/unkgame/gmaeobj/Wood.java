package com.maxdream.unkgame.gmaeobj;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Wood extends StoneBase {

    public Wood(Activity activity) {
        super(activity);
    }

    @Override
    public int getStonePicRes() {
        return  R.mipmap.stone_wood;
    }
}
