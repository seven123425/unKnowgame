package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.android.fragmentbase.util.LayoutFormat;
import com.maxdream.unkgame.R;

import static com.android.fragmentbase.util.LayoutFormat.imageFormat;
import static com.maxdream.unkgame.util.ReSize.backItemHeight;
import static com.maxdream.unkgame.util.ReSize.backItemWidth;

public class BackItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;

    public BackItem(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_back, null);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            imageFormat(backItemWidth, backItemHeight, LayoutFormat.parentLayoutType.LinearLayout.toString(), imageView);
        }
        return itemView;
    }
}
