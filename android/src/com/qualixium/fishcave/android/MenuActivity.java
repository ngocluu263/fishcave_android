package com.qualixium.fishcave.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		
	}
	
	public void rateApp(View view) {
		startActivity(new Intent(Intent.ACTION_VIEW, 
                        Uri.parse("https://play.google.com/store/apps/details?id=com.qualixium.fishcave.android")));
	}
}
