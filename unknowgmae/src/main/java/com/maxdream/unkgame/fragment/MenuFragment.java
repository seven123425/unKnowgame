package com.maxdream.unkgame.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.maxdream.unkgame.control.FragmentPageControl;
import com.maxdream.unkgame.util.Constants;

public abstract class MenuFragment extends BasePageFragment {

    private View menuView;
    private boolean isShow;
    private Animation animation;
    protected Handler handler = new Handler();

    @Override
    protected String LayoutType() {
        return Constants.FragmentTypeEnum.menu.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPageControl.getInstance().setMenuWidget(this);
        menuView = super.onCreateView(inflater, container, savedInstanceState);
        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        menuView.setVisibility(View.GONE);
        return menuView;
    }

    protected abstract View fragmentLayout(LayoutInflater inflater, ViewGroup container);

    protected abstract void setupComponents(View fragmentView);

    public boolean getStatus() {
        return isShow;
    }

    public void setStatus(boolean status) {
        isShow = status;
        if (status) {
            animation = openAnim();
            menuOpen();
        } else {
            animation = closeAnim();
            menuClose();
        }
    }

    protected abstract Animation openAnim();

    protected abstract Animation closeAnim();

    public abstract BasePageFragment nextFragment();

    protected void menuOpen() {
        menuView.setVisibility(View.VISIBLE);
        menuView.startAnimation(animation);
    }

    protected void menuClose() {
        menuView.startAnimation(animation);
        handler.postDelayed(new Runnable() {
            public void run() {
                if (!isShow) {
                    menuView.setVisibility(View.GONE);
                }
            }
        }, 300);
    }
}
