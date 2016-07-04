package com.maxdream.unkgame.process;

import com.maxdream.android.process.ShapeProcess;
import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.layoutstatus.PageProcess;
import com.maxdream.unkgame.util.Constants;

public class StoneProcess extends ShapeProcess {

    public StoneProcess(PageProcess control) {
        super(control);
        FragmentPageControl.getInstance().setBodyFragmentType(Constants.BodyTypeEnum.stone.toString());
        FragmentPageControl.getInstance().getBodyWidget().changeNextFragment();
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void lastPage() {
        if (FragmentPageControl.getInstance().getBodyFragmentType().equals(Constants.BodyTypeEnum.stone.toString())) {
            FragmentPageControl.getInstance().setBodyFragmentType(Constants.BodyTypeEnum.demo.toString());
            FragmentPageControl.getInstance().getBodyWidget().changeNextFragment();
            FragmentPageControl.getInstance().setStoneProcessType(false);
        }
    }
}
