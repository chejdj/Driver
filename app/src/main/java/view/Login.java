package view;

import android.app.Activity;
<<<<<<< HEAD
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
=======
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.forestzhu.a2017map.Main1Activity;
import com.forestzhu.a2017map.MainActivity;
import com.forestzhu.a2017map.MyApplication1;
import com.forestzhu.a2017map.R;

public class Login extends Activity {
	private Button btn;
	private MyApplication1 trackap=null;
	String name =null;
	String number=null;
	private SharedPreferences shared=null;
	final int CODE =1;
	private EditText car_name;
	private EditText car_number;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.user_login);
		    trackap = (MyApplication1)getApplicationContext();
	        car_name = (EditText)findViewById(R.id.user_name);
	        car_number=(EditText)findViewById(R.id.user_number);
	        btn=(Button)findViewById(R.id.login);
	        btn.setOnClickListener(new mylistener());
		     shared = trackap.getPreference();
<<<<<<< HEAD
		 //开机自启动
		 if(!(shared.getString("entityName","").equals("")
				 &&shared.getString("tripname","").equals("")))
=======
		 if(!(shared.getString("entityName","").equals("")&&shared.getString("tripname","").equals("")))
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
		 {
			   Intent intent = new Intent(Login.this,Main1Activity.class);
			   startActivity(intent);
		 }
	 }
	 class mylistener implements OnClickListener{
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			name = car_name.getText().toString();
			number = car_number.getText().toString();
			if(name.equals("")||number.equals(""))
			{
				Toast.makeText(getApplicationContext(),"错误填写",Toast.LENGTH_SHORT).show();
			}
			else
			{
				trackap.saveLoginInfo(name,number);
				trackap.setEntityName(name+number);
<<<<<<< HEAD
=======
				trackap.intitDaemonclient();
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
			Intent intent = new Intent(Login.this,Main1Activity.class);
			startActivity(intent);
			}
		}
	 }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
