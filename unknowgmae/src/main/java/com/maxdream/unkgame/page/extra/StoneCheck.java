package com.maxdream.unkgame.page.extra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.StoneCheckAdapter;
import com.maxdream.unkgame.control.DiceControl;
import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.fragment.BasePageFragment;
import com.maxdream.unkgame.fragment.MenuFragment;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.layoutstatus.PageUpdate;

import java.util.ArrayList;

public class StoneCheck extends MenuFragment implements PageUpdate {

    private GridView gridView;
    private Button confirm;
    private RelativeLayout background;
    private StoneCheckAdapter adapter;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.menu_check_stone, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
        background = (RelativeLayout) fragmentView.findViewById(R.id.check_bg);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        confirm = (Button) fragmentView.findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getItemList().size() <= 6) {
                    FragmentPageControl.getInstance().changeStoneCheckPage(adapter.getItemList());
                }
            }
        });

        adapter = new StoneCheckAdapter(activity);

        gridView = (GridView) fragmentView.findViewById(R.id.stone_grid);
        gridView.setAdapter(adapter);
    }

    @Override
    protected Animation openAnim() {
        return AnimationUtils.loadAnimation(activity, R.anim.alpha_enter);
    }

    @Override
    protected Animation closeAnim() {
        return AnimationUtils.loadAnimation(activity, R.anim.alpha_exit);
    }

    @Override
    public BasePageFragment nextFragment() {
        return null;
    }

    @Override
    public void update(ArrayList<StoneBase> items) {
        adapter.clearItems();
        ArrayList<StoneBase> itemsList = new ArrayList<StoneBase>();
        itemsList.addAll(items);
        itemsList.addAll(DiceControl.getInstance().getStoneList());
        adapter.addItems(itemsList);
    }
}
