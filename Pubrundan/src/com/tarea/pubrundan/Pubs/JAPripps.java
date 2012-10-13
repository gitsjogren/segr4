/* ============================================================
 * Copyright © 2012 Adam Book, Rickard Edfast, Erik Sjögren,
 * Alexander Kurkimäki
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

<<<<<<< HEAD
package com.tarea.pubrundan.Pubs;

import android.app.Activity;
import android.app.AlertDialog;
=======
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
>>>>>>> origin/pubinfo
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import com.tarea.pubrundan.R;
<<<<<<< HEAD

// TODO: Auto-generated Javadoc
/**
 * The Class JAPripps.
 * 
 * @author Erik Sjögren
 * 
 */
=======
import com.tarea.pubrundan.TheMap;

>>>>>>> origin/pubinfo
public class JAPripps extends Activity {
	
	private TheMap tm;
	
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
		
<<<<<<< HEAD
		// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
		// refactor is needed!
		/* (non-Javadoc)
		 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
		 */
=======
>>>>>>> origin/pubinfo
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case R.id.more_pubinfo:
				new AlertDialog.Builder(this).setTitle("J.A. Pripps")
<<<<<<< HEAD
						.setMessage(R.string.ja_pripps_info)
						.create().show();
			case R.id.settings:
				return true;

			case R.id.share:
=======
						.setMessage(R.string.ja_pripps_more_info)
						.create().show();
			case R.id.find_pub:
				return true;

			case R.id.show_pub_on_map:
				//OverlayItem oi = tm.allPubsArray[0];
				//GeoPoint gp = oi.getPoint();
				//String send = gp.toString();
				Intent i = new Intent(getBaseContext(),TheMap.class);
				//i.putExtra("key", "value");
                getApplicationContext().startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
>>>>>>> origin/pubinfo
				return true;
			}
			return false;
		}

}
