package com.maxdream.unkgame;

import android.app.Application;
import android.os.Environment;

import java.io.File;

//import static com.maxdream.unkgame.util.Constants.FILE_LOCAL_PATH;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            String path = FILE_LOCAL_PATH;
//            File dirFile = new File(path);
//            if (!dirFile.exists()) {// 如果資料夾不存在
//                dirFile.mkdir();// 建立資料夾
//            }
//        }
    }
}
