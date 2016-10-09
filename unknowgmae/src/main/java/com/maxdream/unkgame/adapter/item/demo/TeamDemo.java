package com.maxdream.unkgame.adapter.item.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.maxdream.unkgame.adapter.item.DemoItem;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.util.Constants;

public class TeamDemo extends DemoItem {

    public TeamDemo(Activity activity) {
        super(activity);
    }

    @Override
    public Drawable itemIcon() {
        return null;
    }

    @Override
    public String itemTag() {
        return Constants.ItemDemoEnum.team.toString();
    }

    @Override
    public void clickEvent() {
        ProcessControl.getInstance().setTeamType(true);
    }
}
