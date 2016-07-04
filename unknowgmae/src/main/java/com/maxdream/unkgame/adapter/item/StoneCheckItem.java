package com.maxdream.unkgame.adapter.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.util.LayoutFormat;

import static com.maxdream.unkgame.util.LayoutFormat.imageFormat;
import static com.maxdream.unkgame.util.ReSize.stoneHeight;
import static com.maxdream.unkgame.util.ReSize.stoneWidth;

public class StoneCheckItem {

    protected Activity activity;
    private View itemView;
    protected LayoutInflater inflater;
    private boolean isSelect = false;
    private LinearLayout bg;
    private StoneBase stone;

    public StoneCheckItem(Activity activity, StoneBase stone) {
        this.activity = activity;
        this.stone = stone;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getItemView() {
        if (null == itemView) {
            itemView = inflater.inflate(R.layout.item_stone_check, null);
            bg = (LinearLayout) itemView.findViewById(R.id.item_check_bg);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            imageView.setBackgroundResource(stone.getStonePicRes());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSelect) {
                        bg.setBackgroundResource(R.color.transparent);
                        isSelect = false;
                    } else {
                        bg.setBackgroundResource(R.color.white);
                        isSelect = true;
                    }
                }
            });
            imageFormat(stoneWidth, stoneHeight, LayoutFormat.parentLayoutType.LinearLayout.toString(), imageView);
        }
        return itemView;
    }

    public boolean selectStatus() {
        return isSelect;
    }

    public StoneBase getStone(){
        return stone;
    }
}
