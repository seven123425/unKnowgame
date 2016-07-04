package com.maxdream.unkgame.factory;

import com.maxdream.unkgame.fragment.BodyFragment;
import com.maxdream.unkgame.fragment.ChildFragment;
import com.maxdream.unkgame.fragment.MenuFragment;
import com.maxdream.unkgame.fragment.TitleFragment;
import com.maxdream.unkgame.page.bar.UserBar;
import com.maxdream.unkgame.page.body.Demo;
import com.maxdream.unkgame.page.body.Map;
import com.maxdream.unkgame.page.body.Fight;
import com.maxdream.unkgame.page.extra.StoneCheck;
import com.maxdream.unkgame.util.Constants;

public class FragmentFactory {

    public TitleFragment getTitleWidget(String inputType) {
        TitleFragment fragment = null;
        if (inputType.equals(Constants.TitleTypeEnum.userbar.toString())) {
            fragment = new UserBar();
        }
        return fragment;
    }

    public BodyFragment getBodyWidget(String inputType) {
        BodyFragment fragment = null;
        if (inputType.equals(Constants.BodyTypeEnum.map.toString())) {
            fragment = new Map();
        } else if (inputType.equals(Constants.BodyTypeEnum.stone.toString())) {
            fragment = new Fight();
        } else if (inputType.equals(Constants.BodyTypeEnum.demo.toString())) {
            fragment = new Demo();
        }
        return fragment;
    }

    public ChildFragment getChildWidget(String inputType) {
        ChildFragment fragment = null;

        return fragment;
    }

    public MenuFragment getMenuWidget(String inputType) {
        MenuFragment fragment = null;
        if (inputType.equals(Constants.MenuTypeEnum.stonecheck.toString())) {
            fragment = new StoneCheck();
        }
        return fragment;
    }

}
