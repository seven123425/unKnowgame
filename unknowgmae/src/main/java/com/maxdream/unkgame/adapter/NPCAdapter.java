package com.maxdream.unkgame.adapter;

import com.maxdream.android.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.NPCItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NPCAdapter extends CustomizeAdapter {

    private ArrayList<NPCItem> itemList = new ArrayList<NPCItem>();

    public NPCAdapter(Context context) {
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

    public void addItem(NPCItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }
}
