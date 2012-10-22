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

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
 
public class PubList extends ListActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
 
    	// storing string resources into Array
        String[] pubs = getResources().getStringArray(R.array.pubs);
 
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, pubs));
 
        ListView lv = getListView();
 
        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
        	  switch (position) {

      		case 0:		// Start J.A. Pripps activity
      			Intent jaPripps = new Intent(getApplicationContext(), PubLayout.class);
      			jaPripps.putExtra("Pub layout", R.layout.japripps);
      			jaPripps.putExtra("Pub title", "J.A. Pripps");
      			jaPripps.putExtra("More info", R.string.ja_pripps_info);
      			jaPripps.putExtra("Pub nr in array", position);
      			startActivity(jaPripps);
      			break;
      		case 1:		// Start Gasquen activity
      			Intent gasquen = new Intent(getApplicationContext(), PubLayout.class);
      			gasquen.putExtra("Pub layout", R.layout.gasquen);
      			gasquen.putExtra("Pub title", "Gasquen");
      			gasquen.putExtra("More info", R.string.ja_pripps_info);
      			gasquen.putExtra("Pub nr in array", position);
      			startActivity(gasquen);
      			break;
      		case 2:		// Start Bulten activity
      			Intent bulten = new Intent(getApplicationContext(), PubLayout.class);
      			bulten.putExtra("Pub layout", R.layout.bulten);
      			bulten.putExtra("Pub title", "Bulten");
      			bulten.putExtra("More info", R.string.ja_pripps_info);
      			bulten.putExtra("Pub nr in array", position);
      			startActivity(bulten);
      			break;
      		case 3:		// Start Winden activity
      			Intent winden = new Intent(getApplicationContext(), PubLayout.class);
      			winden.putExtra("Pub layout", R.layout.winden);
      			winden.putExtra("Pub title", "Winden");
      			winden.putExtra("More info", R.string.ja_pripps_info);
      			winden.putExtra("Pub nr in array", position);
      			startActivity(winden);
      			break;
      		case 4:		// Start Zaloonen Pripps activity
    			Intent zaloonen = new Intent(getApplicationContext(), PubLayout.class);
    			zaloonen.putExtra("Pub layout", R.layout.zaloonen);
    			zaloonen.putExtra("Pub title", "Zaloonen");
    			zaloonen.putExtra("More info", R.string.ja_pripps_info);
    			zaloonen.putExtra("Pub nr in array", position);
    			startActivity(zaloonen);
    			break;
    		case 5:		// Start Club Avancez activity
    			Intent clubAvancez = new Intent(getApplicationContext(), PubLayout.class);
    			clubAvancez.putExtra("Pub layout", R.layout.clubavancez);
    			clubAvancez.putExtra("Pub title", "Club Avancez");
    			clubAvancez.putExtra("More info", R.string.ja_pripps_info);
    			clubAvancez.putExtra("Pub nr in array", position);
    			startActivity(clubAvancez);
    			break;
    		case 6:		// Start GoldenI activity
    			Intent goldenI = new Intent(getApplicationContext(), PubLayout.class);
    			goldenI.putExtra("Pub layout", R.layout.goldeni);
    			goldenI.putExtra("Pub title", "GoldenI");
    			goldenI.putExtra("More info", R.string.ja_pripps_info);
    			goldenI.putExtra("Pub nr in array", position);
    			startActivity(goldenI);
    			break;
    		case 7:		// Start Hubben 2.1 activity
    			Intent hubben = new Intent(getApplicationContext(), PubLayout.class);
    			hubben.putExtra("Pub layout", R.layout.hubben);
    			hubben.putExtra("Pub title", "Hubben 2.1");
    			hubben.putExtra("More info", R.string.ja_pripps_info);
    			hubben.putExtra("Pub nr in array", position);
    			startActivity(hubben);
    			break;
    		case 8:		// Start Basen activity
    			Intent basen = new Intent(getApplicationContext(), PubLayout.class);
    			basen.putExtra("Pub layout", R.layout.basen);
    			basen.putExtra("Pub title", "Basen");
    			basen.putExtra("More info", R.string.ja_pripps_info);
    			basen.putExtra("Pub nr in array", position);
    			startActivity(basen);
    			break;
    		case 9:		// Start Kajsabaren activity
    			Intent kajsaBaren = new Intent(getApplicationContext(), PubLayout.class);
    			kajsaBaren.putExtra("Pub layout", R.layout.kajsabaren);
    			kajsaBaren.putExtra("Pub title", "Kajsabaren");
    			kajsaBaren.putExtra("More info", R.string.ja_pripps_info);
    			kajsaBaren.putExtra("Pub nr in array", position);
    			startActivity(kajsaBaren);
    			break;
    		case 10:	// Start Järnvägspub activity
    			Intent jarnvagsPub = new Intent(getApplicationContext(), PubLayout.class);
    			jarnvagsPub.putExtra("Pub layout", R.layout.jarnvagspub);
    			jarnvagsPub.putExtra("Pub title", "Järnvägspub");
    			jarnvagsPub.putExtra("More info", R.string.ja_pripps_info);
    			jarnvagsPub.putExtra("Pub nr in array", position);
    			startActivity(jarnvagsPub);
    			break;
    		case 11:	// Start GasTown activity
    			Intent gasTown = new Intent(getApplicationContext(), PubLayout.class);
    			gasTown.putExtra("Pub layout", R.layout.gastown);
    			gasTown.putExtra("Pub title", "GasTown");
    			gasTown.putExtra("More info", R.string.ja_pripps_info);
    			gasTown.putExtra("Pub nr in array", position);
    			startActivity(gasTown);
    			break;
    		case 12:	// Start FortNOx activity
    			Intent fortNox = new Intent(getApplicationContext(), PubLayout.class);
    			fortNox.putExtra("Pub layout", R.layout.fortnox);
    			fortNox.putExtra("Pub title", "FortNOx");
    			fortNox.putExtra("More info", R.string.ja_pripps_info);
    			fortNox.putExtra("Pub nr in array", position);
    			startActivity(fortNox);
    			break;
    		case 13:	// Start Spritköket activity
    			Intent spritkoket = new Intent(getApplicationContext(), PubLayout.class);
    			spritkoket.putExtra("Pub layout", R.layout.spritkoket);
    			spritkoket.putExtra("Pub title", "Spritköket");
    			spritkoket.putExtra("More info", R.string.ja_pripps_info);
    			spritkoket.putExtra("Pub nr in array", position);
    			startActivity(spritkoket);
    			break;
    		case 14:	// Start Focus activity
    			Intent focus = new Intent(getApplicationContext(), PubLayout.class);
    			focus.putExtra("Pub layout", R.layout.focus);
    			focus.putExtra("Pub title", "Focus");
    			focus.putExtra("More info", R.string.ja_pripps_info);
    			focus.putExtra("Pub nr in array", position);
    			startActivity(focus);
    			break;
    		case 15:	// Start Röda rummet activity
    			Intent rodaRummet = new Intent(getApplicationContext(), PubLayout.class);
    			rodaRummet.putExtra("Pub layout", R.layout.rodarummet);
    			rodaRummet.putExtra("Pub title", "Röda rummet");
    			rodaRummet.putExtra("More info", R.string.ja_pripps_info);
    			rodaRummet.putExtra("Pub nr in array", position);
    			startActivity(rodaRummet);
    			break;
    		case 16:	// Start Sigurd/A-fiket activity
    			Intent sigurdAfiket = new Intent(getApplicationContext(), PubLayout.class);
    			sigurdAfiket.putExtra("Pub layout", R.layout.sigurdafiket);
    			sigurdAfiket.putExtra("Pub title", "Sigurd/A-fiket");
    			sigurdAfiket.putExtra("More info", R.string.ja_pripps_info);
    			sigurdAfiket.putExtra("Pub nr in array", position);
    			startActivity(sigurdAfiket);
    			break;
    		case 17:	// Start Pub P activity
    			Intent pubP = new Intent(getApplicationContext(), PubLayout.class);
    			pubP.putExtra("Pub layout", R.layout.pubp);
    			pubP.putExtra("Pub title", "Pub P");
    			pubP.putExtra("More info", R.string.ja_pripps_info);
    			pubP.putExtra("Pub nr in array", position);
    			startActivity(pubP);
    			break;
    		case 18:	// Start 11:an activity
    			Intent pubF = new Intent(getApplicationContext(), PubLayout.class);
    			pubF.putExtra("Pub layout", R.layout.pubf);
    			pubF.putExtra("Pub title", "Pub F");
    			pubF.putExtra("More info", R.string.ja_pripps_info);
    			pubF.putExtra("Pub nr in array", position);
    			startActivity(pubF);
    			break;
          }
          }
        });
    }
}


//Intent jaPripps = new Intent(mContext, PubLayout.class);
//jaPripps.putExtra("Pub layout", R.layout.japripps);
//jaPripps.putExtra("Pub title", "J.A. Pripps");
//jaPripps.putExtra("More info", R.string.ja_pripps_info);
//jaPripps.putExtra("Pub nr in array", 0);
//mContext.startActivity(jaPripps);