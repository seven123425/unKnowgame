package com.maxdream.unkgame.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.control.FragmentControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.layoutstatus.PageUpdate;
import com.maxdream.unkgame.util.Constants;

import java.util.ArrayList;

public class Alert extends Activity {

    private BodyFragment fragment;
    private String fragmentTag;
    private ArrayList<StoneBase> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.white);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            fragmentTag = extras.get(Constants.INTENT_TAG).toString();
            items = (ArrayList<StoneBase>) extras.get(Constants.INTENT_OBJ);
        }
        fragment = FragmentFactory.getInstance().getBodyWidget(fragmentTag);
        if (fragment instanceof PageUpdate){
            ((PageUpdate) fragment).update(items);
        }
        FragmentControl.getInstance().initFragmentInLayout(R.id.body, this, fragment);
    }
}
