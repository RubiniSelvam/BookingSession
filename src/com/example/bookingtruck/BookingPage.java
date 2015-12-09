package com.example.bookingtruck;
 

import com.example.bookingtruc.adapter.TabsPagerAdapter;
import com.example.bookingtruck.R;


 
 

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
 
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class BookingPage extends FragmentActivity implements ActionBar.TabListener {
	  
	 private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    private ActionBar actionBar;
	    // Tab titles
	    private String[] tabs = { "BookNow", "BookLater"};
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingpage);
        // Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
			actionBar.setSelectedNavigationItem(position);	
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		}); 
 	 
	}
	

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
	    viewPager.setCurrentItem(tab.getPosition());// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onPageScrollStateChanged(int arg0,float arg1) {
		// TODO Auto-generated method stub
		
	}

	
 
}