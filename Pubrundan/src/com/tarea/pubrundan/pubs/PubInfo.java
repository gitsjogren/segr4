package com.tarea.pubrundan.pubs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PubInfo extends PubLayout {

	// standard onCreate method
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState, getIntent().getIntExtra("Pub layout", -1));

	}

	// Initiating Menu XML file (menu.xml)
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
	// refactor is needed!
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = getIntent();
		String title = intent.getStringExtra("Pub title");
		int moreInfo = intent.getIntExtra("More info", -1);
		int pubNrInArray = intent.getIntExtra("Pub nr in array", -1);
		return super.onOptionsItemSelected(item, title, moreInfo, pubNrInArray);
	}
}
