package com.maxdream.unkgame.adapter.item.menu;

import android.app.Activity;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.item.MapMenuItem;

public class MapCardBookItem extends MapMenuItem {

    public MapCardBookItem(Activity activity) {
        super(activity);
    }

    @Override
    protected int getIconRes() {
        return R.mipmap.map_icon_cardbook;
    }
}
