package com.maxdream.unkgame.adapter;

import com.maxdream.android.adapter.CustomizeAdapter;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.item.DemoItem;
import com.maxdream.unkgame.adapter.item.StoneItem;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.util.LayoutFormat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class StoneAdapter extends CustomizeAdapter {

    private ArrayList<StoneItem> itemList = new ArrayList<StoneItem>();

    public StoneAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return itemList.get(position).getItemView();
    }

    public void addItem(StoneBase item) {
        itemList.add(new StoneItem(activity, item));
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<StoneBase> items) {
        clearItems();
        for (StoneBase item : items) {
            addItem(item);
        }
    }

    public void clearItems() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public ArrayList<StoneBase> getItemList() {
        ArrayList<StoneBase> lists = new ArrayList<StoneBase>();
        for (StoneItem stoneBase : itemList) {
            lists.add(stoneBase.getStone());
        }
        return lists;
    }
}
