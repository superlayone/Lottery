/*
 * Some rights reserved!
 * Author : Layone
 * Mail to superlayone@gmail.com
 */
package com.example.lottery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BuyLotteryTabBarFragment extends Fragment{
	public BuyLotteryTabBarFragment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {     
		View view=inflater.inflate(R.layout.fragment_buy_lottery_tab_bar, container, false);
		return view;
    }
}