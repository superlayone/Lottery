/*
 * Some rights reserved!
 * Author : Layone
 * Mail to superlayone@gmail.com
 */
package com.example.lottery;

import java.lang.ref.WeakReference;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;

public class WelcomeActivity extends Activity {

	//Define go
	private static final int goSelect = 1000;  
	private static final int goGuide = 1001; 
	//Splash delay time
	private static final long SPLASH_DELAY_MILLIS = 2000; 
	//Preference 
	boolean isFirstIn = false;  
	private static final String SHAREDPREFERENCES_NAME = "first_pref";  
	//Handler
	private Handler mHandler = new MyHandler(this) {  		  
	        @Override  
	        public void handleMessage(Message msg) {  
	            switch (msg.what) {  
	            case goSelect:  
	            	goSelectActivity();  
	                break;  
	            case goGuide:  
	                goGuideActivity();  
	                break;  
	            }  
	            super.handleMessage(msg);  
	        }  
	    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		init();
    }
	//Using weak reference to avoid leaking occur
	private static class MyHandler extends Handler{
	    private final WeakReference<Activity> mActivity;
	    public MyHandler(Activity activity) {
	        mActivity = new WeakReference<Activity>(activity);
	    }
	    @Override
	    public void handleMessage(Message msg) {
	        System.out.println(msg);
	        if(mActivity.get() == null) {
	            return;
	        }
	    }
	}
	/*
	 * Checkout if first in
	 */
	private void init() {  
        SharedPreferences preferences = getSharedPreferences(  
                SHAREDPREFERENCES_NAME, MODE_PRIVATE);    
        isFirstIn = preferences.getBoolean("isFirstIn", true);  
        if (isFirstIn) { 
        	mHandler.sendEmptyMessageDelayed(goGuide, SPLASH_DELAY_MILLIS);             
        } else {  
        	mHandler.sendEmptyMessageDelayed(goSelect, SPLASH_DELAY_MILLIS); 
        }  
  
    }  
    private void goSelectActivity() {  
    	Intent intent = new Intent();
		intent.setClass(WelcomeActivity.this, SelectActivity.class);
		startActivity(intent);
		WelcomeActivity.this.overridePendingTransition(R.layout.welcomepage_alpha_in, R.layout.welcomepage_alpha_out);
		finish();
    }  
  
    private void goGuideActivity() {  
        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);  
        WelcomeActivity.this.startActivity(intent);  
        WelcomeActivity.this.finish();  
    }  
	@Override  
	//hold up BACK operations
    public boolean onKeyDown(int keyCode, KeyEvent event) {   
        if(keyCode==KeyEvent.KEYCODE_BACK) {   
            return false;   
        }   
        return false;   
    } 

}
