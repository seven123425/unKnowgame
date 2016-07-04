package com.maxdream.android.process;

import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.layoutstatus.PageProcess;

public abstract class ShapeProcess extends BaseProcess {

    protected PageProcess control;
    protected String titleType, bodyType, childType;

    public ShapeProcess(PageProcess control) {
        this.control = control;
        titleType = FragmentPageControl.getInstance().getTitleFragmentType();
        bodyType = FragmentPageControl.getInstance().getBodyFragmentType();
        childType = FragmentPageControl.getInstance().getChildFragmentType();
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTitleType() {
        return titleType;
    }

    public String getChildType() {
        return childType;
    }

    public PageProcess getLastControl() {
        return control;
    }
}
