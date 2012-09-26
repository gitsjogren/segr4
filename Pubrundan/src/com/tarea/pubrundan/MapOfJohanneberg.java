package com.tarea.pubrundan;

import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
 
public class MapOfJohanneberg extends MapActivity
{    
    MapView mapView;
    MapController mc;
    GeoPoint p;  // object p represent a geographical location
    final CharSequence[] items = {"Street", "Satellite", "Traffic"}; // selectable map views
    
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
        mapView.setSatellite(true); // Changes the default map to satellite mode by default
        mapView.setBuiltInZoomControls(true); // Adding possibility to zoom in/out
        
        mc = mapView.getController();
        String coordinates[] = {"57.688741", "11.975162"}; // coordinates for pub "Gasquen" @ Campus Johanneberg
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
    
 // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater oMenu = getMenuInflater();
        oMenu.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
        case R.id.change_map:
        	new AlertDialog.Builder(this)
            .setTitle("Ändra vy")
            .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (item == 0)
            	{
                	mapView.setTraffic(false);
                	mapView.setSatellite(false);
                	mapView.setStreetView(true);
            	}
                
                else if (item == 1)
                {
                	mapView.setStreetView(false);
                	mapView.setTraffic(false);
                	mapView.setSatellite(true);
            	}
                
                else if( item == 2)
                {
                	mapView.setStreetView(false);
                	mapView.setSatellite(false);
                	mapView.setTraffic(true);
            	}
            dialog.dismiss();
            Toast.makeText(MapOfJohanneberg.this, items[item] + " är valt", Toast.LENGTH_SHORT).show();
            }
        }).create().show();
        case R.id.settings:
             return true;

        case R.id.share:
        	return true;
        }
        return false;
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
}