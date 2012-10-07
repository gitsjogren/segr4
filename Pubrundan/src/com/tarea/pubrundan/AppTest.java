package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class AppTest extends Activity implements OnClickListener {

	static Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Get application context for later use
		context = getApplicationContext();

		// Add ClickListener for the button
		View firstButton = findViewById(R.id.mapshow_button);
		firstButton.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mapshow_button:
			Intent i = new Intent(this, TheMap.class);
			startActivity(i);
			break;
		}
	}

}
