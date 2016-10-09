package com.maxdream.unkgame.adapter.item.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.maxdream.unkgame.adapter.item.DemoItem;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.util.Constants;

public class AlterDemo extends DemoItem {

    public AlterDemo(Activity activity) {
        super(activity);
    }

    @Override
    public Drawable itemIcon() {
        return null;
    }

    @Override
    public String itemTag() {
        return Constants.ItemDemoEnum.alter.toString();
    }

    @Override
    public void clickEvent() {
        ProcessControl.getInstance().setAlterType(true);
    }
}
