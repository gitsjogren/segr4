package com.tarea.pubrundan.Pubs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;

public class JAPripps extends Activity {
	
	private TheMap tm;
	
	// standard onCreate method
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
															// more space
			setContentView(R.layout.japripps);
		
	}
		
		// Initiating Menu XML file (menu.xml)
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			MenuInflater oMenu = getMenuInflater();
			oMenu.inflate(R.menu.pubmenu, menu);
			return true;
		}
		
		// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
		// refactor is needed!
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case R.id.more_pubinfo:
				new AlertDialog.Builder(this).setTitle("J.A. Pripps")
						.setMessage(R.string.ja_pripps_info)
						.create().show();
			case R.id.find_pub:
				return true;

			case R.id.show_pub_on_map:
				OverlayItem oi = tm.allPubsArray[0];
				GeoPoint gp = oi.getPoint();
				tm.animateToGeopoint(gp,19);
				return true;
			}
			return false;
		}

}
