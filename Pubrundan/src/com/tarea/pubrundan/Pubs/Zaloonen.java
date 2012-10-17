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

package com.tarea.pubrundan.Pubs;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Zaloonen.
 * 
 * @author Erik Sj�gren
 * 
 */

public class Zaloonen extends Activity {

	// standard onCreate method
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
														// more space
		setContentView(R.layout.zaloonen);

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.more_pubinfo:
			new AlertDialog.Builder(this).setTitle("J.A. Pripps")
					.setMessage(R.string.ja_pripps_info)
					.create().show();
		case R.id.find_pub:
			return true;

		case R.id.show_pub_on_map:
			Intent i = new Intent(this,TheMap.class);
			i.putExtra("Pub","Zaloonen");
			i.putExtra("Pub to animate to in array list", 4);
            startActivity(i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			return true;
		}
		return false;
	}

}