/*
 * Some rights reserved!
 * Author 	: 	Layone
 * Date 	: 	2013-09
 * Mail 	: 	superlayone@gmail.com
 */
package activity;

import com.example.lottery.R;
import common.Global;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_setting, menu);
		return true;
	}
	 */
}