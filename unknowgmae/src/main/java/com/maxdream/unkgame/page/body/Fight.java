package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.TitleFragment;
import com.android.fragmentbase.util.LayoutFormat;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.CardAdapter;
import com.maxdream.unkgame.adapter.NPCAdapter;
import com.maxdream.unkgame.adapter.StoneAdapter;
import com.maxdream.unkgame.adapter.item.CardItem;
import com.maxdream.unkgame.adapter.item.NPCItem;
import com.maxdream.unkgame.control.DiceControl;
import com.maxdream.unkgame.control.FragmentControl;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.layoutstatus.PageUpdate;

import java.util.ArrayList;

import static com.maxdream.unkgame.util.ReSize.botBGHeight;
import static com.maxdream.unkgame.util.ReSize.cardGridHeight;
import static com.maxdream.unkgame.util.ReSize.cardGridWidth;
import static com.maxdream.unkgame.util.ReSize.diceBGWidth;
import static com.maxdream.unkgame.util.ReSize.diceIconHeight;
import static com.maxdream.unkgame.util.ReSize.diceIconWidth;
import static com.maxdream.unkgame.util.ReSize.gridviewFormat;
import static com.maxdream.unkgame.util.ReSize.hpHeight;
import static com.maxdream.unkgame.util.ReSize.hpWidth;
import static com.maxdream.unkgame.util.ReSize.imageFormat;
import static com.maxdream.unkgame.util.ReSize.informationWidth;
import static com.maxdream.unkgame.util.ReSize.npcCardGridHeight;
import static com.maxdream.unkgame.util.ReSize.npcCardGridWidth;
import static com.maxdream.unkgame.util.ReSize.powerGridHeight;
import static com.maxdream.unkgame.util.ReSize.powerGridWidth;
import static com.maxdream.unkgame.util.ReSize.powerLineHeight;
import static com.maxdream.unkgame.util.ReSize.powerLineWidth;
import static com.maxdream.unkgame.util.ReSize.rageHeight;
import static com.maxdream.unkgame.util.ReSize.relativeFormat;
import static com.maxdream.unkgame.util.ReSize.skillItemHeight;
import static com.maxdream.unkgame.util.ReSize.skillItemWidth;
import static com.maxdream.unkgame.util.ReSize.textFormat;

public class Fight extends BodyFragment implements PageUpdate{

    private GridView cardGrid, stoneGrid, npcGrid;
    private CardAdapter cardAdapter;
    private StoneAdapter stoneAdapter;
    private NPCAdapter npcAdapter;
    private RelativeLayout powerLine, skillItem, botbg, dicbg;
    private ImageView dice, hp, rage;
    private TextView information;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_fight, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
        DiceControl.getInstance().drollFirst(activity);
        powerLine = (RelativeLayout) fragmentView.findViewById(R.id.power_line);
        skillItem = (RelativeLayout) fragmentView.findViewById(R.id.skill_item);
        botbg = (RelativeLayout) fragmentView.findViewById(R.id.bot_bg);
        dicbg = (RelativeLayout) fragmentView.findViewById(R.id.dice_bg_block);
        dice = (ImageView) fragmentView.findViewById(R.id.dice);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiceControl.getInstance().droll(activity);
                FragmentControl.getInstance().openStoneCheck(activity, stoneAdapter.getItemList());
            }
        });
        hp = (ImageView) fragmentView.findViewById(R.id.hp);
        rage = (ImageView) fragmentView.findViewById(R.id.rage);
        information = (TextView) fragmentView.findViewById(R.id.information);

        npcAdapter = new NPCAdapter(activity);
        for (int i = 0; i < 3; i++) {
            npcAdapter.addItem(new NPCItem(activity));
        }
        npcGrid = (GridView) fragmentView.findViewById(R.id.card_npc);
        npcGrid.setAdapter(npcAdapter);

        stoneAdapter = new StoneAdapter(activity);
        stoneGrid = (GridView) fragmentView.findViewById(R.id.power_stone);
        stoneGrid.setAdapter(stoneAdapter);

        cardAdapter = new CardAdapter(activity);
        for (int i = 0; i < 4; i++) {
            cardAdapter.addItem(new CardItem(activity));
        }
        cardGrid = (GridView) fragmentView.findViewById(R.id.card_user);
        cardGrid.setAdapter(cardAdapter);

        relativeFormat(powerLineWidth, powerLineHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), powerLine);
        relativeFormat(skillItemWidth, skillItemHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), skillItem);
        relativeFormat(0, botBGHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), botbg);
        relativeFormat(diceBGWidth, 0, LayoutFormat.parentLayoutType.RelativeLayout.toString(), dicbg);
        gridviewFormat(cardGridWidth, cardGridHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), cardGrid);
        gridviewFormat(powerGridWidth, powerGridHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), stoneGrid);
        gridviewFormat(npcCardGridWidth, npcCardGridHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), npcGrid);
        imageFormat(diceIconWidth, diceIconHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), dice);
        imageFormat(hpWidth, hpHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), hp);
        imageFormat(hpWidth, rageHeight, LayoutFormat.parentLayoutType.RelativeLayout.toString(), rage);
        textFormat(informationWidth, 0, LayoutFormat.parentLayoutType.RelativeLayout.toString(), information);
        update(DiceControl.getInstance().getStoneList());
    }

    @Override
    public void update(ArrayList<StoneBase> items) {
        stoneAdapter.clearItems();
        stoneAdapter.addItems(items);
    }

    @Override
    public TitleFragment getTitleFragment() {
        return null;
    }
}
