package com.tarea.pubrundan;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
 
public class MapsActivity extends MapActivity 
{    
    MapView mapView;
    MapController mc;
    GeoPoint p;  // object p represent a geographical location
    
    class MapOverlay extends com.google.android.maps.Overlay
    {
        @Override
        public boolean draw(Canvas canvas, MapView mapView, 
        boolean shadow, long when) 
        {
            super.draw(canvas, mapView, shadow);                   
 
            //---translate the GeoPoint to screen pixels---
            Point screenPts = new Point();
            mapView.getProjection().toPixels(p, screenPts);
 
            //---add the marker---
            Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), R.drawable.pushpin);            
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
            return true;
        }
            
    }
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setSatellite(true); // Changes the default map to satellite mode
        mapView.setBuiltInZoomControls(true); // Adding possibility to zoom in/out
        
        mc = mapView.getController();
        String coordinates[] = {"57.706189", "11.9368017"}; // coordinates for pub "11:an" @ Campus Lindholmen
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
        
        // GeoPoint represent longitude and latitude in micro degrees, why we multiply it by 1e^6
        p = new GeoPoint(
                (int) (lat * 1E6), 
                (int) (lng * 1E6));
     
            mc.animateTo(p); // navigates to a specific location, p in our case
            mc.setZoom(18); // zoom level in which the map is displayed, sets a value between 1 and 21
            
          //---Add a location marker---
            MapOverlay mapOverlay = new MapOverlay();
            List<Overlay> listOfOverlays = mapView.getOverlays();
            listOfOverlays.clear();
            listOfOverlays.add(mapOverlay);
            
            mapView.invalidate();
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}