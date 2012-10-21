/* ============================================================
 * Copyright � 2012 Adam Book, Rickard Edfast, Erik Sj�gren,
 * Alexander Kurkim�ki
 *
 * This file is part of Pubrundan.
 *
 * Pubrundan is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pubrundan is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Pubrundan. If not, see <http://www.gnu.org/licenses/>.
 * ============================================================ */


package com.tarea.pubrundan.pubs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;
// TODO: Auto-generated Javadoc
/**
 * The Class JAPripps.
 * 
 * @author Erik Sj�gren
 * 
 */
public class JAPripps extends Activity {
	
	private TheMap tm;
	private LocationManager lm;
	
	// standard onCreate method
		/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
															// more space
			setContentView(R.layout.japripps);
		
	}
		
		// Initiating Menu XML file (menu.xml)
		/* (non-Javadoc)
		 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
		 */
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			MenuInflater oMenu = getMenuInflater();
			oMenu.inflate(R.menu.pubmenu, menu);
			return true;
		}
		
		// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
		// refactor is needed!
		/* (non-Javadoc)
		 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
		 */

		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case R.id.more_pubinfo:
				new AlertDialog.Builder(this).setTitle("J.A. Pripps")
						.setMessage(R.string.ja_pripps_info)
						.create().show();
			case R.id.find_pub:
//				lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
//				Location myLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//				String destLat = null;
//				String destLon = null;
//				String uri = "http://maps.google.com/maps?saddr=" + (myLocation.getLatitude())+","+(myLocation.getLongitude())+"&daddr="+destLat+","+destLon;
//
//				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
//
//				intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
//				startActivity(intent);
				Intent e = new Intent(this,TheMap.class);
				e.putExtra("Pub","J.A. Pripps");
				e.putExtra("Pub to animate to in array list", 6);
                startActivity(e.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
				return true;

			case R.id.show_pub_on_map:
//				Intent i = new Intent(this,TheMap.class);
//				i.putExtra("Pub","J.A. Pripps");
//				i.putExtra("Pub to animate to in array list", 0);
//                startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
				return true;
			}
			return false;
		}

}
