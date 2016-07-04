package com.maxdream.unkgame.process;

import com.maxdream.android.process.ShapeProcess;
import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.layoutstatus.PageProcess;
import com.maxdream.unkgame.util.Constants;

public class MapProcess extends ShapeProcess {

    public MapProcess(PageProcess control) {
        super(control);
        FragmentPageControl.getInstance().setBodyFragmentType(Constants.BodyTypeEnum.map.toString());
        FragmentPageControl.getInstance().getBodyWidget().changeNextFragment();
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void lastPage() {
        if (FragmentPageControl.getInstance().getBodyFragmentType().equals(Constants.BodyTypeEnum.map.toString())) {
            FragmentPageControl.getInstance().setBodyFragmentType(Constants.BodyTypeEnum.demo.toString());
            FragmentPageControl.getInstance().getBodyWidget().changeNextFragment();
            FragmentPageControl.getInstance().setStoneProcessType(false);
        }
    }
}
