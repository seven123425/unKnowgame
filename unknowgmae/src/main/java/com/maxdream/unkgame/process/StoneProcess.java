package com.maxdream.unkgame.process;

import com.android.fragmentbase.control.BaseFragmentControl;
import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.process.PageProcess;
import com.android.fragmentbase.process.ShapeProcess;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.factory.FragmentFactory;

public class StoneProcess extends ShapeProcess {

    public StoneProcess(PageProcess control, BaseFragmentFactory fragmentFactory, BaseFragmentControl fragmentControl) {
        super(control, fragmentFactory, fragmentControl);
    }

    @Override
    protected void backLastProcess() {
        ProcessControl.getInstance().setStoneType(false);
    }

    @Override
    public void lastPage() {
        super.lastPage();
    }

    @Override
    protected String[] getPageString() {
        String[] pageString = {
                FragmentFactory.BodyTypeEnum.stone.toString()
        };
        return pageString;
    }
}
