package com.maxdream.unkgame.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.adapter.CustomizeAdapter;
import com.maxdream.unkgame.adapter.item.DemoItem;

import java.util.ArrayList;

public class DemoAdapter extends CustomizeAdapter {

    private ArrayList<DemoItem> itemList = new ArrayList<DemoItem>();

    public DemoAdapter(Context context) {
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

    public void addItem(DemoItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void getItemEvent(int position) {
        itemList.get(position).clickEvent();
    }

}
