package com.tarea.pubrundan;

import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class ShowTheMap extends MapActivity {
            
    private static double lat;
    private static double lon;
    private int latE6;
    private int lonE6;
    private MapController mc;
    private GeoPoint gp;
    private MapView mapView;
    private Button getThePositionButton, changeCampusButton, goToPubListButton;
    private MyLocationOverlay myLocationOverlay;

    private List<Overlay> mapOverlays;
    private Drawable drawable1, drawable2;
    private MyItemizedOverlay itemizedOverlay1, itemizedOverlay2;
    
    private final CharSequence[] differentViews = {"Street", "Satellite", "Traffic"};  // selectable map views
    
    // Define an array containing the access overlay items for all of the pubs of Johanneberg and Lindholmen
    // Coordinates need to be converted into integers, by default they are displayed in microdegrees
    private OverlayItem [] allPubsArray = {
    		new OverlayItem( new GeoPoint((int)(57.688999*1E6),(int)(11.973979*1E6)), "Access Title 1", "Access snippet 1"),
            new OverlayItem( new GeoPoint((int)(57.687738*1E6),(int)(11.975974*1E6)), "Access Title 2", "Access snippet 2"),
            new OverlayItem( new GeoPoint((int)(57.688885*1E6),(int)(11.975481*1E6)), "Access Title 3", "Access snippet 3"),
            new OverlayItem( new GeoPoint((int)(57.706089*1E6),(int)(11.936669*1E6)), "11:an", "Vänster om SVEA")
    };

    // standard onCreate method
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // Suppress title bar for more space
        setContentView(R.layout.showthemap);	// Use xml-layout showtomap.xml
        
        // Add map controller with zoom controls
        mapView = (MapView) findViewById(R.id.mv);
        mapView.setSatellite(true);	// Satellite is set by default
        mapView.setBuiltInZoomControls(true);   // Set android:clickable=true in main.xml 

        myLocationOverlay = new MyLocationOverlay(this, mapView);  // Creates a new MyLocationOverlay for later use in the code
        
        mc = mapView.getController();
        // Convert lat/long in degrees into integers in microdegrees
        latE6 =  (int) (lat*1e6);
        lonE6 = (int) (lon*1e6);
        gp = new GeoPoint(latE6, lonE6);  // Creates new Geopoint with coordinates passed from MapOverlayDemo class
        mc.animateTo(gp);  // Move the map using Mapcontroller object mc to Geopoint object gp
        showThePubs();  // Displaying all pubs as overlay in maps, see method for more info
        mc.setZoom(17);  // Set the zoom level (int value from 1 to 21) to 17 for behavior view

        // Button for get my location
        getThePositionButton = (Button)findViewById(R.id.getPosition);
        getThePositionButton.setOnClickListener(new OnClickListener(){      
            public void onClick(View v) {	
                 setOverlay1();     
            }
        });
        
        // Button to control access overlay
        changeCampusButton = (Button)findViewById(R.id.changeCampus);
        changeCampusButton.setOnClickListener(new OnClickListener(){      
            public void onClick(View v) {	
                 setOverlay2();       
            }
        });
        
     // Button to control access overlay
        goToPubListButton = (Button)findViewById(R.id.pubList);
        goToPubListButton.setOnClickListener(new OnClickListener(){      
            public void onClick(View v) {	
                 startPubList();       
            }
        });

    }
    

    /* Methods to set map overlays. In this case we will place a small overlay image at
    a specified location. Place the marker image as a png file in res > drawable-* .
    For example, the reference to R.drawable.knifefork_small below is to an
    image file called knifefork_small.png in the project folder res > drawable-hdpi.
    Can only use lower case letters a-z, numbers 0-9, ., and _ in these image file names. 
    In this example the single overlay item is specified by drawable and the
    location of the overlay item is specified by overlayitem. */
    
    // Display food location overlay.  If not already displayed, clicking button displays all 
    // food overlays.  If already, displayed successive clicks remove items one by one. This
    // illustrates ability to remove individual overlay items dynamically at runtime.
    
    public void setOverlay1(){	
     	myLocationOverlay = new MyLocationOverlay(this, mapView);
        myLocationOverlay.enableMyLocation();
        mapView.getOverlays().add(myLocationOverlay);
     	
     	mc = mapView.getController();
     	myLocationOverlay.runOnFirstFix(new Runnable() {
     	            public void run() {
     	                mc.setZoom(17);
     	                mc.animateTo(myLocationOverlay.getMyLocation());
     	            }
     	        });
    }
    
    public void showThePubs(){
    	
    	// Create itemizedOverlay2 if it doesn't exist
        if(itemizedOverlay2 == null ){
        mapOverlays = mapView.getOverlays();	
        drawable2 = this.getResources().getDrawable(R.drawable.ic_launcher);
        itemizedOverlay2 = new MyItemizedOverlay(drawable2);
        }     
        for(int i = 0; i < allPubsArray.length; i++){
        	
        		itemizedOverlay2.addOverlay(allPubsArray[i]); 	
                mapOverlays.add(itemizedOverlay2);      
        }
        // Added symbols will be displayed when map is redrawn so force redraw now
        mapView.postInvalidate();    
    }
    
    // Display accessibility overlay.  If not already displayed, successive button clicks display each of
    // the three icons successively, then the next removes them all.  This illustrates the ability to add
    // individual overlay items dynamically at runtime
    
    public void setOverlay2(){	
    	
    	mc = mapView.getController();
        gp = new GeoPoint(57705947, 11936642);
        mc.animateTo(gp);
        showThePubs();
        mc.setZoom(17); 
    }
    
    
    public void startPubList(){
    	
    	Intent i = new Intent(this, PubList.class);
        startActivity(i);
    }

    // Method to insert latitude and longitude in degrees
    public static void putLatLong(double latitude, double longitude){
        lat = latitude;
        lon =longitude;
    }
                        
    // Required method since class extends MapActivity
    @Override
    protected boolean isRouteDisplayed() {
            return false;  // Don't display a route
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
 	.setSingleChoiceItems(differentViews, -1, new DialogInterface.OnClickListener() {
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
 	Toast.makeText(ShowTheMap.this, differentViews[item] + " är valt",
 	Toast.LENGTH_SHORT).show();
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
 	protected void onResume() {
 		super.onResume();
 		// when our activity resumes, we want to register for location updates
 		myLocationOverlay.enableMyLocation();
 	}

 	@Override
 	protected void onPause() {
 		super.onPause();
 		// when our activity pauses, we want to remove listening for location updates
 		myLocationOverlay.disableMyLocation();
 	}
}