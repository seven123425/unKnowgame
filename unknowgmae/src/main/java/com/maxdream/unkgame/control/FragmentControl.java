package com.maxdream.unkgame.control;

import android.app.Activity;
import android.content.Intent;

import com.android.fragmentbase.control.BaseFragmentControl;
import com.maxdream.unkgame.act.Alert;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.layoutstatus.PageUpdate;
import com.maxdream.unkgame.util.Constants;

import java.util.ArrayList;

public class FragmentControl extends BaseFragmentControl {

    private static FragmentControl instance = new FragmentControl();

    private FragmentControl() {

    }

    public static FragmentControl getInstance() {
        return instance;
    }

    public void openStoneCheck(Activity activity, ArrayList<StoneBase> items) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_TAG, FragmentFactory.BodyTypeEnum.check.toString());
        intent.putExtra(Constants.INTENT_OBJ, items);
        intent.setClass(activity, Alert.class);
        activity.startActivity(intent);
    }

    public void closeStoneCheck(Activity activity, ArrayList<StoneBase> items) {
        activity.finish();
        if (getBodyWidget() instanceof PageUpdate) {
            ((PageUpdate) getBodyWidget()).update(items);
        }
    }
}
