package com.forestzhu.a2017map;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
=======
import android.util.Log;
import android.widget.Toast;

import java.util.List;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab

/**
 * Created by 洋洋 on 2016/12/25.
 */
    @TargetApi(21)
public class Jobservice extends JobService {
    private int kJobId = 0;
    private MyApplication1 trackap;
<<<<<<< HEAD
    JobScheduler tm=null;
    private Timer timer =new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            if(trackap.isTartLBS())
            {
                message.arg1=1;
                handler.sendMessage(message);
            }
            else
            {
                timer.cancel();
            }
        }
    };
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            // 要做的事情
            isServiceWork(getApplication(),trackap);
            super.handleMessage(msg);
        }
    };
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
=======
    JobScheduler tm;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.e("Jobservice", "jobService启动");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        trackap =(MyApplication1)getApplicationContext();
        scheduleJob(getJobInfo());
        return START_NOT_STICKY;
    }
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
<<<<<<< HEAD
        trackap =(MyApplication1)getApplicationContext();
        if(trackap.isTartLBS()) {
            timer.schedule(task,1000,60000);//一分钟
           isServiceWork(getApplicationContext(), trackap);
       }
        else{
           jobFinished(jobParameters,false);
       }
=======
        // boolean isLocalServiceWork = isServiceWork(this, "com.castiel.service.LocalCastielService");
        //   boolean isRemoteServiceWork = isServiceWork(this, "com.castiel.service.RemoteCastielService");
      //  if(!trackap.isTartLBS()){
        //   trackap.startLBS();
        trackap =(MyApplication1)getApplicationContext();
        if(trackap.isTartLBS()) {
            Log.e("Jobservice", "LBS检查启动");
            //}
            isServiceWork(getApplicationContext(), trackap);
        }
        else{
            Log.e("Jobservice","JobFinish");
            jobFinished(jobParameters,false);
        }
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        return false;
    }
    public static  boolean isServiceWork(Context mContext, MyApplication1 trap) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(80);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(trap.getServiceName())) {
                isWork = true;
<<<<<<< HEAD
               break;
=======
                break;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
            }
        }
        if(isWork==false)
        {
<<<<<<< HEAD
=======
            Log.e("Jobservice","重启LBSservice");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
            if(trap.isTraceStarted)
                trap.startLBS();
        }
        return isWork;
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
<<<<<<< HEAD
        if(!trackap.isTartLBS())
=======
        Log.e("Jobservice", "执行了onStopJob方法");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        scheduleJob(getJobInfo());
        return false;
    }
    public void scheduleJob(JobInfo t) {
        if(trackap.isTartLBS())
        {
<<<<<<< HEAD
            tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
             tm.schedule(t);}
        else{
            if(tm!=null) {
                tm.cancelAll();
            }
=======
            Log.e("Jobservice","tm create");
            tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
             tm.schedule(t);}
        else{
            Log.e("Jobservice","tm  cancel");
            tm.cancelAll();
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        }
    }

    public JobInfo getJobInfo(){
<<<<<<< HEAD
        JobInfo.Builder builder = new JobInfo.Builder(kJobId, new ComponentName(this, Jobservice.class));
=======
        JobInfo.Builder builder = new JobInfo.Builder(kJobId++, new ComponentName(this, Jobservice.class));
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);
        builder.setRequiresCharging(false);
        builder.setRequiresDeviceIdle(false);
<<<<<<< HEAD

=======
        //间隔100毫秒
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        builder.setPeriodic(60000);
        return builder.build();
    }
}
