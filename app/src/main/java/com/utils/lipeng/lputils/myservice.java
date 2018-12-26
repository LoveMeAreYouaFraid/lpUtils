package com.utils.lipeng.lputils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class myservice extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
//        startActivity(LaunchIntent);
    }
}
