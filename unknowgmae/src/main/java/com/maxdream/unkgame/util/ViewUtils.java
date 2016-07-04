package com.maxdream.unkgame.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.maxdream.unkgame.R;

public class ViewUtils {
    private static ProgressDialog loadingDialog;
    private static Activity actInUtil;

    public interface DialogOneEvent {
        void positiveEvent();
    }

    public interface DialogTwoEvent extends DialogOneEvent {
        void negativeEvent();
    }

    /**
     * 顯示讀取中的畫面
     */
    public static void loadingStart(Activity act) {
        if (actInUtil != act) {
            if (null != loadingDialog) {
                loadingFinish();
            }
            actInUtil = act;
            loadingDialog = new ProgressDialog(actInUtil);
        }
        loadingDialog.setTitle(actInUtil.getString(R.string.networkIssue_loading));
        loadingDialog.setMessage(actInUtil.getString(R.string.networkIssue_waiting));
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }

    /**
     * 結束讀取中的畫面
     */
    public static void loadingFinish() {
        if (null != loadingDialog) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
        }
    }

    public static void exitAppWithEvent(Activity activity, DialogTwoEvent dialogTwoEvent) {
        exitApp(activity, dialogTwoEvent);
    }

    public static void exitApp(final Activity activity) {
        exitApp(activity, null);
    }

    private static void exitApp(final Activity activity, final DialogTwoEvent dialogTwoEvent) {
        DialogTwoEvent exitEvent = new DialogTwoEvent() {
            @Override
            public void negativeEvent() {

            }

            @Override
            public void positiveEvent() {
                activity.finish();
                if (null != dialogTwoEvent) {
                    dialogTwoEvent.positiveEvent();
                }
            }
        };
        resultError(activity, activity.getString(R.string.app_name), activity.getString(R.string.quit_check), activity.getString(R.string.yes), activity.getString(R.string.no), null, exitEvent);
    }

    public static void resultError(Activity activity, String title, String message) {
        DialogOneEvent dialogOneEvent = new DialogOneEvent() {
            @Override
            public void positiveEvent() {

            }
        };
        resultError(activity, title, message, activity.getString(R.string.confirm), null, dialogOneEvent, null);
    }

    public static void resultError(Activity activity, String title, String message, String positive, DialogOneEvent dialogOneEvent) {
        resultError(activity, title, message, positive, null, dialogOneEvent, null);
    }

    public static void resultError(Activity activity, String title, String message, String positive, String negative, DialogTwoEvent dialogTwoEvent) {
        resultError(activity, title, message, positive, negative, null, dialogTwoEvent);
    }

    public static void resultMerchandise(Activity activity, View view, String title, String positive, String negative, final DialogTwoEvent dialogTwoEvent) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setCancelable(false);
        alertDialog.setTitle(title);
        alertDialog.setView(view);
        alertDialog.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogTwoEvent.positiveEvent();
            }
        });
        alertDialog.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

    private static void resultError(Activity activity, String title, String message, String positive, String negative, final DialogOneEvent dialogOneEvent, final DialogTwoEvent dialogTwoEvent) {
        loadingFinish();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(message);
        if (null != positive) {
            alertDialog.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (null != dialogOneEvent) {
                        dialogOneEvent.positiveEvent();
                    } else {
                        dialogTwoEvent.positiveEvent();
                    }
                }
            });
        }
        if (null != positive) {
            alertDialog.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialogTwoEvent.negativeEvent();
                }
            });
        }
        alertDialog.show();
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            if (info != null) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            //找不到符合 package name 的 App 要做的事情，比如提示安裝等
            Log.d("", "沒有" + packageName);
            return false;
        }
    }

    public static boolean checkDate(String inputdate1, String inputdate2) {
        boolean status = false;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            cal1.setTime(sdf.parse(inputdate1));
            cal2.setTime(sdf.parse(inputdate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (cal1.compareTo(cal2) == 1) {
            status = true;
        }
        return status;
    }

    public static boolean checkNetworkConnected(Activity activity) {
        boolean result = false;
        ConnectivityManager CM = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (CM == null) {
            result = false;
        } else {
            NetworkInfo info = CM.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (!info.isAvailable()) {
                    result = false;
                } else {
                    result = true;
                }
                Log.d(activity.getPackageName(), "[目前連線方式]" + info.getTypeName());
                Log.d(activity.getPackageName(), "[目前連線狀態]" + info.getState());
                Log.d(activity.getPackageName(), "[目前網路是否可使用]" + info.isAvailable());
                Log.d(activity.getPackageName(), "[網路是否已連接]" + info.isConnected());
                Log.d(activity.getPackageName(), "[網路是否已連接 或 連線中]" + info.isConnectedOrConnecting());
                Log.d(activity.getPackageName(), "[網路目前是否有問題 ]" + info.isFailover());
                Log.d(activity.getPackageName(), "[網路目前是否在漫遊中]" + info.isRoaming());
            }
        }
        return result;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
