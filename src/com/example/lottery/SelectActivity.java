package com.example.lottery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends Activity {
	private Button btnSelect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		btnSelect = (Button)findViewById(R.id.elenven_choose_five);
		btnSelect.setOnClickListener(new Button.OnClickListener(){

			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SelectActivity.this, LoginActivity.class);
				SelectActivity.this.startActivity(intent);
				//SelectActivity.this.finish();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

}
