package com.maxdream.unkgame.page.bar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.fragmentbase.fragment.page.TitleFragment;
import com.maxdream.unkgame.R;

public class UserBar extends TitleFragment {

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.user_bar, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
    }
}
