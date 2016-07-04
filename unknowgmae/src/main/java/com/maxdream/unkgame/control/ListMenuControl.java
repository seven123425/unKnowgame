package com.maxdream.unkgame.control;

import android.app.Activity;

import com.maxdream.unkgame.adapter.item.MapMenuItem;
import com.maxdream.unkgame.adapter.item.menu.MapAltarItem;
import com.maxdream.unkgame.adapter.item.menu.MapBackItem;
import com.maxdream.unkgame.adapter.item.menu.MapCardBookItem;
import com.maxdream.unkgame.adapter.item.menu.MapMissionItem;
import com.maxdream.unkgame.adapter.item.menu.MapRoleItem;
import com.maxdream.unkgame.adapter.item.menu.MapStoreItem;

import java.util.ArrayList;

public class ListMenuControl {

    private static ListMenuControl instance = new ListMenuControl();

    private ListMenuControl() {

    }

    public static ListMenuControl getInstance() {
        return instance;
    }

    public ArrayList<MapMenuItem> getMapMenuList(Activity activity) {
        ArrayList<MapMenuItem> list = new ArrayList<MapMenuItem>();
        list.add(new MapRoleItem(activity));
        list.add(new MapBackItem(activity));
        list.add(new MapMissionItem(activity));
        list.add(new MapAltarItem(activity));
        list.add(new MapStoreItem(activity));
        list.add(new MapCardBookItem(activity));
        return list;
    }
}
