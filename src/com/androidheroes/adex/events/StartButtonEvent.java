package com.androidheroes.adex.events;

import com.androidheroes.adex.NewMainActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartButtonEvent implements OnClickListener{

	Activity activity;
	
	public StartButtonEvent(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(activity.getApplicationContext(), NewMainActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}

}
