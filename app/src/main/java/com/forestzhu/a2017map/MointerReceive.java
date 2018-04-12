package com.forestzhu.a2017map;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import java.util.List;

public class MointerReceive extends BroadcastReceiver{
	private static final int WAKEUP_SERVICE_ID = -1111;

    public static final String WAKEUP_ACTION = "com.baidu.track.WAKE_UP";
    public static final String SLEEP_ACTION ="com.baidu.track.SLEEP";
    private WakeLock wakeLock = null;
    private  static String entityName="1";
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		 String action = arg1.getAction();
	        if (Intent.ACTION_SCREEN_OFF.equals(action)) {
	            MonitorManager.getInstance().startKeepAliveActivity(arg0);
	            if (null != wakeLock && !(wakeLock.isHeld())) {
	                wakeLock.acquire();
	            }
	        } else if (Intent.ACTION_SCREEN_ON.equals(action) || Intent.ACTION_USER_PRESENT.equals(action)) {
	        	MonitorManager.getInstance().finishKeepAliveActivity();
	        	if (null != wakeLock && wakeLock.isHeld()) {
	                wakeLock.release();
	            }
	        }
<<<<<<< HEAD
=======
          System.out.print("执行到这里来吗？？wakeservice");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        Intent wakeIntent = new Intent(arg0, WakeupService.class);
        arg0.startService(wakeIntent);
              if(SLEEP_ACTION.equals(action)){
                     arg0.stopService(wakeIntent);
              }
	}
	
	public static class WakeupService extends Service {

        @Override
        public void onCreate() {
            //API < 18
            if (Build.VERSION.SDK_INT < 18) {
                startForeground(WAKEUP_SERVICE_ID, new Notification());
            } else {
                Intent innerIntent = new Intent(this, WakeupInnerService.class);
                startService(innerIntent);
                startForeground(WAKEUP_SERVICE_ID, new Notification());
            }
            super.onCreate();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
        isServiceWork(getApplicationContext(),(MyApplication1)this.getApplication());
            return START_STICKY;
        }

        @Override
        public IBinder onBind(Intent intent) {
            // TODO: Return the communication channel to the service.
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }
	public static  boolean isServiceWork(Context mContext, MyApplication1 trap) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningServiceInfo> myList = myAM.getRunningServices(80);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(trap.getServiceName())) {
                isWork = true;
                break;
            }
        }
        if(isWork==false)
        {
            if(trap.isTraceStarted)
                trap.startLBS();
        }
        return isWork;
    }
    /**
     * API >= 18
     */
    public static class WakeupInnerService extends Service {

        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(WAKEUP_SERVICE_ID, new Notification());
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public IBinder onBind(Intent intent) {
            // TODO: Return the communication channel to the service.
            throw new UnsupportedOperationException("Not yet implemented");
        }
        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }
}
