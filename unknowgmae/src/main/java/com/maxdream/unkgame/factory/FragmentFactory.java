package com.maxdream.unkgame.factory;

import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.ChildFragment;
import com.android.fragmentbase.fragment.page.MenuFragment;
import com.android.fragmentbase.fragment.page.OtherFragment;
import com.maxdream.unkgame.page.body.Check;
import com.maxdream.unkgame.page.body.Demo;
import com.maxdream.unkgame.page.body.Fight;
import com.maxdream.unkgame.page.body.Map;

public class FragmentFactory extends BaseFragmentFactory {

    public enum BodyTypeEnum {demo, stone, map, check}

    public enum MenuTypeEnum {stonecheck}

    private static FragmentFactory instance = new FragmentFactory() {

    };

    private FragmentFactory() {

    }

    public static FragmentFactory getInstance() {
        return instance;
    }


    @Override
    protected BodyFragment initBodyFragment(String inputType) {
        BodyFragment fragment = null;
        if (inputType.equals(BodyTypeEnum.map.toString())) {
            fragment = new Map();
        } else if (inputType.equals(BodyTypeEnum.stone.toString())) {
            fragment = new Fight();
        } else if (inputType.equals(BodyTypeEnum.demo.toString())) {
            fragment = new Demo();
        } else if (inputType.equals(BodyTypeEnum.check.toString())) {
            fragment = new Check();
        }
        return fragment;
    }

    @Override
    protected ChildFragment initChildFragment(String inputType) {
        return null;
    }

    @Override
    protected MenuFragment initMenuFragment(String inputType) {
        return null;
    }

    @Override
    protected OtherFragment initOtherFragment(String inputType) {
        return null;
    }

}
