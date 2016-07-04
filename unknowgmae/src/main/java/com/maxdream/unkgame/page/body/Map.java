package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.MapMenuAdapter;
import com.maxdream.unkgame.control.ListMenuControl;
import com.maxdream.unkgame.fragment.BodyFragment;

import static com.maxdream.unkgame.util.LayoutFormat.linearFormat;
import static com.maxdream.unkgame.util.ReSize.*;

public class Map extends BodyFragment {

    private LinearLayout userTitle;
    private RelativeLayout mapMore;
    private Button setting, message;
    private GridView botMenu;
    private MapMenuAdapter adapter;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_map, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
        userTitle = (LinearLayout) fragmentView.findViewById(R.id.user_title);
        setting = (Button) fragmentView.findViewById(R.id.setting);
        message = (Button) fragmentView.findViewById(R.id.message);
        horizontalScrollView = (HorizontalScrollView) fragmentView.findViewById(R.id.horizontal_view);
        mapMore = (RelativeLayout) fragmentView.findViewById(R.id.map_swipe);

        adapter = new MapMenuAdapter(activity);
        adapter.addItem(ListMenuControl.getInstance().getMapMenuList(activity));

        botMenu = (GridView) fragmentView.findViewById(R.id.grid_view);
        botMenu.setAdapter(adapter);

        linearFormat(0, userTitleHeight, parentLayoutType.RelativeLayout.toString(), userTitle);
        buttonFormat(mapIconWidth, mapIconHeight, parentLayoutType.RelativeLayout.toString(), setting, message);
        relativeFormat(mapMoreIconWidth, mapMoreIconHeight, parentLayoutType.RelativeLayout.toString(), mapMore);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (int) (vWidth / mapBotIconLayoutWidth) * adapter.getCount(), LinearLayout.LayoutParams.FILL_PARENT);
        botMenu.setLayoutParams(params);
        botMenu.setColumnWidth((int) (vWidth / mapBotIconLayoutWidth));
        botMenu.setStretchMode(GridView.NO_STRETCH);
        botMenu.setNumColumns(adapter.getCount());
        horizontalScrollViewFormat(0, mapBotMenuHeight, parentLayoutType.RelativeLayout.toString(), horizontalScrollView
        );
    }
}
