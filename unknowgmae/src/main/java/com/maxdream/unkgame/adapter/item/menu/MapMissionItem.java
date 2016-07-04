package com.maxdream.unkgame.adapter.item.menu;

import android.app.Activity;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.item.MapMenuItem;

public class MapMissionItem extends MapMenuItem {

    public MapMissionItem(Activity activity) {
        super(activity);
    }

    @Override
    protected int getIconRes() {
        return R.mipmap.map_icon_mission;
    }
}
