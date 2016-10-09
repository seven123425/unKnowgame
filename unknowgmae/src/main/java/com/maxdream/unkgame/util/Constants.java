package com.maxdream.unkgame.util;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Constants {

    public static String INTENT_TAG = "intent";

    public enum ItemDemoEnum {
        stone, map, back, team, alter, character;

        public static String getText(Activity activity, String input) {
            String[] setting = activity.getResources().getStringArray(R.array.demo_item_array);
            String type = null;
            if (input.equals(stone.toString())) {
                type = setting[0];
            } else if (input.equals(map.toString())) {
                type = setting[1];
            } else if (input.equals(back.toString())) {
                type = setting[2];
            } else if (input.equals(team.toString())) {
                type = setting[3];
            } else if (input.equals(alter.toString())) {
                type = setting[4];
            } else if (input.equals(character.toString())) {
                type = setting[5];
            }
            return type;
        }
    }
}
