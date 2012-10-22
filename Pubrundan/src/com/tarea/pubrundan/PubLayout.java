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

package com.tarea.pubrundan;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD:Pubrundan/src/com/tarea/pubrundan/Pubs/Zaloonen.java
import android.view.MenuItem;
import android.view.Window;

import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;


=======
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

<<<<<<< HEAD
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb:Pubrundan/src/com/tarea/pubrundan/PubLayout.java
// TODO: Auto-generated Javadoc
=======
>>>>>>> 394121e74c5a21d07bd01f89db0595e1323f526f
/**
 * The Class PubLayout.
 * 
 * @author Erik Sjögren
 * 
 */
<<<<<<< HEAD:Pubrundan/src/com/tarea/pubrundan/Pubs/Zaloonen.java

public class Zaloonen extends Activity {
=======
public class PubLayout extends Activity {
	
	private final int defaultIntValue = -1;
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb:Pubrundan/src/com/tarea/pubrundan/PubLayout.java

	// standard onCreate method
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	public void onCreate(Bundle savedInstanceState) {

		requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
														// more space
		super.onCreate(savedInstanceState);
		
		setContentView(getIntent().getIntExtra("Pub layout", defaultIntValue));
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.more_pubinfo:
			new AlertDialog.Builder(this).setTitle("J.A. Pripps")
					.setMessage(R.string.ja_pripps_info)
					.create().show();
		case R.id.find_pub:
			return true;

<<<<<<< HEAD:Pubrundan/src/com/tarea/pubrundan/Pubs/Zaloonen.java
		case R.id.show_pub_on_map:
			Intent i = new Intent(this,TheMap.class);
			i.putExtra("Pub","Zaloonen");
			i.putExtra("Pub to animate to in array list", 4);
            startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			return true;
		}
		return false;
=======
	// Initiating Menu XML file (menu.xml)
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater oMenu = getMenuInflater();
		oMenu.inflate(R.menu.pubmenu, menu);
		return true;
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb:Pubrundan/src/com/tarea/pubrundan/PubLayout.java
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */

	public boolean onOptionsItemSelected(MenuItem item) {
		Intent e = getIntent();
		String title = e.getStringExtra("Pub title");
		int moreInfo = e.getIntExtra("More info", defaultIntValue);
		int pubNrInArray = e.getIntExtra("Pub nr in array", defaultIntValue);
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.more_pubinfo:
			new AlertDialog.Builder(this).setTitle(title)
					.setMessage(moreInfo)
					.create().show();
			break;
		case R.id.find_pub:
			Intent a = new Intent(this,TheMap.class);
			a.putExtra("Route",title);
			a.putExtra("Pub to draw route to", pubNrInArray);
            startActivity(a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            break;

		case R.id.show_pub_on_map:
			Intent i = new Intent(this,TheMap.class);
			i.putExtra("Show",title);
			i.putExtra("Pub to animate to", pubNrInArray);
            startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            break;
		}
		return true;
	}

}
