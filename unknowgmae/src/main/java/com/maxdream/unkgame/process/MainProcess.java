package com.maxdream.unkgame.process;

import com.android.fragmentbase.control.BaseFragmentControl;
import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.process.BaseProcess;
import com.maxdream.unkgame.factory.FragmentFactory;

public class MainProcess extends BaseProcess {

    public MainProcess(BaseFragmentFactory fragmentFactory, BaseFragmentControl fragmentControl) {
        super(fragmentFactory, fragmentControl);
    }

    @Override
    protected String[] getPageString() {
        String[] pageString = {
                FragmentFactory.BodyTypeEnum.demo.toString()
        };
        return pageString;
    }

    @Override
    public void lastPage() {
        super.lastPage();
    }
}
