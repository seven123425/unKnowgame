package com.maxdream.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class CustomizeAdapter extends BaseAdapter{

    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;

    public CustomizeAdapter(Context context){
        this.context = context;
        this.activity = (Activity)context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
