package com.example.lottery;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NaviMenuFragment naviMenuFragment = new NaviMenuFragment();
		TabBarFragment tabBarFragment = new TabBarFragment();
		DetailFragment detailFragment = new DetailFragment();
		
		naviMenuFragment.setArguments(getIntent().getExtras());  
        
        // Add the fragment to the 'fragment_container' FrameLayout  
        getSupportFragmentManager().beginTransaction()  
                .add(R.id.naviMenu, naviMenuFragment).commit(); 
        
        tabBarFragment.setArguments(getIntent().getExtras());  
        
        // Add the fragment to the 'fragment_container' FrameLayout  
        getSupportFragmentManager().beginTransaction()  
                .add(R.id.tabBar, tabBarFragment).commit(); 
        
        detailFragment.setArguments(getIntent().getExtras());  
        
        // Add the fragment to the 'fragment_container' FrameLayout  
        getSupportFragmentManager().beginTransaction()  
                .add(R.id.detailArea, detailFragment).commit(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
