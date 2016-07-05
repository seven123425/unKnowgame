package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.MapMenuItem;

import java.util.ArrayList;

public class MapMenuAdapter extends CustomizeAdapter {

    private ArrayList<MapMenuItem> itemList = new ArrayList<MapMenuItem>();

    public MapMenuAdapter(Context context) {
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

    public void addItem(MapMenuItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItem(ArrayList<MapMenuItem> items) {
        for (MapMenuItem menuItem : items) {
            addItem(menuItem);
        }
    }
}
