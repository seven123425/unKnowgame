package com.maxdream.unkgame.act;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.util.Constants;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import static com.maxdream.unkgame.util.LayoutFormat.findDeviceSizeUseHeight;
import static com.maxdream.unkgame.util.ViewUtils.exitApp;

public class Main extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findDeviceSizeUseHeight(this, false);
        initTitleFragment();
        initBodyFragment();
        initMenuFragment();
    }

    private void initTitleFragment() {
        FragmentPageControl.getInstance().setTitleFragmentType(Constants.TitleTypeEnum.userbar.toString());
        FragmentPageControl.getInstance().initFragmentInLayout(R.id.title, this, new FragmentFactory().getTitleWidget(Constants.TitleTypeEnum.userbar.toString()));
    }

    private void initBodyFragment() {
        FragmentPageControl.getInstance().setBodyFragmentType(Constants.BodyTypeEnum.demo.toString());
        FragmentPageControl.getInstance().initFragmentInLayout(R.id.body, this, new FragmentFactory().getBodyWidget(Constants.BodyTypeEnum.demo.toString()));
    }

    private void initMenuFragment() {
        FragmentPageControl.getInstance().initFragmentInLayout(R.id.check, this, new FragmentFactory().getMenuWidget(Constants.MenuTypeEnum.stonecheck.toString()));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (FragmentPageControl.getInstance().getBodyFragmentType().equals(Constants.BodyTypeEnum.demo.toString())
                    && FragmentPageControl.getInstance().getTitleFragmentType().equals(Constants.TitleTypeEnum.userbar.toString())) {
                exitApp(this);
            } else {
                if(FragmentPageControl.getInstance().getMenuWidget().getStatus()){
                    FragmentPageControl.getInstance().changeStoneCheckPage();
                }else {
                    FragmentPageControl.getInstance().changeLastPage();
                }
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
