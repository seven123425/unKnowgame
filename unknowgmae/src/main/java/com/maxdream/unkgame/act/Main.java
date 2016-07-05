package com.maxdream.unkgame.act;

import android.os.Bundle;

import com.android.fragmentbase.BaseFragmentActivity;
import com.android.fragmentbase.control.BaseFragmentControl;
import com.android.fragmentbase.control.BaseProcessControl;
import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.util.LayoutExampleSize;
import com.maxdream.unkgame.control.FragmentControl;
import com.maxdream.unkgame.control.ProcessControl;
import com.maxdream.unkgame.factory.FragmentFactory;

import static com.android.fragmentbase.util.LayoutFormat.findDeviceSizeUseHeight;

public class Main extends BaseFragmentActivity implements LayoutExampleSize {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findDeviceSizeUseHeight(this, this, false);
    }

    @Override
    protected boolean beckEvent() {
        return false;
    }

    @Override
    protected BodyFragment bodyFragment() {
        return FragmentFactory.getInstance().getBodyWidget(FragmentFactory.BodyTypeEnum.demo.toString());
    }

    @Override
    protected BaseProcessControl getProcessDefaultControl() {
        return ProcessControl.getInstance();
    }

    @Override
    protected BaseFragmentControl getFragmentDefaultControl() {
        return FragmentControl.getInstance();
    }

    @Override
    public int layoutExampleWidth() {
        return 1080;
    }

    @Override
    public int layoutExampleHeight() {
        return 1920;
    }
}
