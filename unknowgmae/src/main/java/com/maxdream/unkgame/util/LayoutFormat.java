package com.maxdream.unkgame.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class LayoutFormat {

    public enum parentLayoutType {LinearLayout, RelativeLayout}

    public enum paddingType {Top, Bot, Left, Right}

    private enum deviceSizeUseType {Width, Height}

    public static int vWidth;
    public static int vHeight;
    public static double screenInches;
    public static int exampleWidth = 1080;
    public static int exampleHeight = 1920;
    public static int defaultScreenSize = 7;
    private static float ratio = (float) (Math.round((exampleHeight * 100) / exampleWidth)) / 100;

    private static int getActionBarHeight(Context context) {
        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }

    public static void findDeviceSizeUseWidth(Context context, boolean actionBar) {
        findDeviceSize(context, deviceSizeUseType.Width.toString(), actionBar);
    }

    public static void findDeviceSizeUseHeight(Context context, boolean actionBar) {
        findDeviceSize(context, deviceSizeUseType.Height.toString(), actionBar);
    }

    private static void findDeviceSize(Context context, String deviceType, boolean actionBar) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        screenInches = Math.sqrt(Math.pow(width / dm.xdpi, 2)
                + Math.pow(height / dm.ydpi, 2));
        int useHeight;
        if (actionBar) {
            useHeight = height - getActionBarHeight(context);
        } else {
            useHeight = height;
        }

        if (deviceType.equals(deviceSizeUseType.Height.toString())) {
            vWidth = (int) (useHeight / ratio);
            vHeight = useHeight;
        } else if (deviceType.equals(deviceSizeUseType.Width.toString())) {
            vWidth = width;
            vHeight = (int) (width * ratio);
        }
    }

    public static void textviewTextSizeFormat(float defaultTextSize, TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) ((defaultTextSize / defaultScreenSize) * screenInches));
        }
    }

    public static void buttonTextSizeFormat(float defaultTextSize, Button... buttons) {
        for (Button button : buttons) {
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) ((defaultTextSize / defaultScreenSize) * screenInches));
        }
    }

    public static void edittextTextSizeFormat(float defaultTextSize, EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) ((defaultTextSize / defaultScreenSize) * screenInches));
        }
    }

    public static void linearFormat(float widthSize, float heightSize, String inputType, LinearLayout... linearLayouts) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (LinearLayout layout : linearLayouts) {
                layout.setLayoutParams(layParamsOfLinear(widthSize, heightSize, layout));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (LinearLayout layout : linearLayouts) {
                layout.setLayoutParams(layParamsOfRelative(widthSize, heightSize, layout));
            }
        }
    }

    public static void gridviewFormat(float widthSize, float heightSize, String inputType, GridView... gridViews) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (GridView gridView : gridViews) {
                gridView.setLayoutParams(layParamsOfLinear(widthSize, heightSize, gridView));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (GridView gridView : gridViews) {
                gridView.setLayoutParams(layParamsOfRelative(widthSize, heightSize, gridView));
            }
        }
    }

    public static void relativeFormat(float widthSize, float heightSize, String inputType, RelativeLayout... relativeLayouts) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (RelativeLayout layout : relativeLayouts) {
                layout.setLayoutParams(layParamsOfLinear(widthSize, heightSize, layout));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (RelativeLayout layout : relativeLayouts) {
                layout.setLayoutParams(layParamsOfRelative(widthSize, heightSize, layout));
            }
        }
    }

    public static void imageFormat(float widthSize, float heightSize, String inputType, ImageView... imageViews) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (ImageView view : imageViews) {
                view.setLayoutParams(layParamsOfLinear(widthSize, heightSize, view));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (ImageView view : imageViews) {
                view.setLayoutParams(layParamsOfRelative(widthSize, heightSize, view));
            }
        }
    }

    public static void textFormat(float widthSize, float heightSize, String inputType, TextView... textViews) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (TextView view : textViews) {
                view.setLayoutParams(layParamsOfLinear(widthSize, heightSize, view));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (TextView view : textViews) {
                view.setLayoutParams(layParamsOfRelative(widthSize, heightSize, view));
            }
        }
    }

    public static void editextFormat(float widthSize, float heightSize, String inputType, EditText... editTexts) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (EditText view : editTexts) {
                view.setLayoutParams(layParamsOfLinear(widthSize, heightSize, view));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (EditText view : editTexts) {
                view.setLayoutParams(layParamsOfRelative(widthSize, heightSize, view));
            }
        }
    }

    public static void listFormat(float widthSize, float heightSize, String inputType, ListView... listViews) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (ListView listView : listViews) {
                listView.setLayoutParams(layParamsOfLinear(widthSize, heightSize, listView));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (ListView listView : listViews) {
                listView.setLayoutParams(layParamsOfRelative(widthSize, heightSize, listView));
            }
        }
    }

    public static void spinnerFormat(float widthSize, float heightSize, String inputType, Spinner... Spinners) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (Spinner spinner : Spinners) {
                spinner.setLayoutParams(layParamsOfLinear(widthSize, heightSize, spinner));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (Spinner spinner : Spinners) {
                spinner.setLayoutParams(layParamsOfRelative(widthSize, heightSize, spinner));
            }
        }
    }

    public static void buttonFormat(float widthSize, float heightSize, String inputType, Button... buttons) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (Button button : buttons) {
                button.setLayoutParams(layParamsOfLinear(widthSize, heightSize, button));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (Button button : buttons) {
                button.setLayoutParams(layParamsOfRelative(widthSize, heightSize, button));
            }
        }
    }

    public static void viewPagerFormat(float widthSize, float heightSize, String inputType, ViewPager... viewPagers) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (ViewPager viewPager : viewPagers) {
                viewPager.setLayoutParams(layParamsOfLinear(widthSize, heightSize, viewPager));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (ViewPager viewPager : viewPagers) {
                viewPager.setLayoutParams(layParamsOfRelative(widthSize, heightSize, viewPager));
            }
        }
    }

    public static void horizontalScrollViewFormat(float widthSize, float heightSize, String inputType, HorizontalScrollView... horizontalScrollViews) {
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            for (HorizontalScrollView horizontalScrollView : horizontalScrollViews) {
                horizontalScrollView.setLayoutParams(layParamsOfLinear(widthSize, heightSize, horizontalScrollView));
            }
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            for (HorizontalScrollView horizontalScrollView : horizontalScrollViews) {
                horizontalScrollView.setLayoutParams(layParamsOfRelative(widthSize, heightSize, horizontalScrollView));
            }
        }
    }

    private static LinearLayout.LayoutParams layParamsOfLinear(float widthSize, float heightSize, View view) {
        LinearLayout.LayoutParams Params = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (widthSize != 0) {
            Params.width = (int) (vWidth / widthSize);
        }
        if (heightSize != 0) {
            Params.height = (int) (vHeight / heightSize);
        }
        return Params;
    }

    private static RelativeLayout.LayoutParams layParamsOfRelative(float widthSize, float heightSize, View view) {
        RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (widthSize != 0) {
            Params.width = (int) (vWidth / widthSize);
        }
        if (heightSize != 0) {
            Params.height = (int) (vHeight / heightSize);
        }
        return Params;
    }

    public static int paddingView(int size, String inputType, View... views) {
        for(View view : views){
            if(inputType.equals(paddingType.Left.toString())){
                view.setPadding(size,0,0,0);
            }else if(inputType.equals(paddingType.Top.toString())){
                view.setPadding(0,size,0,0);
            }else if(inputType.equals(paddingType.Right.toString())){
                view.setPadding(0,0,size,0);
            }else if(inputType.equals(paddingType.Bot.toString())){
                view.setPadding(0,0,0,size);
            }
        }
        return size;
    }

    public static int getViewWidth(String inputType, View view) {
        int size = 0;
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            size = linearViewSize(deviceSizeUseType.Width.toString(), view);
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            size = relativeViewSize(deviceSizeUseType.Width.toString(), view);
        }
        return size;
    }

    public static int getViewHeight(String inputType, View view) {
        int size = 0;
        if (inputType.equals(parentLayoutType.LinearLayout.toString())) {
            size = linearViewSize(deviceSizeUseType.Height.toString(), view);
        } else if (inputType.equals(parentLayoutType.RelativeLayout.toString())) {
            size = relativeViewSize(deviceSizeUseType.Height.toString(), view);
        }
        return size;
    }

    private static int relativeViewSize(String inputStatus, View view) {
        int Size = 0;
        RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (inputStatus.equals(deviceSizeUseType.Width.toString())) {
            Size = Params.width;
        }else if (inputStatus.equals(deviceSizeUseType.Height.toString())){
            Size = Params.height;
        }
        return Size;
    }

    private static int linearViewSize(String inputStatus, View view) {
        int Size = 0;
        LinearLayout.LayoutParams Params = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (inputStatus.equals(deviceSizeUseType.Width.toString())) {
            Size = Params.width;
        }else if (inputStatus.equals(deviceSizeUseType.Height.toString())){
            Size = Params.height;
        }
        return Size;
    }
}
