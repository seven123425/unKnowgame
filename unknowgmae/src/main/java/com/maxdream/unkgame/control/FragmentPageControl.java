package com.maxdream.unkgame.control;

import com.maxdream.android.process.ShapeProcess;
import com.maxdream.unkgame.adapter.item.StoneItem;
import com.maxdream.unkgame.factory.ProcessFactory;
import com.maxdream.unkgame.fragment.BasePageFragment;
import com.maxdream.unkgame.fragment.BodyFragment;
import com.maxdream.unkgame.fragment.ChildFragment;
import com.maxdream.unkgame.fragment.MenuFragment;
import com.maxdream.unkgame.fragment.TitleFragment;
import com.maxdream.unkgame.gmaeobj.StoneBase;
import com.maxdream.unkgame.layoutstatus.PageProcess;
import com.maxdream.unkgame.layoutstatus.PageUpdate;
import com.maxdream.unkgame.util.Constants;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

public class FragmentPageControl {

    private static FragmentPageControl instance = new FragmentPageControl();

    private FragmentPageControl() {

    }

    public static FragmentPageControl getInstance() {
        return instance;
    }

    private BodyFragment bodyFragment;
    private TitleFragment titleFragment;
    private ChildFragment childFragment;
    private MenuFragment menuFragment;

    private String TitleFragmentType;
    private String BodyFragmentType;
    private String ChildFragmentType;
    private String ExtraFragmentType;
    private PageProcess process = new ProcessFactory().getProcess(Constants.ControlTypeEnum.main.toString());

    private boolean stoneProcessType, mapProcessType, checkStoneType;

    public void setBodyWidget(BodyFragment fragment) {
        bodyFragment = fragment;
    }

    public void setTitleWidget(TitleFragment fragment) {
        titleFragment = fragment;
    }

    public void setChildWidget(ChildFragment fragment) {
        childFragment = fragment;
    }

    public void setMenuWidget(MenuFragment fragment) {
        menuFragment = fragment;
    }


    public BodyFragment getBodyWidget() {
        return bodyFragment;
    }

    public TitleFragment getTitleWidget() {
        return titleFragment;
    }

    public ChildFragment getChildWidget() {
        return childFragment;
    }

    public MenuFragment getMenuWidget() {
        return menuFragment;
    }

    public void changeNextPage() {
        process.nextPage();
    }

    public void changeLastPage() {
        process.lastPage();
    }

    public void initFragmentInLayout(int id, FragmentActivity activity, BasePageFragment fragment) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.commitAllowingStateLoss();
    }

    public void initPageControl(String inputType) {
        process = new ProcessFactory().getProcess(inputType);
        changeNextPage();
    }

    private void initShapePageControl(String inputType) {
        process = new ProcessFactory().getShapeProcess(inputType, process);
    }

    public void setTitleFragmentType(String titleFragmentType) {
        TitleFragmentType = titleFragmentType;
    }

    public String getTitleFragmentType() {
        return TitleFragmentType;
    }

    public void setBodyFragmentType(String bodyFragmentType) {
        BodyFragmentType = bodyFragmentType;
    }

    public String getBodyFragmentType() {
        return BodyFragmentType;
    }

    public void setChildFragmentType(String childFragmentType) {
        ChildFragmentType = childFragmentType;
    }

    public String getChildFragmentType() {
        return ChildFragmentType;
    }

    public void setExtraFragmentType(String extraFragmentType) {
        ExtraFragmentType = extraFragmentType;
    }

    public String getExtraFragmentType() {
        return ExtraFragmentType;
    }

    public boolean isStoneProcessType() {
        return stoneProcessType;
    }

    public void setStoneProcessType(boolean stoneProcessType) {
        this.stoneProcessType = stoneProcessType;
        if (stoneProcessType) {
            initShapePageControl(Constants.ControlTypeEnum.stone.toString());
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
            }
        }
    }

    public boolean isMapProcessType() {
        return mapProcessType;
    }

    public void setMapProcessType(boolean mapProcessType) {
        this.mapProcessType = mapProcessType;
        if (mapProcessType) {
            initShapePageControl(Constants.ControlTypeEnum.map.toString());
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
            }
        }
    }

    public void changeStoneCheckPage(ArrayList<StoneBase> items) {
        if (menuFragment.getStatus()) {
            if(bodyFragment instanceof PageUpdate){
                ((PageUpdate) bodyFragment).update(items);
            }
            menuFragment.setStatus(false);
        } else {
            if(menuFragment instanceof PageUpdate){
                ((PageUpdate) menuFragment).update(items);
            }
            menuFragment.setStatus(true);
        }
        setCheckStoneType(menuFragment.getStatus());
    }

    public void changeStoneCheckPage() {
        if (menuFragment.getStatus()) {
            menuFragment.setStatus(false);
        } else {
            menuFragment.setStatus(true);
        }
        setCheckStoneType(menuFragment.getStatus());
    }

    public boolean isCheckStoneType() {
        return checkStoneType;
    }

    public void setCheckStoneType(boolean noticeMenuType) {
        this.checkStoneType = noticeMenuType;
    }
}
