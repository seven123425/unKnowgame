package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.TitleFragment;
import com.maxdream.unkgame.R;

public class Character extends BodyFragment {

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_character, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {

    }

    @Override
    public TitleFragment getTitleFragment() {
        return null;
    }
}
