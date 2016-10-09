package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.TitleFragment;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.BackAdapter;
import com.maxdream.unkgame.adapter.MapMenuAdapter;
import com.maxdream.unkgame.adapter.item.BackItem;
import com.maxdream.unkgame.control.ListMenuControl;

import static com.android.fragmentbase.util.LayoutFormat.horizontalScrollViewFormat;
import static com.android.fragmentbase.util.LayoutFormat.linearFormat;
import static com.android.fragmentbase.util.LayoutFormat.parentLayoutType;
import static com.android.fragmentbase.util.LayoutFormat.relativeFormat;
import static com.android.fragmentbase.util.LayoutFormat.vWidth;
import static com.maxdream.unkgame.util.ReSize.*;

public class Back extends BodyFragment {

    private LinearLayout userTitle;
    private RelativeLayout backTitle, backLine;
    private GridView botMenu, backGrid;
    private MapMenuAdapter mapMenuAdapter;
    private BackAdapter backAdapter;
    private HorizontalScrollView horizontalScrollView;
    private Button character, material, backType1, backType2, backType3, backType4;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_back, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {

        userTitle = (LinearLayout) fragmentView.findViewById(R.id.user_title);
        horizontalScrollView = (HorizontalScrollView) fragmentView.findViewById(R.id.horizontal_view);
        backTitle = (RelativeLayout) fragmentView.findViewById(R.id.back_title);
        backLine = (RelativeLayout) fragmentView.findViewById(R.id.back_line);
        material = (Button) fragmentView.findViewById(R.id.back_material);
        character = (Button) fragmentView.findViewById(R.id.back_character);
        backType1 = (Button) fragmentView.findViewById(R.id.back_type1);
        backType2 = (Button) fragmentView.findViewById(R.id.back_type2);
        backType3 = (Button) fragmentView.findViewById(R.id.back_type3);
        backType4 = (Button) fragmentView.findViewById(R.id.back_type4);

        mapMenuAdapter = new MapMenuAdapter(activity);
        mapMenuAdapter.addItem(ListMenuControl.getInstance().getMapMenuList(activity));

        backAdapter = new BackAdapter(activity);
        for (int i = 0; i < 25; i++) {
            backAdapter.addItem(new BackItem(activity));
        }

        botMenu = (GridView) fragmentView.findViewById(R.id.grid_view);
        botMenu.setAdapter(mapMenuAdapter);

        backGrid = (GridView) fragmentView.findViewById(R.id.back_grid);
        backGrid.setAdapter(backAdapter);

        linearFormat(0, userTitleHeight, parentLayoutType.RelativeLayout.toString(), userTitle);
        relativeFormat(backTitleIconWidth, backTitleIconHeight, parentLayoutType.RelativeLayout.toString(), backTitle);
        relativeFormat(backLineWidth, backLineHeight, parentLayoutType.RelativeLayout.toString(), backLine);
        buttonFormat(backChannelIconWidth, backChannelIconHeight, parentLayoutType.RelativeLayout.toString(), character, material);
        buttonFormat(backTypeWidth, backTypeHeight, parentLayoutType.RelativeLayout.toString(), backType1, backType2, backType3, backType4);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (int) (vWidth / mapBotIconLayoutWidth) * mapMenuAdapter.getCount(), LinearLayout.LayoutParams.FILL_PARENT);
        botMenu.setLayoutParams(params);
        botMenu.setColumnWidth((int) (vWidth / mapBotIconLayoutWidth));
        botMenu.setStretchMode(GridView.NO_STRETCH);
        botMenu.setNumColumns(mapMenuAdapter.getCount());
        horizontalScrollViewFormat(0, mapBotMenuHeight, parentLayoutType.RelativeLayout.toString(), horizontalScrollView
        );
    }

    @Override
    public TitleFragment getTitleFragment() {
        return null;
    }
}
