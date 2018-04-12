package com.forestzhu.a2017map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MonitorManager {

    private static MonitorManager manager = new MonitorManager();

    private Activity keepAliveActivity = null;


    public static MonitorManager getInstance() {
        return manager;
    }

    public void startKeepAliveActivity(Context context) {
        Intent keepAliveIntent = new Intent(context, KeepAliveActivity.class);
        keepAliveIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(keepAliveIntent);
    }

    public void finishKeepAliveActivity() {
        if (null != keepAliveActivity) {
            keepAliveActivity.finish();
            keepAliveActivity = null;
        }
    }

    public void setKeepAliveActivity(Activity activity) {
        keepAliveActivity = activity;
    }
}
