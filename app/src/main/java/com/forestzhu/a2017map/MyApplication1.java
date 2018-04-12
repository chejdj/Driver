package com.forestzhu.a2017map;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
<<<<<<< HEAD
import android.util.Log;


import com.baidu.mapapi.SDKInitializer;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.Trace;
import com.baidu.trace.model.LocationMode;
import com.baidu.trace.model.OnTraceListener;
import com.baidu.trace.model.PushMessage;
=======
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.LocationMode;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.OnStopTraceListener;
import com.baidu.trace.Trace;
import com.marswin89.marsdaemon.DaemonClient;
import com.marswin89.marsdaemon.DaemonConfigurations;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab

import java.util.List;

/**
 * Created by 洋洋 on 2016/12/7.
 */

public class MyApplication1 extends Application {
<<<<<<< HEAD
=======
    private DaemonClient mDemonClient;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private Context context;
    private String Entityname=null;
    private Trace trace;
    private SharedPreferences shareD=null;
<<<<<<< HEAD
    private LBSTraceClient client;
    private long ServiceId = 127068;
    private int gatherInterval = 5;
    private int packInterval = 10;
=======
    private OnStartTraceListener startTraceListener;
    private OnStopTraceListener stopTraceListener;
    private LBSTraceClient client;
    private int ServiceId = 127068;
    private int gatherInterval = 5;
    private int packInterval = 30;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private int traceType = 2;
    public int trace_route=0;
    public boolean isfistMaintivity=true;
    public boolean isTraceStarted = false;
    private Bitmap own_picture=null;
<<<<<<< HEAD
    private OnTraceListener mtrace;
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private static final String SERVICE_NAME = "com.baidu.trace.LBSTraceService";
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        context =getApplicationContext();
        SDKInitializer.initialize(this);
        intitclient();//初始化client
<<<<<<< HEAD
        trace_route=0;
        shareD = getSharedPreferences("Secerct",MODE_PRIVATE);
        mtrace= new OnTraceListener() {
            @Override
            public void onBindServiceCallback(int i, String s) {
                Log.e("BAIDU","绑定"+s+i);
            }

            @Override
            public void onStartTraceCallback(int i, String s) {
                Log.e("BAIDU","开始服务"+s+i);
            }

            @Override
            public void onStopTraceCallback(int i, String s) {
                Log.e("BAIDU","结束服务"+s+i);
            }

            @Override
            public void onStartGatherCallback(int i, String s) {
                Log.e("BAIDU","开始收集数据服务"+s+i);
            }

            @Override
            public void onStopGatherCallback(int i, String s) {

            }

            @Override
            public void onPushCallback(byte b, PushMessage pushMessage) {

            }

            @Override
            public void onInitBOSCallback(int i, String s) {

            }
        };

=======
        intitDaemonclient();
        trace_route=0;
        client.setLocationMode(LocationMode.High_Accuracy);
        client.setInterval(gatherInterval,packInterval);
        client.setProtocolType(traceType);
        shareD = getSharedPreferences("Secerct",MODE_PRIVATE);
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    }
    public  void saveLoginInfo(String name,String trip)
    {
        SharedPreferences.Editor editor = shareD.edit();
        editor.putString("tripname",trip);
        editor.putString("entityName",name);
        editor.apply();
    }
    public SharedPreferences getPreference()
    {
        return shareD;
    }
    public String  getServiceName(){return SERVICE_NAME;}
    public void setEntityName(String str1)
    {
        Entityname =str1;
    }
    public String getEntityname()
     {
         return Entityname;
     }
<<<<<<< HEAD
    public void intitclient(){
        client =new LBSTraceClient(context);
    }
    public boolean isTartLBS()
    {
=======
    public  void intitDaemonclient()
    {
        mDemonClient = new DaemonClient(createDaemonConfigurations());
        mDemonClient.onAttachBaseContext(context);
    }
    public void intitclient(){
        client =new LBSTraceClient(context);
        startTraceListener =new OnStartTraceListener() {
            /*
             开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
             */
            @Override
            public void onTraceCallback(int i, String s) {

            }
            /*
            onTracePushCallback用于接受服务推送消息
             */
            @Override
            public void onTracePushCallback(byte b, String s) {

            }
        };
        stopTraceListener =new OnStopTraceListener() {
            // 轨迹服务停止成功
            @Override
            public void onStopTraceSuccess() {
            }
            //轨迹服务停止失败
            @Override
            public void onStopTraceFailed(int i, String s) {
                Toast.makeText(getApplicationContext(),"轨迹停止失败",Toast.LENGTH_SHORT).show();
            }
        };
    }
    private DaemonConfigurations createDaemonConfigurations() {
        DaemonConfigurations.DaemonConfiguration configuration1 = new DaemonConfigurations.DaemonConfiguration(
                "com.forestzhu.a2017map:process1",
                ForegroundService.class.getCanonicalName(),
                        Receive1.class.getCanonicalName());
        DaemonConfigurations.DaemonConfiguration configuration2 = new DaemonConfigurations.DaemonConfiguration(
                "com.forestzhu.a2017map:daemon",
                Service1.class.getCanonicalName(),
                Receive2.class.getCanonicalName());
        return new DaemonConfigurations(configuration1, configuration2);
    }
    public boolean isTartLBS()
    {

>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        return isTraceStarted;
    }
    public void startLBS()
    {
       Entityname=String.valueOf(trace_route)+shareD.getString("entityName","");
         //  isTraceStarted=true;
<<<<<<< HEAD
        client.setLocationMode(LocationMode.High_Accuracy);
        client.setInterval(gatherInterval,packInterval);
        trace = new Trace(ServiceId, Entityname);
          client.startTrace(trace,mtrace);
          client.startGather(mtrace);
          Log.e("BAIDU",Entityname);
    }
    public void stopLBS()
    {
        client.stopTrace(trace,mtrace);
=======
           trace = new Trace(getApplicationContext(), ServiceId, Entityname, traceType);
           client.startTrace(trace, startTraceListener);
    }
    public void stopLBS()
    {
        client.stopTrace(trace,stopTraceListener);
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    }
    public static  boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(80);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }
    public Bitmap own_picture()
    {
        own_picture= BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getAbsolutePath()+"/com.foerstzhu" + "/" +"image" +".png");
        if(own_picture!=null)
         return own_picture;
        else
            return null;
    }
}
