package com.forestzhu.a2017map;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SenseorManager implements SensorEventListener {

    private SensorManager mSensorManager;  
    private Sensor mSensor;  
    private Context mContext;
    private float lastX;  
    private OnOrientationListener mOnOrientationListener; 
    public SenseorManager(Context context)  
    {  
        this.mContext=context;  
    }  
    public void start()  
    {  
        mSensorManager= (SensorManager) mContext  
                .getSystemService(Context.SENSOR_SERVICE);  
        if(mSensorManager!= null)  
        {  

            mSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);  
        }
        if(mSensor!=null)  
        {  

            mSensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_UI);  
  
        }  
  
  
    }  
    public void stop()  
    {  
        mSensorManager.unregisterListener(this);  
  
    }  
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.sensor.getType()==Sensor.TYPE_ORIENTATION)  
        {  
            float x=arg0.values[SensorManager.DATA_X];  
            if(Math.abs(x-lastX)>1.0)  
            {  
                
                    mOnOrientationListener.onOrientationChanged(x);  
            }  
            lastX=x;
  
        }  
	}
	public void setOnOrientationListener(OnOrientationListener onOrientationListener)
	{
		this.mOnOrientationListener = onOrientationListener ;
	}
	
	    public interface OnOrientationListener  
	    {  
	        void onOrientationChanged(float x);  
	  
	    }  
	  

}
