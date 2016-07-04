package com.maxdream.unkgame.page.bar;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.fragment.BasePageFragment;
import com.maxdream.unkgame.fragment.TitleFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserBar extends TitleFragment {

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.user_bar, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
    }

    @Override
    public BasePageFragment nextFragment() {
        return new FragmentFactory().getTitleWidget(FragmentPageControl.getInstance().getTitleFragmentType());
    }
}
