package com.tarea.pubrundan;

import java.util.ArrayList;

import android.content.Context;
import android.location.Location;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MyLocationOverlay;

class MyLocationOverlayExtension extends MyLocationOverlay {
	
	public ArrayList<GeoPoint> listan = new ArrayList<GeoPoint>();

    public MyLocationOverlayExtension(Context context, OnDoubleTap onDoubleTap) {
        super(context, onDoubleTap);
    }
    
    @Override
    public synchronized void onLocationChanged(Location location) {
        super.onLocationChanged(location);
        GeoPoint point = new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6));
        listan.add(point);
    }
    
}