package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.util.LayoutFormat;

import static com.maxdream.unkgame.util.LayoutFormat.imageFormat;
import static com.maxdream.unkgame.util.ReSize.*;

public abstract class MapMenuItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;

    public MapMenuItem(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_map_menu, null);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            imageView.setBackgroundResource(getIconRes());
            imageFormat(mapBotIconWidth, mapBotIconHeight, parentLayoutType.RelativeLayout.toString(), imageView);
        }
        return itemView;
    }

    protected abstract int getIconRes();
}
