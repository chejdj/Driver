package com.forestzhu.a2017map;

<<<<<<< HEAD
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
=======
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import view.CircleImageView;

public class Main1Activity extends Activity {
  private Button change;
  private Button back;
	private RadioGroup radiogroup;
	private RadioButton radio_KB;
	private RadioButton radio_BK;
	private CircleImageView icon;
	private int touchback=1;
	private TextView car_state;
	private Intent intent1;
	private Intent intent2;
	private AlertDialog dialog_cancel;
	private AlertDialog dialog_route;
	private MyApplication1 trackap=null;
<<<<<<< HEAD
	private Context mcontext;
	private static final int BAIDU_READ_PHONE_STATE =1;
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main1);
		car_state =(TextView)findViewById(R.id.car_state);
		change=(Button)findViewById(R.id.car_change);
		back=(Button)findViewById(R.id.backmap);
		icon = (CircleImageView)findViewById(R.id.picture) ;
		radiogroup=(RadioGroup)findViewById(R.id.radiogrop);
		radio_KB=(RadioButton)findViewById(R.id.K_B);
		radio_BK=(RadioButton)findViewById(R.id.B_K);
		radiogroup.setOnCheckedChangeListener(new radiolistener());
		change.setOnClickListener(new mylistener());
		back.setOnClickListener(new backlistener());
		icon.setOnClickListener(new picturelistener());
		trackap=(MyApplication1)getApplicationContext();
<<<<<<< HEAD
		mcontext=getApplicationContext();
		if(Build.VERSION.SDK_INT>=23)//判断是否是6.0
		{
			if(mcontext.checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
			{
				ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,},BAIDU_READ_PHONE_STATE);
				ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},BAIDU_READ_PHONE_STATE);
			}
		}
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
		if(trackap.trace_route==1)
		{
			radio_KB.setChecked(true);
		}
        if(trackap.trace_route==2)
	   {
		  radio_BK.setChecked(true);
	   }
		if(trackap.isTartLBS()){
			car_state.setText("发车");
			change.setBackgroundResource(R.drawable.rebackground);
		}
		else{
			car_state.setText("未发车");
			change.setBackgroundResource(R.drawable.rollbutton_shape);
		}
		if(trackap.own_picture()!=null)
		{
			Bitmap photoBitmap = trackap.own_picture();
			icon.setImageBitmap(photoBitmap);
		}
		else{
			icon.setImageResource(R.drawable.school_target);
		}
		dialog_cancel = new AlertDialog.Builder(this).setTitle("提示")
				.setMessage("是否确认本行程结束").setPositiveButton("继续行程",null)
				.setNegativeButton("结束行程",null).setCancelable(false).create();
		dialog_route= new AlertDialog.Builder(this).setTitle("提示")
				.setMessage("没有选择路线").setPositiveButton("确定",null)
				.setCancelable(false).create();
	}
<<<<<<< HEAD
	@Override
	public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions,grantResults);
		switch(requestCode) {
			// requestCode即所声明的权限获取码，在checkSelfPermission时传入
			case BAIDU_READ_PHONE_STATE:
				if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					Log.e("LOCATION","用户拒绝定位");
				} else{

					Log.e("Location","用户拒绝定位");
				}
				break;

			default:
				break;
		}
	}
	private void initGPS() {
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		// 判断GPS模块是否开启，如果没有则开启
		if (!locationManager
				.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
			Toast.makeText(Main1Activity.this, "请打开GPS",
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
				}
			} );
			dialog.show();
		}
	}
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
	class radiolistener implements RadioGroup.OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if(checkedId==radio_BK.getId()){
<<<<<<< HEAD
				//radio_BK.setChecked(true);
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
				trackap.trace_route=2;
			}
			if(checkedId==radio_KB.getId())
			{
<<<<<<< HEAD
				//radio_KB.setChecked(true);
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
				trackap.trace_route=1;
			}
		}
	}
	class picturelistener implements OnClickListener{
		@Override
		public void onClick(View v) {
                   Intent  intent = new Intent (Main1Activity.this,LogoutActivity.class);
			              startActivity(intent);
		}
	}
    class mylistener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (trackap.trace_route == 0) {
                  dialog_route.show();
				dialog_route.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog_route.dismiss();
					}
				});
			} else {
				if (!trackap.isTartLBS()) {
<<<<<<< HEAD
					initGPS();
=======
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
					car_state.setText("发车");
					trackap.isTraceStarted = true;
					change.setBackgroundResource(R.drawable.rebackground);
					trackap.startLBS();
					if (Build.VERSION.SDK_INT <20 ) {//测试下Fservice;
						intent1 = new Intent(Main1Activity.this, ForegroundService.class);
						startService(intent1);
					} else {
						intent2 = new Intent(Main1Activity.this, Jobservice.class);
						startService(intent2);
					}
				} else {
					dialog_cancel.show();
					dialog_cancel.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog_cancel.dismiss();
						}
					});
					dialog_cancel.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							trackap.isTraceStarted = false;
							change.setBackgroundResource(R.drawable.rollbutton_shape);
							if (Build.VERSION.SDK_INT < 20)//测试Fservice;
							{
								radio_BK.setChecked(false);
								radio_KB.setChecked(false);
								trackap.trace_route=0;
								Intent intent_stop = new Intent(Main1Activity.this, ForegroundService.class);
								stopService(intent_stop);
								trackap.stopLBS();
								car_state.setText("未发车");
							} else {
								radio_BK.setChecked(false);
								radio_KB.setChecked(false);
								trackap.trace_route=0;
								Intent intent_stopJob = new Intent(Main1Activity.this, Jobservice.class);
								stopService(intent_stopJob);
								trackap.stopLBS();
								car_state.setText("未发车");
							}
							dialog_cancel.dismiss();
						}
					});
			/*trackap.isTraceStarted =false;
			change.setBackgroundResource(R.drawable.rollbutton_shape);
			if(Build.VERSION.SDK_INT < 23)//测试Fservice;
			{
				Intent intent_stop = new Intent(Main1Activity.this,ForegroundService.class);
				stopService(intent_stop);
				trackap.stopLBS();
			}
			else{
				Intent intent_stopJob = new Intent(Main1Activity.this,ForegroundService.class);
				stopService(intent_stopJob);
			}*/
				}
			}
		}
	}
	class backlistener implements OnClickListener{
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Main1Activity.this,MainActivity.class);
		    startActivity(intent);
		}
}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {  //对手机的返回键和菜单键的响应写出对应的功能
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(touchback%2==0) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
				return true;
			}
			else{
				touchback++;
				Toast.makeText(getApplicationContext(),"再按一次回到主界面",Toast.LENGTH_SHORT).show();
			   return true;
			}
		}
		if(keyCode ==KeyEvent.KEYCODE_MENU)
		{
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}