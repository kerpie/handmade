package com.androidheroes.adex.timer;

import java.util.concurrent.TimeUnit;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyTimer extends CountDownTimer{

	TextView countDown, days, hours, minutes, seconds, remainingTimeMessage;
	LinearLayout container;
	Button button;
	int type;
	
	public MyTimer(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		
	}
	
	public MyTimer(long millisInFuture, long countDownInterval, TextView message, int type){
		super(millisInFuture, countDownInterval);
		countDown = message;
		this.type = type;
	}
	
	public void setViews(TextView array[], LinearLayout container, Button startButton, TextView remainingTimeMessage){
		days = array[0];
		hours = array[1];
		minutes = array[2];
		seconds = array[3];
		this.container = container;
		button = startButton;
		this.remainingTimeMessage = remainingTimeMessage;
	}

	@Override
	public void onFinish() {
		container.setVisibility(View.GONE);
		remainingTimeMessage.setVisibility(View.GONE);
		button.setVisibility(View.VISIBLE);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		days.setText(String.valueOf(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)));
		hours.setText(String.valueOf(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)%24));
		minutes.setText(String.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)%60));
		seconds.setText(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)%60));
	}
}