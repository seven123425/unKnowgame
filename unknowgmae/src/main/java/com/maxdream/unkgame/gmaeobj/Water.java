package com.maxdream.unkgame.gmaeobj;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Water extends StoneBase{

    public Water(Activity activity) {
        super(activity);
    }

    @Override
    public int getStonePicRes() {
        return R.mipmap.stone_water;
    }
}
