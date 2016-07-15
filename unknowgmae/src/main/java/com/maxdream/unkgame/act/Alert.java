package com.maxdream.unkgame.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.maxdream.unkgame.R;
import com.maxdream.unkgame.control.FragmentControl;
import com.maxdream.unkgame.factory.FragmentFactory;
import com.maxdream.unkgame.util.Constants;

public class Alert extends Activity {

    private String fragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.white);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            fragmentTag = extras.get(Constants.INTENT_TAG).toString();
        }
        FragmentControl.getInstance().initFragmentInLayout(R.id.body, this, FragmentFactory.getInstance().getBodyWidget(fragmentTag));
    }
}
