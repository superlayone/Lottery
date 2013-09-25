/*
 * Some rights reserved!
 * Author : Layone
 * Mail to superlayone@gmail.com
 */
package com.example.lottery;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 // Check that the activity is using the layout version with  
        // the fragment_container FrameLayout  
        if (findViewById(R.id.naviMenu) != null &&
        		findViewById(R.id.tabBar) != null &&
        		findViewById(R.id.detailArea) != null) {  
            // However, if we're being restored from a previous state,  
            // then we don't need to do anything and should return or else  
            // we could end up with overlapping fragments.  
            if (savedInstanceState != null) {  
                return;  
            }  
			//Create an instance of xxFragment
			NaviMenuFragment naviMenuFragment = new NaviMenuFragment();
			BuyLotteryTabBarFragment tabBarFragment = new BuyLotteryTabBarFragment();
			BuyLotteryDetailFragment detailFragment = new BuyLotteryDetailFragment();
			// In case this activity was started with special instructions from an Intent,  
	        // pass the Intent's extras to the fragment as arguments 
			naviMenuFragment.setArguments(getIntent().getExtras());  
	        
	        // Add the fragment to the 'fragment_container' FrameLayout  
	        getSupportFragmentManager().beginTransaction()  
	                .add(R.id.naviMenu, naviMenuFragment).commit(); 
	        
	        tabBarFragment.setArguments(getIntent().getExtras());  
	        getSupportFragmentManager().beginTransaction()  
	                .add(R.id.tabBar, tabBarFragment).commit(); 
	        
	        detailFragment.setArguments(getIntent().getExtras());  
	        getSupportFragmentManager().beginTransaction()  
	                .add(R.id.detailArea, detailFragment).commit(); 
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
