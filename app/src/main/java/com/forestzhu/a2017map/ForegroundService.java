package com.forestzhu.a2017map;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.LocalBroadcastManager;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class ForegroundService extends Service {
<<<<<<< HEAD
=======
  public static final String ACTION="com.example.map2016.ForegroundService";
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
  private static final int MONITOR_SERVICE_ID = -1001;
  private Timer timer = null;
  private KeepAliveTask keepAliveTask = null;
  MointerReceive pm=null;
  private WakeLock wakelock;
  private String entityname;
    private MyApplication1 trackap=null;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented");
	}
	      
    @Override
    public void onCreate(){
    	super.onCreate();
<<<<<<< HEAD
=======
    	 System.out.println("ForeServerice开启");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    	 timer = new Timer();
         keepAliveTask = new KeepAliveTask(this);
         timer.schedule(keepAliveTask, 1000,30*1000);
         trackap =(MyApplication1)getApplicationContext();
         IntentFilter filter = new IntentFilter();
         filter.addAction(Intent.ACTION_SCREEN_OFF);
         filter.addAction(Intent.ACTION_SCREEN_ON);
         filter.addAction(Intent.ACTION_USER_PRESENT);
         LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
         lbm.registerReceiver(pm,filter);
    }
	@Override
    public int onStartCommand(Intent intent,int flags, int startId) {
		    entityname = trackap.getEntityname();
		if (Build.VERSION.SDK_INT < 18) {
            startForeground(MONITOR_SERVICE_ID, new Notification());
        } else {
            Intent innerIntent = new Intent(this, MonitorInnerService.class);
            startService(innerIntent);//在android5.0的版本消除窗口！！
            startForeground(MONITOR_SERVICE_ID, new Notification());
        }
		if(null==wakelock)
	     {
	    	 PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
	    	 wakelock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,getClass().getCanonicalName());
	     }
	     if(wakelock!=null)
	    	 wakelock.acquire();
		 return START_STICKY;
    }
	public static class MonitorInnerService extends Service {

        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(MONITOR_SERVICE_ID, new Notification());
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
	class KeepAliveTask extends TimerTask {

        private WeakReference<ForegroundService> monitorService = null;

        public KeepAliveTask(ForegroundService monitorService) {
            this.monitorService = new WeakReference<>(monitorService);
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
        	   ForegroundService ms = monitorService.get();
<<<<<<< HEAD
=======
                System.out.print("发送广播");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                Intent monitorIntent = new Intent(MointerReceive.WAKEUP_ACTION);
                ms.getApplicationContext().sendBroadcast(monitorIntent);
        }
    }
    @Override
    public void onDestroy(){
        Intent intent = new Intent(MointerReceive.SLEEP_ACTION);
        this.getApplication().sendBroadcast(intent);
    	timer.cancel();
    	wakelock.release();
    	super.onDestroy();
    }
}