package com.maxdream.unkgame.adapter.item.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.maxdream.unkgame.adapter.item.DemoItem;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.util.Constants;

public class MapDemo extends DemoItem {
    public MapDemo(Activity activity) {
        super(activity);
    }

    @Override
    public Drawable itemIcon() {
        return null;
    }

    @Override
    public String itemTag() {
        return Constants.ItemDemoEnum.map.toString();
    }

    @Override
    public void clickEvent() {
        ProcessControl.getInstance().setMapType(true);
    }
}
