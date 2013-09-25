/*
 * Some rights reserved!
 * Author : Layone
 * Mail to superlayone@gmail.com
 */
package activity;

import com.example.lottery.R;
import common.Global;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends Activity{
	private GestureDetector gd;
	private Button btnSelect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		gd=new GestureDetector(this,new OnDoubleClick());
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
	public boolean onTouchEvent(MotionEvent event) {
	       return gd.onTouchEvent(event);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}
	public class OnDoubleClick extends GestureDetector.SimpleOnGestureListener{
	    @Override
	    public boolean onDoubleTap(MotionEvent e) {
	        //TODO
	    	if(e.getX() <= 100 && e.getY() <= 100){
	    		/*
	    		 * Match  if condition
	    		 * change the default value to newest ones
	    		 */
	    		//System.out.println("Double touched");
	    		SharedPreferences preferences = getSharedPreferences(  
	                    Global.GLOBALSETTINGS, MODE_PRIVATE);
	    		Editor editor = preferences.edit(); 
	        	editor.putString(Global.PREFERENCE_GATEWAY, "192.168.1.1"); 
	        	editor.commit(); 
	        	System.out.println("In PREFERENCE_GATEWAY changed!New is :"+
	        	preferences.getString(Global.PREFERENCE_GATEWAY, "none"));
	        	
	    	}
	        return false;
	    }
	}
}

