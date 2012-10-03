package com.tarea.pubrundan;

import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private Button overlayButton, accessButton;
    private MyLocationOverlay myLocationOverlay;

    private List<Overlay> mapOverlays;
    private Drawable drawable1, drawable2;
    private MyItemizedOverlay itemizedOverlay1, itemizedOverlay2;
    
    private final CharSequence[] differentViews = {"Street", "Satellite", "Traffic"};  // selectable map views
    
    // Define an array containing the food overlay items for the pubs of Lindholmen
    
    private OverlayItem [] pubsOfLindholmen = {
        new OverlayItem( new GeoPoint(5770618,1193680178), "11:an", "Vänster om SVEA")
    };
    
    // Define an array containing the  access overlay items for the pubs of Johanneberg
    
    private OverlayItem [] pubsOfJohanneberg = {
        new OverlayItem( new GeoPoint(5768874, 11975162), "Access Title 1", "Access snippet 1"),
        new OverlayItem( new GeoPoint(5769874, 11978162), "Access Title 2", "Access snippet 2"),
        new OverlayItem( new GeoPoint(5770874, 11979162), "Access Title 3", "Access snippet 3"),
        new OverlayItem( new GeoPoint(5768875, 11980162), "Access Title 4", "Access snippet 4") 
    };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // Suppress title bar for more space
        setContentView(R.layout.showthemap);
        
        // Add map controller with zoom controls
        mapView = (MapView) findViewById(R.id.mv);
        mapView.setSatellite(true);
        mapView.setBuiltInZoomControls(true);   // Set android:clickable=true in main.xml 
        // get the users location
        myLocationOverlay = new MyLocationOverlay(this, mapView);
        myLocationOverlay.enableMyLocation();
        mapView.getOverlays().add(myLocationOverlay);
        
        mc = mapView.getController();;
        // Convert lat/long in degrees into integers in microdegrees
        latE6 =  (int) (lat*1e6);
        lonE6 = (int) (lon*1e6);
        gp = new GeoPoint(latE6, lonE6);
        mc.animateTo(gp);
        mc.setZoom(17);
        
        // Create itemizedOverlay2 if it doesn't exist
        if(itemizedOverlay2 == null ){
        mapOverlays = mapView.getOverlays();	
        drawable2 = this.getResources().getDrawable(R.drawable.ic_launcher);
        itemizedOverlay2 = new MyItemizedOverlay(drawable2);
        }     
        for(int i = 0; i < pubsOfJohanneberg.length; i++){
        	
        		itemizedOverlay2.addOverlay(pubsOfJohanneberg[i]); 	
                mapOverlays.add(itemizedOverlay2);      
        }
        // Added symbols will be displayed when map is redrawn so force redraw now
        mapView.postInvalidate();

        // Button for get my location
        overlayButton = (Button)findViewById(R.id.doGetPosition);
        overlayButton.setOnClickListener(new OnClickListener(){      
            public void onClick(View v) {	
                 setOverlay1();     
            }
        });
        
        // Button to control access overlay
        accessButton = (Button)findViewById(R.id.doAccess);
        accessButton.setOnClickListener(new OnClickListener(){      
            public void onClick(View v) {	
                 setOverlay2();       
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
    
    // Display accessibility overlay.  If not already displayed, successive button clicks display each of
    // the three icons successively, then the next removes them all.  This illustrates the ability to add
    // individual overlay items dynamically at runtime
    
    public void setOverlay2(){	
        // Create itemizedOverlay2 if it doesn't exist
        if(itemizedOverlay2 == null ){
        mapOverlays = mapView.getOverlays();	
        drawable2 = this.getResources().getDrawable(R.drawable.ic_launcher);
        itemizedOverlay2 = new MyItemizedOverlay(drawable2);
        }     
        for(int i = 0; i < pubsOfJohanneberg.length; i++){
        	
        		itemizedOverlay2.addOverlay(pubsOfJohanneberg[i]); 	
                mapOverlays.add(itemizedOverlay2);      
        }
        // Added symbols will be displayed when map is redrawn so force redraw now
        mapView.postInvalidate();
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