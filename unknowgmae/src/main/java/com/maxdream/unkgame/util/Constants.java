package com.maxdream.unkgame.util;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Constants {

    public static String INTENT_TAG = "intent";

    public static String INTENT_OBJ = "obj";

    public enum ItemDemoEnum {
        stone, map;

        public static String getText(Activity activity, String input) {
            String[] setting = activity.getResources().getStringArray(R.array.demo_item_array);
            String type = null;
            if (input.equals(stone.toString())) {
                type = setting[0];
            } else if (input.equals(map.toString())) {
                type = setting[1];
            }
            return type;
        }
    }
}
