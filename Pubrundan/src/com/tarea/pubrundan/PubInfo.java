package com.tarea.pubrundan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

public class PubInfo extends Activity {
	
	// standard onCreate method
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
															// more space
			setContentView(R.layout.pubinfo);
		
	}
		
		// Initiating Menu XML file (menu.xml)
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			MenuInflater oMenu = getMenuInflater();
			oMenu.inflate(R.menu.pubmenu, menu);
			return true;
		}

}
