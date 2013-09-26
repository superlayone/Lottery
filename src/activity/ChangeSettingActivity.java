/*
 * Some rights reserved!
 * Author 	: 	Layone
 * Date 	: 	2013-09
 * Mail 	: 	superlayone@gmail.com
 */
package activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.lottery.R;
import common.Global;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeSettingActivity extends Activity {
	private Button btnChangeDone;
	private Button btnChangeCancel;
	private String terminalNo;
	private String siteNo;
	private String gateway;
	private String platformIP;
	private String platformPort;
	private EditText etTerminalNo;
	private EditText etSiteNo;
	private EditText etGateway;
	private EditText etPlatformIP;
	private EditText etPlatformPort;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_setting);
		//Find view
		btnChangeDone = (Button)findViewById(R.id.btn_change_done);
		btnChangeCancel = (Button)findViewById(R.id.btn_change_cancel);
		etTerminalNo = (EditText)findViewById(R.id.et_terminal_no);
		etSiteNo = (EditText)findViewById(R.id.et_site_no);
		etGateway = (EditText)findViewById(R.id.et_gateway);
		etPlatformIP = (EditText)findViewById(R.id.et_platform_IP);
		etPlatformPort = (EditText)findViewById(R.id.et_platform_port);
		/*
		 * Add listener to detect if the
		 * input is legal,and high-light
		 * the EditText to guide user modify 
		 * the error input
		 */
		etTerminalNo.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(hasPreZero(s.toString())){
					Toast preErr = Toast.makeText(ChangeSettingActivity.this,
						     "请输入合法的数字，去掉前导0", Toast.LENGTH_SHORT);
					preErr.setGravity(Gravity.CENTER, 0, 0);
					preErr.show();
					etTerminalNo.setTextColor(Color.RED);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				etTerminalNo.setTextColor(Color.BLUE);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}
			
		});
		etSiteNo.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(hasPreZero(s.toString())){
					Toast preErr = Toast.makeText(ChangeSettingActivity.this,
						     "请输入合法的数字，去掉前导0", Toast.LENGTH_SHORT);
					preErr.setGravity(Gravity.CENTER, 0, 0);
					preErr.show();
					etSiteNo.setTextColor(Color.RED);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				etSiteNo.setTextColor(Color.BLUE);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}
			
		});
		etGateway.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(isIPAddress(s.toString())){
					etGateway.setTextColor(Color.BLUE);
				}else{
					etGateway.setTextColor(Color.RED);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
			}
		});
		etPlatformIP.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(isIPAddress(s.toString())){
					etPlatformIP.setTextColor(Color.BLUE);
				}else{
					etPlatformIP.setTextColor(Color.RED);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}
			
		});
		etPlatformPort.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(hasPreZero(s.toString())){
					Toast preErr = Toast.makeText(ChangeSettingActivity.this,
						     "请输入合法的数字，去掉前导0", Toast.LENGTH_SHORT);
					preErr.setGravity(Gravity.CENTER, 0, 0);
					preErr.show();
					etPlatformPort.setTextColor(Color.RED);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				etPlatformPort.setTextColor(Color.BLUE);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnChangeDone.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * Here to get new data for changing saved settings,
				 * replace new one to SharedPreferences
				 */
				terminalNo = etTerminalNo.getText().toString();
				siteNo = etSiteNo.getText().toString();
				gateway = etGateway.getText().toString();
				platformIP = etPlatformIP.getText().toString();
				platformPort = etPlatformPort.getText().toString();
				
				SharedPreferences preferences = getSharedPreferences(  
				        Global.GLOBALSETTINGS, MODE_PRIVATE);
				Editor editor = preferences.edit();
				/*
				 * Debug info
				 */
				/*
				System.out.println("Old PREFERENCE_TERMINAL_NO is "+preferences.getString(Global.PREFERENCE_TERMINAL_NO, "none"));
				System.out.println("Old PREFERENCE_SITE_NO is "+preferences.getString(Global.PREFERENCE_SITE_NO, "none"));
				System.out.println("Old PREFERENCE_GATEWAY is "+preferences.getString(Global.PREFERENCE_GATEWAY, "none"));
				System.out.println("Old PREFERENCE_PLATFORM_IP is "+preferences.getString(Global.PREFERENCE_PLATFORM_IP, "none"));
				System.out.println("Old PREFERENCE_PLATFORM_PORT is "+preferences.getString(Global.PREFERENCE_PLATFORM_PORT, "none"));
				*/
				if(terminalNo.isEmpty() && siteNo.isEmpty() && gateway.isEmpty()
						&& platformIP.isEmpty() && platformPort.isEmpty()){
					Toast noInput = Toast.makeText(ChangeSettingActivity.this,
						     "请至少输入一个新值", Toast.LENGTH_SHORT);
					noInput.setGravity(Gravity.CENTER, 0, 0);
					noInput.show();
				}else{
					if(!terminalNo.isEmpty()){
						editor.putString(Global.PREFERENCE_TERMINAL_NO, terminalNo); 
						editor.commit(); 
						//System.out.println("New PREFERENCE_TERMINAL_NO is "+preferences.getString(Global.PREFERENCE_TERMINAL_NO, "none"));
					}
					else if(!siteNo.isEmpty()){
						editor.putString(Global.PREFERENCE_SITE_NO, siteNo); 
						editor.commit(); 
						//System.out.println("New PREFERENCE_SITE_NO is "+preferences.getString(Global.PREFERENCE_SITE_NO, "none"));
					}
					else if(!gateway.isEmpty()){
						editor.putString(Global.PREFERENCE_GATEWAY, gateway); 
						editor.commit(); 
						//System.out.println("New PREFERENCE_GATEWAY is "+preferences.getString(Global.PREFERENCE_GATEWAY, "none"));
					}
					else if(!platformIP.isEmpty()){
						editor.putString(Global.PREFERENCE_PLATFORM_IP, platformIP); 
						editor.commit(); 
						//System.out.println("New PREFERENCE_PLATFORM_IP is "+preferences.getString(Global.PREFERENCE_PLATFORM_IP, "none"));
					}
					else if(!platformPort.isEmpty()){
						editor.putString(Global.PREFERENCE_PLATFORM_PORT, platformPort); 
						editor.commit(); 
						//System.out.println("New PREFERENCE_PLATFORM_PORT is "+preferences.getString(Global.PREFERENCE_PLATFORM_PORT, "none"));
					}
					finish();
				}
			}
			
		});
		btnChangeCancel.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Just finish this page
				finish();
			}
			
		});
	}
	/*
	 * Verify if the input gateway and IP area has legal
	 * IP address input
	 */
	public static boolean isIPAddress(String ip){
		Pattern p= Pattern.compile("([0-9]|[0-9]\\d|1\\d{2}|2[0-1]\\d|25[0-5])(\\.(\\d|[0-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");   
		Matcher m = p.matcher(ip);   
		boolean match = m.matches();   
		if(!match){ 
		   return false; 
		}
		return true;
	}
	/*
	 * Verify if the input string has a prefix-zero
	 * in the condition of length >= 2
	 */
	public static boolean hasPreZero(String num){
		if(num.length()>=2 && num.charAt(0)=='0'){
			return true;
		}
		return false;
	}
}
