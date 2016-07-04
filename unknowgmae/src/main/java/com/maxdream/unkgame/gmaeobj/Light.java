package com.maxdream.unkgame.gmaeobj;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Light extends StoneBase{

    public Light(Activity activity) {
        super(activity);
    }

    @Override
    public int getStonePicRes() {
        return R.mipmap.stone_light;
    }
}
