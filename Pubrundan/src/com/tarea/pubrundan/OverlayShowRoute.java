package com.tarea.pubrundan;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class OverlayShowRoute extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> myOverlays;
	
	private Context mContext;
	
	//@SuppressLint("UseSparseArrays")
	//private Map<Integer, String> pubs = new HashMap<Integer, String>();
	
	//private int count = 0;

	public OverlayShowRoute(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		populate();
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		populate();
		//pubs.put(count, overlay.getTitle());
		//count++;
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
			
			//String toast = "Title: " + myOverlays.get(i).getTitle();
			//toast += "\nText: " + myOverlays.get(i).getSnippet();
			//Toast.makeText(AppTest.context, toast, Toast.LENGTH_LONG).show();
			//OverlayItem item = myOverlays.get(i);
			Intent toPubInfo = new Intent(mContext,PubInfo.class );
			mContext.startActivity(toPubInfo);			
			
			return true;
		
	}

	// Returns present number of items in list
	@Override
	public int size() {
		return myOverlays.size();
	}
}