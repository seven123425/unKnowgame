package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.BackItem;

import java.util.ArrayList;

public class BackAdapter extends CustomizeAdapter{

    private ArrayList<BackItem> itemList = new ArrayList<>();

    public BackAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return itemList.get(position).getItemView();
    }

    public void addItem(BackItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }
}
