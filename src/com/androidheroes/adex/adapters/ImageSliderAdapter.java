package com.androidheroes.adex.adapters;

import java.util.Date;

import com.androidheroes.adex.R;
import com.androidheroes.adex.events.StartButtonEvent;
import com.androidheroes.adex.timer.MyTimer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageSliderAdapter extends PagerAdapter{

	Activity activity;
	View objectToReturn;
	int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};
	Typeface tf, tfLight, tfBold;
	Date startDay;
	MyTimer time;
	
	public ImageSliderAdapter(Activity activity) {
		this.activity = activity;
		tf = Typeface.createFromAsset(activity.getAssets(), "fonts/OpenSans-Regular.ttf");
		tfLight = Typeface.createFromAsset(activity.getAssets(), "fonts/OpenSans-Light.ttf");
		tfBold = Typeface.createFromAsset(activity.getAssets(), "fonts/OpenSans-Bold.ttf");
		startDay = new Date(113, 11, 11, 10, 0);
		time = new MyTimer(startDay.getTime() - System.currentTimeMillis() , 1000);
	}
	
	@Override
	public int getCount() {
		return images.length + 2;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public void finishUpdate(ViewGroup container) {	
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		Log.i("position", "" + position);
		LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(position == 0){
			objectToReturn = inflater.inflate(R.layout.first_slide, null);
			TextView logo_name = (TextView) objectToReturn.findViewById(R.id.logo_name);
			TextView call_to_action = (TextView) objectToReturn.findViewById(R.id.call_to_action);
			
			call_to_action.setTypeface(tfLight);
			logo_name.setTypeface(tf);
		}else if(position == 7){
			objectToReturn = inflater.inflate(R.layout.last_slide, null);

			LinearLayout ll = (LinearLayout) objectToReturn.findViewById(R.id.count_down_field);
			
			Button startButton = (Button) objectToReturn.findViewById(R.id.startButton); 
			
			TextView days = (TextView) objectToReturn.findViewById(R.id.days);
			TextView hours = (TextView) objectToReturn.findViewById(R.id.hours);
			TextView minutes = (TextView) objectToReturn.findViewById(R.id.minutes);
			TextView seconds = (TextView) objectToReturn.findViewById(R.id.seconds);
			
			TextView daysTitle = (TextView) objectToReturn.findViewById(R.id.days_title);
			TextView hoursTitle = (TextView) objectToReturn.findViewById(R.id.hours_title);
			TextView minutesTitle = (TextView) objectToReturn.findViewById(R.id.minutes_title);
			TextView secondsTitle = (TextView) objectToReturn.findViewById(R.id.seconds_title);
			
			TextView logo_name = (TextView) objectToReturn.findViewById(R.id.logo_name_in_last_slider);
			TextView remainingTime = (TextView) objectToReturn.findViewById(R.id.remaining_time);
			
			startButton.setOnClickListener(new StartButtonEvent(activity));
			startButton.setTypeface(tfBold);
			
			remainingTime.setTypeface(tfLight);
			
			logo_name.setText(logo_name.getText());
			logo_name.setTypeface(tfBold);
			
			daysTitle.setTypeface(tfLight);
			hoursTitle.setTypeface(tfLight);
			minutesTitle.setTypeface(tfLight);
			secondsTitle.setTypeface(tfLight);
			
			days.setTypeface(tf);
			hours.setTypeface(tf);
			minutes.setTypeface(tf);
			seconds.setTypeface(tf);
			
			time.setViews(new TextView[]{days, hours, minutes, seconds}, ll, startButton, remainingTime);
			time.start();
			
		}else{
			objectToReturn = inflater.inflate(R.layout.image_in_slider, null);
			
			ImageView image = (ImageView) objectToReturn.findViewById(R.id.image_in_slider);
			TextView description = (TextView) objectToReturn.findViewById(R.id.text_over_image);
			
			image.setImageResource(images[position-1]);
			
			switch (position-1) {
			case 0:
				description.setText(R.string.text_for_image_1);
				break;
			case 1:
				description.setText(R.string.text_for_image_2);
				break;
			case 2:
				description.setText(R.string.text_for_image_3);
				break;
			case 3:
				description.setText(R.string.text_for_image_4);
				break;
			case 4:
				description.setText(R.string.text_for_image_5);
				break;
			case 5:
				description.setText(R.string.text_for_image_6);
				break;
			default:
				break;
			}
			description.setTypeface(tf);
		}
		
		container.addView(objectToReturn);
		
		return objectToReturn;
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(ViewGroup container) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {

		return view == (View) object;
	}

}
