package com.tarea.pubrundan;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.tarea.pubrundan.Pubs.Basen;
import com.tarea.pubrundan.Pubs.Bulten;
import com.tarea.pubrundan.Pubs.ClubAvancez;
import com.tarea.pubrundan.Pubs.Elvan;
import com.tarea.pubrundan.Pubs.Focus;
import com.tarea.pubrundan.Pubs.FortNOx;
import com.tarea.pubrundan.Pubs.GasTown;
import com.tarea.pubrundan.Pubs.Gasquen;
import com.tarea.pubrundan.Pubs.GoldenI;
import com.tarea.pubrundan.Pubs.Hubben;
import com.tarea.pubrundan.Pubs.JAPripps;
import com.tarea.pubrundan.Pubs.Jarnvagspub;
import com.tarea.pubrundan.Pubs.Kajsabaren;
import com.tarea.pubrundan.Pubs.PubP;
import com.tarea.pubrundan.Pubs.RodaRummet;
import com.tarea.pubrundan.Pubs.SigurdAfiket;
import com.tarea.pubrundan.Pubs.Spritkoket;
import com.tarea.pubrundan.Pubs.Winden;
import com.tarea.pubrundan.Pubs.Zaloonen;

public class OverlayClass extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> myOverlays;
	private Context mContext;
	private int count = 0;
	private ArrayList<Integer> counter = new ArrayList<Integer>();

	public OverlayClass(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		populate();
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		populate();
		counter.add(count);
		count++;
	}

	@Override
	protected OverlayItem createItem(int i) {
		return myOverlays.get(i);
	}

	// Removes overlay item i
	public void removeItem(int i) {
		myOverlays.remove(i);
		populate();
	}

	// Handle tap events on overlay icons
	@Override
	protected boolean onTap(int i) {
		switch (counter.get(i)) {

		case 0:		// Start J.A. Pripps activity
			Intent japripps = new Intent(mContext, JAPripps.class);
			mContext.startActivity(japripps);
			return true;
		case 1:		// Start Gasquen activity
			Intent gasquen = new Intent(mContext, Gasquen.class);
			mContext.startActivity(gasquen);
			return true;
		case 2:		// Start Bulten activity
			Intent bulten = new Intent(mContext, Bulten.class);
			mContext.startActivity(bulten);
			return true;
		case 3:		// Start Winden activity
			Intent winden = new Intent(mContext, Winden.class);
			mContext.startActivity(winden);
			return true;
		case 4:		// Start Zaloonen Pripps activity
			Intent zaloonen = new Intent(mContext, Zaloonen.class);
			mContext.startActivity(zaloonen);
			return true;
		case 5:		// Start Club Avancez activity
			Intent clubavancez = new Intent(mContext, ClubAvancez.class);
			mContext.startActivity(clubavancez);
			return true;
		case 6:		// Start GoldenI activity
			Intent goldeni = new Intent(mContext, GoldenI.class);
			mContext.startActivity(goldeni);
			return true;
		case 7:		// Start Hubben 2.1 activity
			Intent hubben = new Intent(mContext, Hubben.class);
			mContext.startActivity(hubben);
			return true;
		case 8:		// Start Basen activity
			Intent basen = new Intent(mContext, Basen.class);
			mContext.startActivity(basen);
			return true;
		case 9:		// Start Kajsabaren activity
			Intent kajsabaren = new Intent(mContext, Kajsabaren.class);
			mContext.startActivity(kajsabaren);
			return true;
		case 10:	// Start Järnvägspub activity
			Intent jarnvagspub = new Intent(mContext, Jarnvagspub.class);
			mContext.startActivity(jarnvagspub);
			return true;
		case 11:	// Start GasTown activity
			Intent gastown = new Intent(mContext, GasTown.class);
			mContext.startActivity(gastown);
			return true;
		case 12:	// Start FortNOx activity
			Intent fortnox = new Intent(mContext, FortNOx.class);
			mContext.startActivity(fortnox);
			return true;
		case 13:	// Start Spritköket activity
			Intent spritkoket = new Intent(mContext, Spritkoket.class);
			mContext.startActivity(spritkoket);
			return true;
		case 14:	// Start Focus activity
			Intent focus = new Intent(mContext, Focus.class);
			mContext.startActivity(focus);
			return true;
		case 15:	// Start Röda rummet activity
			Intent rodarummet = new Intent(mContext, RodaRummet.class);
			mContext.startActivity(rodarummet);
			return true;
		case 16:	// Start Sigurd/A-fiket activity
			Intent sigurdafiket = new Intent(mContext, SigurdAfiket.class);
			mContext.startActivity(sigurdafiket);
			return true;
		case 17:	// Start Pub P activity
			Intent pubp = new Intent(mContext, PubP.class);
			mContext.startActivity(pubp);
			return true;
		case 18:	// Start 11:an activity
			Intent elvan = new Intent(mContext, Elvan.class);
			mContext.startActivity(elvan);
			return true;
		}
		return false;

	}

	// Returns present number of items in list
	@Override
	public int size() {
		return myOverlays.size();
	}
}