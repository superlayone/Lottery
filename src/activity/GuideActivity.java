/*
 * Some rights reserved!
 * Guide page for displaying key features!
 * Author : Layone
 * Mail to superlayone@gmail.com
 */
package activity;

import java.util.ArrayList;

import com.example.lottery.R;
 
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
 
public class GuideActivity extends Activity {
    private ViewPager viewPager;
    private ArrayList<View> pageViews;    
    private ImageView imageView;
    //Dots
    private ImageView[] imageViews;
     
    //Pictures LinearLayout
    private ViewGroup viewPics;

    private ViewGroup viewPoints;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        pageViews = new ArrayList<View>();
        /*
         * Inflater view from layout file 
         */
        pageViews.add(inflater.inflate(R.layout.guide_page1, null));
        pageViews.add(inflater.inflate(R.layout.guide_page2, null));
        pageViews.add(inflater.inflate(R.layout.guide_page3, null));
        pageViews.add(inflater.inflate(R.layout.guide_page4, null));
        
        imageViews = new ImageView[pageViews.size()];
        viewPics = (ViewGroup) inflater.inflate(R.layout.activity_guide, null);
         
        viewPoints = (ViewGroup) viewPics.findViewById(R.id.viewGroup);
        viewPager = (ViewPager) viewPics.findViewById(R.id.guidePages);
         
        for(int i=0;i<pageViews.size();i++){
            imageView = new ImageView(GuideActivity.this);
            //Dots layout
            imageView.setLayoutParams(new LayoutParams(30,30));
            imageView.setPadding(30, 0, 30, 0);
            imageViews[i] = imageView;
            if(i==0){
                imageViews[i].setBackgroundResource(R.drawable.dot_selected);
            }else{
                imageViews[i].setBackgroundResource(R.drawable.dot);
            }
            //Set to view
            viewPoints.addView(imageViews[i]);
        }
         
        setContentView(viewPics);
         
        viewPager.setAdapter(new GuidePageAdapter());
        viewPager.setOnPageChangeListener(new GuidePageChangeListener());        
    }
     
    private Button.OnClickListener  Button_OnClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
        	//isFirstIn set to false
            setGuided();
            //Go to select page
            Intent mIntent = new Intent();
            mIntent.setClass(GuideActivity.this, SelectActivity.class);
            GuideActivity.this.startActivity(mIntent);
            //Destroy GuideActivity
            GuideActivity.this.finish();
        }
    }; 
    //Change status 
    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    private void setGuided(){
    	SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
    	Editor editor = preferences.edit(); 
    	editor.putBoolean("isFirstIn", false); 
    	editor.commit();  
    }
     
     
    class GuidePageAdapter extends PagerAdapter{
    	//Destroy
        @Override
        public void destroyItem(View v, int position, Object arg2) {
            // TODO Auto-generated method stub
            ((ViewPager)v).removeView(pageViews.get(position));
             
        }
        @Override
        public void finishUpdate(View arg0) {
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return pageViews.size();
        }
        @Override
        public Object instantiateItem(View v, int position) {
            // TODO Auto-generated method stub
            ((ViewPager) v).addView(pageViews.get(position));  
            if (position == 3) {  
                Button btn = (Button) v.findViewById(R.id.btn_close_guide);  
                btn.setOnClickListener(Button_OnClickListener);  
            }  
            return pageViews.get(position);  
        }
        @Override
        public boolean isViewFromObject(View v, Object arg1) {
            return v == arg1;
        }
        @Override
        public void startUpdate(View arg0) {
        }
 
        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }
 
        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub
        }
 
        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }
    }
     
     
    class GuidePageChangeListener implements OnPageChangeListener{
 
        
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub   
        }
 
      
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub   
        }
 
       
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            for(int i=0;i<imageViews.length;i++){
                imageViews[position].setBackgroundResource(R.drawable.dot_selected);
                if(position !=i){
                    imageViews[i].setBackgroundResource(R.drawable.dot);
                }
            }
             
        }
    }   
 }
