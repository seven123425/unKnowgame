package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.android.fragmentbase.util.LayoutFormat;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.gmaeobj.StoneBase;

import static com.android.fragmentbase.util.LayoutFormat.imageFormat;
import static com.maxdream.unkgame.util.ReSize.stoneHeight;
import static com.maxdream.unkgame.util.ReSize.stoneWidth;

public class StoneItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;
    private StoneBase stone;

    public StoneItem(Activity activity, StoneBase stone) {
        this.activity = activity;
        this.stone = stone;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_stone, null);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            imageView.setBackgroundResource(stone.getStonePicRes());
            imageFormat(stoneWidth, stoneHeight, LayoutFormat.parentLayoutType.LinearLayout.toString(), imageView);
        }
        return itemView;
    }

    public StoneBase getStone(){
        return stone;
    }
}
