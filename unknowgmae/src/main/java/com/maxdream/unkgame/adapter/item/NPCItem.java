package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.util.LayoutFormat;

import static com.maxdream.unkgame.util.LayoutFormat.imageFormat;
import static com.maxdream.unkgame.util.LayoutFormat.relativeFormat;
import static com.maxdream.unkgame.util.ReSize.npcCardWidth;
import static com.maxdream.unkgame.util.ReSize.npcItemBGHeight;
import static com.maxdream.unkgame.util.ReSize.npcCardHeight;
import static com.maxdream.unkgame.util.ReSize.npcCardHPHeight;

public class NPCItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;

    public NPCItem(Activity activity) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_npc, null);
            RelativeLayout itemBG = (RelativeLayout) itemView.findViewById(R.id.item_bg);
            relativeFormat(npcCardWidth, npcItemBGHeight, LayoutFormat.parentLayoutType.LinearLayout.toString(), itemBG);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.npc_pic);
            imageFormat(npcCardWidth, npcCardHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), imageView);
            ImageView npcHP = (ImageView) itemView.findViewById(R.id.npc_hp);
            imageFormat(npcCardWidth, npcCardHPHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), npcHP);
        }
        return itemView;
    }
}
