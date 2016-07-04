package com.maxdream.unkgame.fragment;

import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.util.Constants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class TitleFragment extends BasePageFragment {

    @Override
    protected String LayoutType() {
        return Constants.FragmentTypeEnum.title.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPageControl.getInstance().setTitleWidget(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract View fragmentLayout(LayoutInflater inflater, ViewGroup container);

    protected abstract void setupComponents(View fragmentView);

    public BasePageFragment nextFragment() {
        return new FragmentFactory().getTitleWidget(FragmentPageControl.getInstance().getTitleFragmentType());
    }
}
