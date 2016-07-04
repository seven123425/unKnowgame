package com.maxdream.unkgame.fragment;

import com.maxdream.unkgame.util.Constants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class OtherFragment extends BasePageFragment {

    @Override
    protected String LayoutType() {
        return Constants.FragmentTypeEnum.other.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract View fragmentLayout(LayoutInflater inflater, ViewGroup container);

    protected abstract void setupComponents(View fragmentView);

    public abstract BasePageFragment nextFragment();
}
