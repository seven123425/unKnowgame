package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.CardItem;

import java.util.ArrayList;

public class CardAdapter extends CustomizeAdapter {

    private ArrayList<CardItem> itemList = new ArrayList<CardItem>();

    public CardAdapter(Context context) {
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

    public void addItem(CardItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }
}
