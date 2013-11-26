package com.androidheroes.adex;

import com.androidheroes.adex.adapters.ImageSliderAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class MainActivity extends Activity {

	ViewPager slider; 
	ImageSliderAdapter sliderAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*
         *	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
         */
        
        setContentView(R.layout.activity_main);
        
        slider = (ViewPager) findViewById(R.id.pager);
        sliderAdapter = new ImageSliderAdapter(this);
        
        slider.setAdapter(sliderAdapter);
        slider.setCurrentItem(0);
    }
}
