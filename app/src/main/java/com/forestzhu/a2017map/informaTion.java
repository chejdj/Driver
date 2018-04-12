package com.forestzhu.a2017map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class informaTion extends Activity implements View.OnClickListener {
	private Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.information);
		back=(Button)findViewById(R.id.infor_back_main);
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		 Intent intent = new Intent(informaTion.this,LogoutActivity.class);
		 startActivity(intent);
	}
}
