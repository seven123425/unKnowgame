package com.maxdream.unkgame.gmaeobj;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Dark extends StoneBase{

    public Dark(Activity activity) {
        super(activity);
    }

    @Override
    public int getStonePicRes() {
        return R.mipmap.stone_dark;
    }
}
