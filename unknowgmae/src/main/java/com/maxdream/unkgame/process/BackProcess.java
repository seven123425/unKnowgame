package com.maxdream.unkgame.process;

import com.android.fragmentbase.control.BaseFragmentControl;
import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.process.PageProcess;
import com.android.fragmentbase.process.ShapeProcess;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.factory.FragmentFactory;

public class BackProcess extends ShapeProcess {

    public BackProcess(PageProcess control, BaseFragmentFactory fragmentFactory, BaseFragmentControl fragmentControl) {
        super(control, fragmentFactory, fragmentControl);
    }

    @Override
    protected void backLastProcess() {
        ProcessControl.getInstance().setBackType(false);
    }

    @Override
    protected String[] getPageString() {
        String[] pageString = {
                FragmentFactory.BodyTypeEnum.back.toString()
        };
        return pageString;
    }
}
