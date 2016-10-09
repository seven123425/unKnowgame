package com.maxdream.unkgame.util;

import com.android.fragmentbase.util.LayoutFormat;

public class ReSize extends LayoutFormat {

    public static float ITEM_IMAGE_WIDTH = (float) (Math.round((layoutExampleSize.layoutExampleWidth()* 100) / 293)) / 100;
    public static float ITEM_IMAGE_HEIGHT = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 391)) / 100;
    public static float skillItemHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 175)) / 100;
    public static float skillItemWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 200)) / 100;
    public static float botBGHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 600)) / 100;
    public static float diceBGWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 163)) / 100;
    public static float powerLineHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 60)) / 100;
    public static float powerLineWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 805)) / 100;
    public static float cardGridHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 346)) / 100;
    public static float cardGridWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 1030)) / 100;
    public static float npcCardGridHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 326)) / 100;
    public static float npcCardGridWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 920)) / 100;
    public static float powerGridHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 105)) / 100;
    public static float powerGridWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 805)) / 100;
    public static float cardHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 345)) / 100;
    public static float cardWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 250)) / 100;
    public static float npcCardHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 290)) / 100;
    public static float npcCardWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 290)) / 100;
    public static float npcCardHPHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 20)) / 100;
    public static float stoneHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 105)) / 100;
    public static float stoneWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 105)) / 100;
    public static float diceIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 325)) / 100;
    public static float diceIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 325)) / 100;
    public static float hpHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 60)) / 100;
    public static float hpWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 600)) / 100;
    public static float rageHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 60)) / 100;
    public static float informationWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 920)) / 100;
    public static float npcItemBGHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 325)) / 100;
    public static float userTitleHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 288)) / 100;
    public static float mapIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 150)) / 100;
    public static float mapIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 150)) / 100;
    public static float mapBotMenuHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 250)) / 100;
    public static float mapBotIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 200)) / 100;
    public static float mapBotIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 200)) / 100;
    public static float mapBotIconLayoutWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 230)) / 100;
    public static float mapMoreIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 115)) / 100;
    public static float mapMoreIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 305)) / 100;
    public static float backTitleIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 100)) / 100;
    public static float backTitleIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 450)) / 100;
    public static float backChannelIconHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 189)) / 100;
    public static float backChannelIconWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 134)) / 100;
    public static float backItemHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 183)) / 100;
    public static float backItemWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 182)) / 100;
    public static float backLineHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 12)) / 100;
    public static float backLineWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 1080)) / 100;
    public static float backTypeHeight = (float) (Math.round((layoutExampleSize.layoutExampleHeight() * 100) / 88)) / 100;
    public static float backTypeWidth = (float) (Math.round((layoutExampleSize.layoutExampleWidth() * 100) / 138)) / 100;

    public static float getBitItemWidth() {
        return vWidth / ITEM_IMAGE_WIDTH;
    }

    public static float getBitItemHeight() {
        return vWidth / ITEM_IMAGE_HEIGHT;
    }
}
