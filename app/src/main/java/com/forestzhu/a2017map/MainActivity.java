package com.forestzhu.a2017map;

<<<<<<< HEAD
import android.Manifest;
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
=======
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

<<<<<<< HEAD

=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
<<<<<<< HEAD
=======
import com.baidu.mapapi.SDKInitializer;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
<<<<<<< HEAD
import com.baidu.trace.LBSTraceClient;

import java.util.List;
public class MainActivity extends Activity {
    private MapView mv;
    LocationManager map;
    private Button back;
    private Button satellite;
    BaiduMap map2;
    MyApplication1 trackap=null;
    SenseorManager myoritentionlistener;
    AlertDialog dialog;
    double mCurrentLantitude;
    String lantitude;
    String longtitude;
    double mCurrentLongitude;
=======
import com.baidu.trace.Trace;
import com.forestzhu.a2017map.SenseorManager.OnOrientationListener;

import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "ServiceDemoActivity";
    private int touchback=1;
    private MapView mv;
    LocationManager map;
    private Button back;
    BaiduMap map2;
    Trace trace;
    MyApplication1 trackap=null;
    String entityName=null;
    PowerManager pm=null;
    private PowerReceiver powerReceiver = null;
    SenseorManager myoritentionlistener;
    AlertDialog dialog;
    double mCurrentLantitude;
    double mCurrentLongitude;
    LocalBroadcastManager lbm=null;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    MyLocationConfiguration config;
    AlertDialog dialog2;
    MyLocationListener mylocationlistener;
    LocationClient locationclient;
<<<<<<< HEAD
    LBSTraceClient client;
    LocationClientOption option;
    BitmapDescriptor mCurrentMarker;
    int kinds =0;
    private boolean change =false;
    float myCurrentAccary=0;
=======
    LocationClientOption option;
    BitmapDescriptor mCurrentMarker;
    int kinds =0;
    float myCurrentAccary;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    private volatile boolean isFristLocation = true;
    boolean gps=true;
    float mXdirecation;
    LocationManager lm;
<<<<<<< HEAD
    String own_name=null;
    private Context mcontext;
    private static final int BAIDU_READ_PHONE_STATE =1;
    private String bus_user;
=======
    private PowerManager.WakeLock wakeLock = null;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
<<<<<<< HEAD
       // SDKInitializer.initialize(getApplicationContext());
=======
        //	requestWindowFeature(Window.FEATURE_NO_TITLE);
        SDKInitializer.initialize(getApplicationContext());
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        setContentView(R.layout.activity_main);
        //对整张地图进行初始化！
        trackap = (MyApplication1) getApplicationContext();
        back =(Button)findViewById(R.id.main);
<<<<<<< HEAD
        satellite=(Button)findViewById(R.id.satellite);
        satellite.setOnClickListener(new changemaplistener());
        back.setOnClickListener(new backlistener());
        own_name=trackap.getPreference().getString("entityName","");
        mcontext = getApplicationContext();
        initGPS();
        Intent intent = getIntent();
        bus_user=intent.getStringExtra("bus_user");
        if(Build.VERSION.SDK_INT>=23)//判断是否是6.0
        {
            if(mcontext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,},BAIDU_READ_PHONE_STATE);
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},BAIDU_READ_PHONE_STATE);
            }
        }
        else
        {
            init();
            initoritention();
            //检查是否打开GPS
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        switch(requestCode) {
            // requestCode即所声明的权限获取码，在checkSelfPermission时传入
            case BAIDU_READ_PHONE_STATE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    init();
                    initoritention();
                   //检查是否打开GPS

                } else{
                    Toast.makeText(getApplicationContext(),"拒绝将导致运用无法使用",Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }
    class changemaplistener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(!change)
            {
                map2.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                change = true;}
            else
            {
                map2.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                change = false;
            }
        }
=======
        back.setOnClickListener(new backlistener());
        init();
        initoritention();
        opengps();//检查是否打开GPS
        opennet();//检查是否打开网络
        locationclient.start();
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    }
    class backlistener implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent =new Intent(MainActivity.this,Main1Activity.class);
<<<<<<< HEAD
            intent.putExtra("bus_user",bus_user);
            startActivity(intent);
        }
    }
    private void initoritention()
    {
        myoritentionlistener = new SenseorManager(getApplicationContext());
        myoritentionlistener.setOnOrientationListener(new SenseorManager.OnOrientationListener() {
=======
            startActivity(intent);
        }

    }
    public void initoritention()
    {
        myoritentionlistener = new SenseorManager(getApplicationContext());
        myoritentionlistener.setOnOrientationListener(new OnOrientationListener() {
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
            @Override
            public void onOrientationChanged(float x) {
                // TODO Auto-generated method stub
                mXdirecation =  x;
                MyLocationData locData = new MyLocationData.Builder()
<<<<<<< HEAD
                        .accuracy(myCurrentAccary)//去掉大头针旁边的圆圈
=======
                        .accuracy(myCurrentAccary)
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                        // 此处设置开发者获取到的方向信息，顺时针0-360
                        .direction(mXdirecation)
                        .latitude(mCurrentLantitude)
                        .longitude(mCurrentLongitude).build();
                // 设置定位数据
                map2.setMyLocationData(locData);
                // 设置自定义图标
                map2.setMyLocationConfigeration(config);
            }
        });
    }
<<<<<<< HEAD
    private void initGPS() {
        LocationManager locationManager = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        // 判断GPS模块是否开启，如果没有则开启
        if (!locationManager
                .isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            Toast.makeText(MainActivity.this, "请打开GPS",
                    Toast.LENGTH_SHORT).show();
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("请打开GPS");
            dialog.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // 转到手机设置界面，用户设置GPS
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivityForResult(intent, 0); // 设置完成后返回到原来的界面
                        }
                    });
            dialog.setNeutralButton("取消", new android.content.DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.dismiss();
                    Toast.makeText(MainActivity.this,"可能导致位置有偏差",Toast.LENGTH_SHORT).show();
                }
            } );
            dialog.show();
        }
    }
    public void init() {
=======
    public void init()
    {
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        mCurrentMarker = BitmapDescriptorFactory
                .fromResource(R.drawable.main_icon_follow);//为自己的位置上面，添加图标
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mv = (MapView) findViewById(R.id.mv);
        mv.showZoomControls(false);
<<<<<<< HEAD
        map = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        map2 = mv.getMap();
        map2.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        map2.setMyLocationEnabled(true);
        //对百度图标logo进行隐藏！
        View child = mv.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        client = new LBSTraceClient(getApplicationContext());
        //初始化位置管理
        mylocationlistener = new MyLocationListener();//显示自己位置
=======
        map = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        map2=mv.getMap();
        map2.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //对百度图标logo进行隐藏！
        View child = mv.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)){
            child.setVisibility(View.INVISIBLE);
        }
        //初始化位置管理
        mylocationlistener = new MyLocationListener();
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        locationclient = new LocationClient(getApplicationContext());
        option = new LocationClientOption();
        option.setOpenGps(true);
        option.setCoorType("bd09ll"); // 设置坐标类型
<<<<<<< HEAD
        option.setScanSpan(5000);//10秒进行一次定位位置
        option.setIsNeedLocationDescribe(true);
        option.setEnableSimulateGps(true);//虚拟GPS开启
        locationclient.setLocOption(option);
        Log.e("BAIDU","开启服务");
        locationclient.registerLocationListener(mylocationlistener);
        locationclient.start();
        //获取轨迹并且绘制出来。
        //startTime = (int)((System.currentTimeMillis())/1000-30*60);
    }
    private void opennet()
=======
        option.setScanSpan(5000);
        option.setIsNeedLocationDescribe(true);//5秒进行一次定位位置
        locationclient.setLocOption(option);
        locationclient.start();
        locationclient.registerLocationListener(mylocationlistener);
        lbm = LocalBroadcastManager.getInstance(this);
        registerPowerReceiver();
    }
    //注册电源广播

    private void registerPowerReceiver() {
        if (null == pm) {
            pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        }
        if (null == wakeLock) {
            wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "track upload");
        }
        if (null == powerReceiver) {
            powerReceiver = new PowerReceiver(wakeLock);
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        if (null == lbm) {
            lbm = LocalBroadcastManager.getInstance(this);
        }
        lbm.registerReceiver(powerReceiver, filter);
    }

    public void opennet()
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if(networkinfo!=null)
            return;
        dialog2 = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("请打开网络")
                .setPositiveButton("已打开",null)
                .setCancelable(false)
                .create();
        dialog2.setCancelable(false);
        dialog2.show();
        //复写
        dialog2.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                ConnectivityManager connectivitymanager2 = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkinfo2 = connectivitymanager2.getActiveNetworkInfo();
                if(networkinfo2!=null)
                {
                    dialog2.dismiss();
                    return ;
                }
            }
        });
    }
<<<<<<< HEAD
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {  //对手机的返回键和菜单键的响应写出对应的功能
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent=new Intent(MainActivity.this,Main1Activity.class);
            intent.putExtra("bus_user",bus_user);
            startActivity(intent);
=======
    public void opengps()
    {
        if(trackap.isfistMaintivity) {
            List<String> providers = lm.getProviders(true);
            trackap.isfistMaintivity=false;
            if (providers.contains(LocationManager.GPS_PROVIDER)) {
                gps = false;
                return;
            }
            dialog = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("请开启GPS")
                    .setPositiveButton("已开启", null)
                    .setNegativeButton("不开启", null)
                    .setCancelable(false)
                    .create();
            dialog.show();
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getApplicationContext(), "可能导致定位不准确！", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<String> providers = lm.getProviders(true);
                    if (providers.contains(LocationManager.GPS_PROVIDER)) {
                        dialog.dismiss();
                        return;
                    }

                }
            });
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {  //对手机的返回键和菜单键的响应写出对应的功能
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(touchback%2==0)
            {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            return true;
            }
            else
            {
                touchback++;
                Toast.makeText(getApplicationContext(),"再按一次回到主界面",Toast.LENGTH_SHORT).show();
                return true;
            }
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        }
        if(keyCode ==KeyEvent.KEYCODE_MENU)
        {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
<<<<<<< HEAD
    public  class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation arg0) {   //BDLocation arg0已经接受位置
            // TODO Auto-generated method stub
            Log.e("BAIDU",arg0.getLocType()+" ");
            if (arg0 == null)
=======
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation arg0) {   //BDLocation arg0已经接受位置
            // TODO Auto-generated method stub
            if (arg0 == null||arg0==null)
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
            {
                opennet();
                return;
            }
<<<<<<< HEAD
            MyLocationData locData = new MyLocationData.Builder().accuracy(0)
=======
            MyLocationData locData = new MyLocationData.Builder().accuracy(arg0.getRadius())
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                    .direction(mXdirecation).latitude(arg0.getLatitude()).longitude(arg0.getLongitude())
                    .build();
            mCurrentLantitude = arg0.getLatitude();
            mCurrentLongitude = arg0.getLongitude();
<<<<<<< HEAD
=======
            myCurrentAccary = arg0.getRadius();
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
            map2.setMyLocationData(locData);
            if(kinds==1){
                kinds=0;
                config = new MyLocationConfiguration(
                        MyLocationConfiguration.LocationMode.COMPASS,true,mCurrentMarker);
                map2.setMyLocationConfigeration(config);
                LatLng ll = new LatLng(arg0.getLatitude(),
                        arg0.getLongitude());
<<<<<<< HEAD
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(ll,18f);//设定地图的放大倍数
=======
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(ll,19f);//设定地图的放大倍数
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                map2.animateMapStatus(u);
            }
            if (isFristLocation)
            {
                isFristLocation = false;
<<<<<<< HEAD
                lantitude=String.valueOf(mCurrentLantitude);
                longtitude=String.valueOf(mCurrentLongitude);
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                LatLng ll = new LatLng(arg0.getLatitude(),
                        arg0.getLongitude());
                config = new MyLocationConfiguration(
                        MyLocationConfiguration.LocationMode.NORMAL,true,mCurrentMarker);//mCurrentMarker
                map2.setMyLocationConfigeration(config);
<<<<<<< HEAD
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(ll,17f);//设定地图的放大倍数
=======
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(ll,18f);//设定地图的放大倍数
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
                map2.animateMapStatus(u);//整张地图以u的位置为中心
                Toast.makeText(getApplicationContext(),arg0.getLocationDescribe(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        map2.setMyLocationEnabled(true);
        myoritentionlistener.start();
    }
<<<<<<< HEAD
    @Override
    protected void onStop(){
        super.onStop();
    }
}

=======

}


>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
