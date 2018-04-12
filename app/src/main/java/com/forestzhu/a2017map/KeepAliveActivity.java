package com.forestzhu.a2017map;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class KeepAliveActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);
<<<<<<< HEAD
=======
        System.out.print("一个像素的Activity实现");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
        MonitorManager.getInstance().setKeepAliveActivity(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
