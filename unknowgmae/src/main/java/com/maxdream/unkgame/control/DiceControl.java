package com.maxdream.unkgame.control;

import android.app.Activity;

import com.maxdream.unkgame.adapter.item.StoneItem;
import com.maxdream.unkgame.gmaeobj.Dark;
import com.maxdream.unkgame.gmaeobj.Fire;
import com.maxdream.unkgame.gmaeobj.Light;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.gmaeobj.Water;
import com.maxdream.unkgame.gmaeobj.Wood;

import java.util.ArrayList;
import java.util.Random;

public class DiceControl {

    private static DiceControl instance = new DiceControl();

    private DiceControl() {

    }

    public static DiceControl getInstance() {
        return instance;
    }

    private ArrayList<StoneBase> itemsList = new ArrayList<StoneBase>();

    public void droll(Activity activity) {
        itemsList.clear();
        Random ran = new Random();
        int count = ran.nextInt(6) + 1;
        addStone(activity, count);
    }

    public void drollFirst(Activity activity) {
        itemsList.clear();
        addStone(activity, 6);
    }

    private void addStone(Activity activity, int dice) {
        for (int i = 0; i < dice; i++) {
            itemsList.add(initStone(activity));
        }
    }

    private StoneBase initStone(Activity activity) {
        Random ran = new Random();
        StoneBase item = null;
        switch (ran.nextInt(5)) {
            case 0:
                item = new Water(activity);
                break;
            case 1:
                item = new Fire(activity);
                break;
            case 2:
                item = new Wood(activity);
                break;
            case 3:
                item = new Dark(activity);
                break;
            case 4:
                item = new Light(activity);
                break;
        }
        return item;
    }

    public ArrayList<StoneBase> getStoneList() {
        return itemsList;
    }
}
