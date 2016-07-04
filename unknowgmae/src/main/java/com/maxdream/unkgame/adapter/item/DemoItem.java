package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.util.Constants;

public abstract class DemoItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;

    public DemoItem(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_demo, null);
            TextView textView = (TextView) itemView.findViewById(R.id.text);
            textView.setText(itemText());
        }
        return itemView;
    }

    public String itemText() {
        return Constants.ItemDemoEnum.getText(activity, itemTag());
    }

    public abstract Drawable itemIcon();

    public abstract String itemTag();

    public abstract void clickEvent();
}
