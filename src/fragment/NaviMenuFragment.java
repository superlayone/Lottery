/*
 * Some rights reserved!
 * Author 	: 	Layone
 * Date 	: 	2013-09
 * Mail 	: 	superlayone@gmail.com
 */
package fragment;

import com.example.lottery.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class NaviMenuFragment extends Fragment{
	public NaviMenuFragment() {
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
		View view=inflater.inflate(R.layout.fragment_navi_menu, container, false);
		//Find navigation menu list's RadioGroup
		RadioGroup group = (RadioGroup)view.findViewById(R.id.rg_navi_menu);
		//Set a listener to detect tab switch
		group.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				//System.out.println("Touched "+Integer.toHexString(arg0.getCheckedRadioButtonId()));
				switch(arg0.getCheckedRadioButtonId()){
					//rb_navi_lottery_info
					case R.id.rb_navi_lottery_info:
						LotteryInfoTabBarFragment lotteryInfoTabBarFragment = new LotteryInfoTabBarFragment();
						LotteryInfoDetailFragment lotteryInfoDetailFragment = new LotteryInfoDetailFragment();
						//Do replace old tab with wanted
						lotteryInfoTabBarFragment.setArguments(getActivity().getIntent().getExtras());  
						getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.tabBar, lotteryInfoTabBarFragment).commit(); 
						//Do replace old detail with wanted
						lotteryInfoDetailFragment.setArguments(getActivity().getIntent().getExtras());  
				        getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.detailArea, lotteryInfoDetailFragment).commit();
				        //Crucial
						break;
					case R.id.rb_navi_buy_lottery:
						BuyLotteryTabBarFragment buyLotteryTabBarFragment = new BuyLotteryTabBarFragment();
						BuyLotteryDetailFragment buyLotteryDetailFragment = new BuyLotteryDetailFragment();
						
						buyLotteryTabBarFragment.setArguments(getActivity().getIntent().getExtras());  
						getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.tabBar, buyLotteryTabBarFragment).commit(); 
						buyLotteryDetailFragment.setArguments(getActivity().getIntent().getExtras());  
				        getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.detailArea, buyLotteryDetailFragment).commit();
						break;
					case R.id.rb_navi_release_winning_info:
						ReleaseWiningInfoTabBarFragment releaseWiningInfoTabBarFragment = new ReleaseWiningInfoTabBarFragment();
						ReleaseWiningInfoDetailFragment releaseWiningInfoDetailFragment = new ReleaseWiningInfoDetailFragment();
						
						releaseWiningInfoTabBarFragment.setArguments(getActivity().getIntent().getExtras());  
						getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.tabBar, releaseWiningInfoTabBarFragment).commit(); 
						releaseWiningInfoDetailFragment.setArguments(getActivity().getIntent().getExtras());  
				        getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.detailArea, releaseWiningInfoDetailFragment).commit();
						break;
					case R.id.rb_navi_my_lottery:
						MyLotteryTabBarFragment myLotteryTabBarFragment = new MyLotteryTabBarFragment();
						MyLotteryDetailFragment myLotteryDetailFragment = new MyLotteryDetailFragment();
						
						myLotteryTabBarFragment.setArguments(getActivity().getIntent().getExtras());  
						getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.tabBar, myLotteryTabBarFragment).commit(); 
						myLotteryDetailFragment.setArguments(getActivity().getIntent().getExtras());  
				        getActivity().getSupportFragmentManager().beginTransaction()  
				                .replace(R.id.detailArea, myLotteryDetailFragment).commit();
						break;
					default:
			        	break;
				}
			}
			
		});
		return view;
    }
}
