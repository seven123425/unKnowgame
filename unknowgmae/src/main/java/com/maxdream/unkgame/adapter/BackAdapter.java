package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.CardItem;

import java.util.ArrayList;

public class BackAdapter extends CustomizeAdapter{

    private ArrayList<CardItem> itemList = new ArrayList<>();

    public BackAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return itemList.get(position).getItemView();
    }

    public void addItem(CardItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }
}
