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

package com.tarea.pubrundan.pubs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;

/**
 * The Class PubLayout.
 * 
 * @author Erik Sjögren
 * 
 */

public class PubLayout extends Activity {
	
	public void onCreate(Bundle savedInstanceState, int layoutResID) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
														// more space
		setContentView(layoutResID);
	
}
	
	// Initiating Menu XML file (menu.xml)
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */

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
	public boolean onOptionsItemSelected(MenuItem item, String title, int messageID, int number) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.more_pubinfo:
			new AlertDialog.Builder(this).setTitle(title)
					.setMessage(messageID)
					.create().show();
			return true;
		case R.id.find_pub:
			Intent e = new Intent(this,TheMap.class);
			e.putExtra("Route",title);
			e.putExtra("Pub to draw route to", number);
            startActivity(e.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			return true;

		case R.id.show_pub_on_map:
			Intent i = new Intent(this,TheMap.class);
			i.putExtra("Show",title);
			i.putExtra("Pub to animate to", number);
            startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			return true;
		}
		return false;
	}

}
