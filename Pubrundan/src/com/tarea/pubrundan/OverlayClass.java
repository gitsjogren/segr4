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

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.tarea.pubrundan.Pubs.Basen;
import com.tarea.pubrundan.Pubs.Bulten;
import com.tarea.pubrundan.Pubs.ClubAvancez;
import com.tarea.pubrundan.Pubs.Focus;
import com.tarea.pubrundan.Pubs.FortNOx;
import com.tarea.pubrundan.Pubs.GangnamStyle;
import com.tarea.pubrundan.Pubs.GasTown;
import com.tarea.pubrundan.Pubs.Gasquen;
import com.tarea.pubrundan.Pubs.GoldenI;
import com.tarea.pubrundan.Pubs.Hubben;
import com.tarea.pubrundan.Pubs.JAPripps;
import com.tarea.pubrundan.Pubs.Jarnvagspub;
import com.tarea.pubrundan.Pubs.Kajsabaren;
import com.tarea.pubrundan.Pubs.PubF;
import com.tarea.pubrundan.Pubs.PubP;
import com.tarea.pubrundan.Pubs.RodaRummet;
import com.tarea.pubrundan.Pubs.SigurdAfiket;
import com.tarea.pubrundan.Pubs.Spritkoket;
import com.tarea.pubrundan.Pubs.Winden;
import com.tarea.pubrundan.Pubs.Zaloonen;

// TODO: Auto-generated Javadoc
/**
 * The class OverlayClass
 * 
 * @author Erik Sjögren
 * 
 */
public class OverlayClass extends ItemizedOverlay<OverlayItem> {

	
	/** The Constant POINT_DIFFERENCE. */
	private static final float POINT_DIFFERENCE = 50;
    
    /** The system time. */
    private long systemTime = System.currentTimeMillis();

    /** The down x. */
    private float downX;
    
    /** The down y. */
    private float downY;
	
	/** The my overlays. */
	private ArrayList<OverlayItem> myOverlays;
	
	/** The m context. */
	private Context mContext;
	
	/** The count. */
	private int count = 0;
	
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

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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
			Intent elvan = new Intent(mContext, PubF.class);
			mContext.startActivity(elvan);
			return true;
		case 19:	// Start Gangnam Style activity
			Intent gangnamstyle = new Intent(mContext, GangnamStyle.class);
			mContext.startActivity(gangnamstyle);
			return true;
		}
		return false;

	}

	/* (non-Javadoc)
	 * Returns present number of items in list
	 * @see com.google.android.maps.ItemizedOverlay#size()
	 */
	@Override
	public int size() {
		return myOverlays.size();
	}
		
	/* (non-Javadoc)
	 * 
	 * @see com.google.android.maps.ItemizedOverlay#onTouchEvent(android.view.MotionEvent, com.google.android.maps.MapView)
	 * 
	 * @param event
	 * 
	 * @mapView
	 * 
	 * @return true, if successful
	 * 
	 */
	@Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            final long timeDiff = (System.currentTimeMillis() - systemTime);
            if (timeDiff < ViewConfiguration.getDoubleTapTimeout()) 
            {
                if 
                (
                    (Math.abs(downX - event.getX()) < POINT_DIFFERENCE) && 
                    (Math.abs(downY - event.getY()) < POINT_DIFFERENCE)
                )
                {
                    mapView.getController().zoomInFixing
                    (
                        (int) event.getX(),
                        (int) event.getY()
                    );
                }            
            }
            break;
        case MotionEvent.ACTION_UP:
            systemTime = System.currentTimeMillis();
            downX = event.getX();
            downY = event.getY();
            
            break;
        }
        return false;        
    }
}