package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.StoneCheckItem;
import com.maxdream.unkgame.gmaeobj.StoneBase;

import java.util.ArrayList;

public class StoneCheckAdapter extends CustomizeAdapter {

    private ArrayList<StoneCheckItem> itemList = new ArrayList<>();

    public StoneCheckAdapter(Context context) {
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

    public void addItem(StoneCheckItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<StoneBase> items) {
        clearItems();
        for (StoneBase item : items) {
            addItem(new StoneCheckItem(activity, item));
        }
    }

    public void clearItems() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public ArrayList<StoneBase> getItemList() {
        ArrayList<StoneBase> items = new ArrayList<StoneBase>();
        for(StoneCheckItem item : itemList){
            if(!item.selectStatus()){
                items.add(item.getStone());
            }
        }
        return items;
    }
}
