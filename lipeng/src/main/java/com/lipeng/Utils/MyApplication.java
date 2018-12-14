package com.lipeng.Utils;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class MyApplication extends Application {
    private static MyApplication mApplication;
    private int w, h;

    public static synchronized MyApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        DisplayMetrics dm = getResources().getDisplayMetrics();
         w = dm.widthPixels;
         h = dm.heightPixels;

    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public String getversionName() {
        return getPackageInfo().versionName;
    }

    public int getversionCode() {
        return getPackageInfo().versionCode;
    }

    private static PackageInfo getPackageInfo() {
        PackageInfo pi = null;
        try {
            PackageManager pm = MyApplication.getInstance().getPackageManager();
            pi = pm.getPackageInfo(MyApplication.getInstance().getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}
