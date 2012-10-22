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

package com.tarea.pubrundan;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

/**
 * The class OverlayClass
 * 
 * @author Erik Sj�gren
 * 
 */
public class OverlayClass extends ItemizedOverlay<OverlayItem> {
	
	/** The my overlays. */
	public ArrayList<OverlayItem> myOverlays;
	
	/** The m context. */
	private Context mContext;
	
	/** The count. */
	private static int count = 0;
	
	/** The counter. */
	private ArrayList<Integer> counter = new ArrayList<Integer>();

	/**
	 * Instantiates a new overlay class.
	 *
	 * @param defaultMarker the default marker
	 * @param context the context
	 */
	public OverlayClass(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		mContext = context;
	}

	/**
	 * Adds the overlay.
	 *
	 * @param overlay the overlay
	 */
	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		counter.add(count);
		count++;
	}

	/**
	 * Populate fix.
	 * Needed to access populate() from class TheMap
	 */
	public void populateFix(){
		populate();
	}

	/** (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#createItem(int)
	 * @param i
	 * 
	 * @return, OverlayItem i
	 */
	@Override
	protected OverlayItem createItem(int i) {
		return myOverlays.get(i);
	}

	/**
	 * Removes overlay item i.
	 *
	 * @param i the i
	 */
	public void removeItem(int i) {
		myOverlays.remove(i);
		populate();
	}

	/** (non-Javadoc)
	 * Handle tap events on overlay icons
	 * Start each pub as own class with xml
	 * @see com.google.android.maps.ItemizedOverlay#onTap(int)
	 * 
	 * @param i
	 * 
	 * @return, true if successful
	 */
	@Override
	protected boolean onTap(int i) {
		switch (counter.get(i)) {

		case 0:		// Start J.A. Pripps activity
			Intent jaPripps = new Intent(mContext, PubLayout.class);
			jaPripps.putExtra("Pub layout", R.layout.japripps);
			jaPripps.putExtra("Pub title", myOverlays.get(i).getTitle());
			jaPripps.putExtra("More info", R.string.ja_pripps_info);
			jaPripps.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(jaPripps);
			break;
		case 1:		// Start Gasquen activity
			Intent gasquen = new Intent(mContext, PubLayout.class);
			gasquen.putExtra("Pub layout", R.layout.gasquen);
			gasquen.putExtra("Pub title", myOverlays.get(i).getTitle());
			gasquen.putExtra("More info", R.string.ja_pripps_info);
			gasquen.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(gasquen);
			break;
		case 2:		// Start Bulten activity
			Intent bulten = new Intent(mContext, PubLayout.class);
			bulten.putExtra("Pub layout", R.layout.bulten);
			bulten.putExtra("Pub title", myOverlays.get(i).getTitle());
			bulten.putExtra("More info", R.string.ja_pripps_info);
			bulten.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(bulten);
			break;
		case 3:		// Start Winden activity
			Intent winden = new Intent(mContext, PubLayout.class);
			winden.putExtra("Pub layout", R.layout.winden);
			winden.putExtra("Pub title", myOverlays.get(i).getTitle());
			winden.putExtra("More info", R.string.ja_pripps_info);
			winden.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(winden);
			break;
		case 4:		// Start Zaloonen Pripps activity
			Intent zaloonen = new Intent(mContext, PubLayout.class);
			zaloonen.putExtra("Pub layout", R.layout.zaloonen);
			zaloonen.putExtra("Pub title", myOverlays.get(i).getTitle());
			zaloonen.putExtra("More info", R.string.ja_pripps_info);
			zaloonen.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(zaloonen);
			break;
		case 5:		// Start Club Avancez activity
			Intent clubAvancez = new Intent(mContext, PubLayout.class);
			clubAvancez.putExtra("Pub layout", R.layout.clubavancez);
			clubAvancez.putExtra("Pub title", myOverlays.get(i).getTitle());
			clubAvancez.putExtra("More info", R.string.ja_pripps_info);
			clubAvancez.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(clubAvancez);
			break;
		case 6:		// Start GoldenI activity
			Intent goldenI = new Intent(mContext, PubLayout.class);
			goldenI.putExtra("Pub layout", R.layout.goldeni);
			goldenI.putExtra("Pub title", myOverlays.get(i).getTitle());
			goldenI.putExtra("More info", R.string.ja_pripps_info);
			goldenI.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(goldenI);
			break;
		case 7:		// Start Hubben 2.1 activity
			Intent hubben = new Intent(mContext, PubLayout.class);
			hubben.putExtra("Pub layout", R.layout.hubben);
			hubben.putExtra("Pub title", myOverlays.get(i).getTitle());
			hubben.putExtra("More info", R.string.ja_pripps_info);
			hubben.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(hubben);
			break;
		case 8:		// Start Basen activity
			Intent basen = new Intent(mContext, PubLayout.class);
			basen.putExtra("Pub layout", R.layout.basen);
			basen.putExtra("Pub title", myOverlays.get(i).getTitle());
			basen.putExtra("More info", R.string.ja_pripps_info);
			basen.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(basen);
			break;
		case 9:		// Start Kajsabaren activity
			Intent kajsaBaren = new Intent(mContext, PubLayout.class);
			kajsaBaren.putExtra("Pub layout", R.layout.kajsabaren);
			kajsaBaren.putExtra("Pub title", myOverlays.get(i).getTitle());
			kajsaBaren.putExtra("More info", R.string.ja_pripps_info);
			kajsaBaren.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(kajsaBaren);
			break;
		case 10:	// Start J�rnv�gspub activity
			Intent jarnvagsPub = new Intent(mContext, PubLayout.class);
			jarnvagsPub.putExtra("Pub layout", R.layout.jarnvagspub);
			jarnvagsPub.putExtra("Pub title", myOverlays.get(i).getTitle());
			jarnvagsPub.putExtra("More info", R.string.ja_pripps_info);
			jarnvagsPub.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(jarnvagsPub);
			break;
		case 11:	// Start GasTown activity
			Intent gasTown = new Intent(mContext, PubLayout.class);
			gasTown.putExtra("Pub layout", R.layout.gastown);
			gasTown.putExtra("Pub title", myOverlays.get(i).getTitle());
			gasTown.putExtra("More info", R.string.ja_pripps_info);
			gasTown.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(gasTown);
			break;
		case 12:	// Start FortNOx activity
			Intent fortNox = new Intent(mContext, PubLayout.class);
			fortNox.putExtra("Pub layout", R.layout.fortnox);
			fortNox.putExtra("Pub title", myOverlays.get(i).getTitle());
			fortNox.putExtra("More info", R.string.ja_pripps_info);
			fortNox.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(fortNox);
			break;
		case 13:	// Start Spritk�ket activity
			Intent spritkoket = new Intent(mContext, PubLayout.class);
			spritkoket.putExtra("Pub layout", R.layout.spritkoket);
			spritkoket.putExtra("Pub title", myOverlays.get(i).getTitle());
			spritkoket.putExtra("More info", R.string.ja_pripps_info);
			spritkoket.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(spritkoket);
			break;
		case 14:	// Start Focus activity
			Intent focus = new Intent(mContext, PubLayout.class);
			focus.putExtra("Pub layout", R.layout.focus);
			focus.putExtra("Pub title", myOverlays.get(i).getTitle());
			focus.putExtra("More info", R.string.ja_pripps_info);
			focus.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(focus);
			break;
		case 15:	// Start R�da rummet activity
			Intent rodaRummet = new Intent(mContext, PubLayout.class);
			rodaRummet.putExtra("Pub layout", R.layout.rodarummet);
			rodaRummet.putExtra("Pub title", myOverlays.get(i).getTitle());
			rodaRummet.putExtra("More info", R.string.ja_pripps_info);
			rodaRummet.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(rodaRummet);
			break;
		case 16:	// Start Sigurd/A-fiket activity
			Intent sigurdAfiket = new Intent(mContext, PubLayout.class);
			sigurdAfiket.putExtra("Pub layout", R.layout.sigurdafiket);
			sigurdAfiket.putExtra("Pub title", myOverlays.get(i).getTitle());
			sigurdAfiket.putExtra("More info", R.string.ja_pripps_info);
			sigurdAfiket.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(sigurdAfiket);
			break;
		case 17:	// Start Pub P activity
			Intent pubP = new Intent(mContext, PubLayout.class);
			pubP.putExtra("Pub layout", R.layout.pubp);
			pubP.putExtra("Pub title", myOverlays.get(i).getTitle());
			pubP.putExtra("More info", R.string.ja_pripps_info);
			pubP.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(pubP);
			break;
		case 18:	// Start 11:an activity
			Intent pubF = new Intent(mContext, PubLayout.class);
			pubF.putExtra("Pub layout", R.layout.pubf);
			pubF.putExtra("Pub title", myOverlays.get(i).getTitle());
			pubF.putExtra("More info", R.string.ja_pripps_info);
			pubF.putExtra("Pub nr in array", counter.get(i).intValue());
			mContext.startActivity(pubF);
			break;
		case 19:	// Start Gangnam Style activity
			Intent gangnamstyle = new Intent(mContext, GangnamStyle.class);
			mContext.startActivity(gangnamstyle);
			break;
		}
		return true;

	}

	@Override
	public int size() {
		return myOverlays.size();
	}
}