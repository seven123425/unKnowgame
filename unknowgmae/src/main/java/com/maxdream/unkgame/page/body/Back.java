package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.TitleFragment;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.BackAdapter;
import com.maxdream.unkgame.adapter.item.CardItem;

public class Back extends BodyFragment {

    private GridView gridView;
    private BackAdapter adapter;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_back, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {

        adapter = new BackAdapter(activity);

        gridView = (GridView) fragmentView.findViewById(R.id.card_back);
        gridView.setAdapter(adapter);

        for (int i = 0; i < 30; i++) {
            adapter.addItem(new CardItem(activity));
        }
    }

    @Override
    public TitleFragment getTitleFragment() {
        return null;
    }
}
