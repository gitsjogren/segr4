package com.tarea.pubrundan;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapTabView extends MapActivity {

	private MapView mapView;
	
	@Override
	protected void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		setContentView(R.layout.maptabview);
		
		loadMap();
	}
	
	private void loadMap() {
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
