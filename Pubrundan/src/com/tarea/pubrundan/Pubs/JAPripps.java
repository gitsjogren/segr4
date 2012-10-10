package com.tarea.pubrundan.Pubs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.tarea.pubrundan.R;
import com.tarea.pubrundan.TheMap;

public class JAPripps extends Activity {
	
	
	
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
			case R.id.settings:
				return true;

			case R.id.share:
				return true;
			}
			return false;
		}

}
