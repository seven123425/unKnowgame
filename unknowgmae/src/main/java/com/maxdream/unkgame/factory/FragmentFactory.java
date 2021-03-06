package com.maxdream.unkgame.factory;

import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.ChildFragment;
import com.android.fragmentbase.fragment.page.MenuFragment;
import com.android.fragmentbase.fragment.page.OtherFragment;
import com.maxdream.unkgame.page.body.Alter;
import com.maxdream.unkgame.page.body.Back;
import com.maxdream.unkgame.page.body.Character;
import com.maxdream.unkgame.page.body.Check;
import com.maxdream.unkgame.page.body.Demo;
import com.maxdream.unkgame.page.body.Fight;
import com.maxdream.unkgame.page.body.Map;
import com.maxdream.unkgame.page.body.Team;

public class FragmentFactory extends BaseFragmentFactory {

    public enum BodyTypeEnum {demo, stone, map, check, back, team, character, alter}

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
        } else if (inputType.equals(BodyTypeEnum.back.toString())) {
            fragment = new Back();
        } else if (inputType.equals(BodyTypeEnum.team.toString())) {
            fragment = new Team();
        } else if (inputType.equals(BodyTypeEnum.character.toString())) {
            fragment = new Character();
        } else if (inputType.equals(BodyTypeEnum.alter.toString())) {
            fragment = new Alter();
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
