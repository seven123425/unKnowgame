package com.maxdream.unkgame.util;

import android.app.Activity;

import com.maxdream.unkgame.R;

public class Constants {
    public enum FragmentTypeEnum {title, body, child, menu, other, extra}

    public enum TitleTypeEnum {userbar}

    public enum BodyTypeEnum {demo, stone, map}

    public enum MenuTypeEnum {stonecheck}

    public enum ControlTypeEnum {main, stone, map}

    public static int CHECK = 1;

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
