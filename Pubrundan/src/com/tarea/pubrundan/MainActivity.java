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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

// TODO: Auto-generated Javadoc
/**
 * This activity starts class TheMap.
 * 
 * @author Erik Sjögren
 * 
 */

public class MainActivity extends Activity implements OnClickListener {

	/** The context. */
	static Context context;

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
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

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mapshow_button:
			Intent i = new Intent(this, TheMap.class);
			startActivity(i);
			break;
		}
	}

}
