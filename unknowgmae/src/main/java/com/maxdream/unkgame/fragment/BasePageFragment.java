package com.maxdream.unkgame.fragment;

import com.maxdream.android.fragment.WidgetFragmentCache;
import com.maxdream.unkgame.R;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import static com.maxdream.unkgame.util.ReSize.getBitItemHeight;
import static com.maxdream.unkgame.util.ReSize.getBitItemWidth;

public abstract class BasePageFragment extends WidgetFragmentCache {

    private View fragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            @SuppressWarnings("static-access")
            InputMethodManager inputManger = (InputMethodManager) activity
                    .getSystemService(activity.INPUT_METHOD_SERVICE);
            inputManger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        fragmentView = fragmentLayout(inflater, container);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupComponents(fragmentView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract View fragmentLayout(LayoutInflater inflater, ViewGroup container);

    protected abstract void setupComponents(View fragmentView);

    public abstract BasePageFragment nextFragment();

    public void changeNextFragment() {
        changePage(nextFragment());
    }

    private void changePage(BasePageFragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.alpha_enter, R.anim.alpha_exit);
        transaction.replace(this.getId(), fragment);
        transaction.commit();
        this.onDestroy();
    }

    protected abstract String LayoutType();

    public String fragmentLayoutType() {
        return LayoutType();
    }

    @Override
    protected int itemWidth() {
        return (int) getBitItemWidth();
    }

    @Override
    protected int itemHeight() {
        return (int) getBitItemHeight();
    }

    @Override
    protected String cacheFileName() {
        return null;
    }

    public String getPageTag() {
        return this.toString();
    }
}
