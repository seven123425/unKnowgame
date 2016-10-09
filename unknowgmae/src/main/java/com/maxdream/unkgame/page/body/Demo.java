package com.maxdream.unkgame.page.body;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.fragmentbase.fragment.page.BodyFragment;
import com.android.fragmentbase.fragment.page.TitleFragment;
import com.maxdream.unkgame.R;
import com.maxdream.unkgame.adapter.DemoAdapter;
import com.maxdream.unkgame.adapter.item.demo.AlterDemo;
import com.maxdream.unkgame.adapter.item.demo.BackDemo;
import com.maxdream.unkgame.adapter.item.demo.CharacterDemo;
import com.maxdream.unkgame.adapter.item.demo.MapDemo;
import com.maxdream.unkgame.adapter.item.demo.StoneDemo;
import com.maxdream.unkgame.adapter.item.demo.TeamDemo;

public class Demo extends BodyFragment {

    private ListView listView;
    private DemoAdapter adapter;

    @Override
    protected View fragmentLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.body_demo, container, false);
    }

    @Override
    protected void setupComponents(View fragmentView) {
        adapter = new DemoAdapter(activity);
        adapter.addItem(new StoneDemo(activity));
        adapter.addItem(new MapDemo(activity));
        adapter.addItem(new BackDemo(activity));
        adapter.addItem(new TeamDemo(activity));
        adapter.addItem(new AlterDemo(activity));
        adapter.addItem(new CharacterDemo(activity));

        listView = (ListView) fragmentView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.getItemEvent(position);
            }
        });
    }

    @Override
    public TitleFragment getTitleFragment() {
        return null;
    }
}
