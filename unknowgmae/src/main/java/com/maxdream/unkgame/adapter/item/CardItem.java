package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.android.fragmentbase.util.LayoutFormat;
import com.maxdream.unkgame.R;

import static com.maxdream.unkgame.util.ReSize.cardHeight;
import static com.maxdream.unkgame.util.ReSize.cardWidth;
import static com.maxdream.unkgame.util.ReSize.imageFormat;

public class CardItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;

    public CardItem(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_card, null);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            imageFormat(cardWidth, cardHeight, LayoutFormat.parentLayoutType.LinearLayout.toString(), imageView);
        }
        return itemView;
    }
}
