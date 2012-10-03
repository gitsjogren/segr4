package com.tarea.pubrundan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.Toast;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class TabbedListMapActivity extends MapActivity implements OnTabChangeListener {

	private static final String GET_MY_LOCATION_TAG = "Location";
	private static final String LIST_TAB_TAG = "List";
	private static final String MAP_TAB_TAG = "Map";

	private TabHost tabHost;

	private ListView listView;
	private MapView mapView;
	private MyLocationOverlay myLocationOverlay;
	
	final CharSequence[] items = {"Street", "Satellite", "Traffic"}; // selectable map views

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
        
        tabHost = (TabHost) findViewById(android.R.id.tabhost);

		// setup must be called if you are not inflating the tabhost from XML
		tabHost.setup();
		tabHost.setOnTabChangedListener(this);

		// setup list view
		//listView = (ListView) findViewById(R.id.list);
		//listView.setEmptyView((TextView) findViewById(R.id.empty));

//		// create some dummy coordinates to add to the list
//		List<GeoPoint> pointsList = new ArrayList<GeoPoint>();
//		pointsList.add(new GeoPoint((int)(57.688741*1E6), (int)(11.975162*1E6)));
//		pointsList.add(new GeoPoint((int)(57.706189*1E6), (int)(11.936801*1E6)));
//		listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, pointsList));
//
//		// add an onclicklistener to see point on the map
//		listView.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView parent, View view, int position, long id) {
//				GeoPoint geoPoint = (GeoPoint) listView.getAdapter().getItem(position);
//				if(geoPoint != null) {
//					// have map view moved to this point
//					setMapZoomPoint(geoPoint, 18);
//					// programmatically switch tabs to the map view
//					tabHost.setCurrentTab(1);
//				}
//			}
//		});

		// setup map view
		//mapView = (MapView) findViewById(R.id.mapview);
		mapView.setSatellite(true); // Changes the default map to satellite mode by default
		mapView.setBuiltInZoomControls(true); // Adding possibility to zoom in/out
		//mapView.postInvalidate();
		
		// create an overlay that shows our current location
		myLocationOverlay = new MyLocationOverlay(this, mapView);

		// add this overlay to the MapView and refresh it
		mapView.getOverlays().add(myLocationOverlay);
		mapView.postInvalidate();

		// add views to tab host
		tabHost.addTab(tabHost.newTabSpec(GET_MY_LOCATION_TAG).setIndicator("Location", this.getResources().getDrawable(R.drawable.icon_location_search)).setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				//onTabChanged(arg0);
				return listView;
			}
		}));
		tabHost.addTab(tabHost.newTabSpec(MAP_TAB_TAG).setIndicator("Byt Campus").setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				return mapView;
			}
		}));
		
		tabHost.addTab(tabHost.newTabSpec(LIST_TAB_TAG).setIndicator("List", this.getResources().getDrawable(R.drawable.icon_list_view)).setContent(new TabContentFactory() {
			public View createTabContent(String arg0) {
				return listView;
			}
		}));

		//HACK to get the list view to show up first,
		// otherwise the mapview would be bleeding through and visible
		tabHost.setCurrentTab(1);
		//tabHost.setCurrentTab(0);
    }

    /**
     * Instructs the map view to navigate to the point and zoom level specified.
     * @param geoPoint
     * @param zoomLevel
     */
//    private void setMapZoomPoint(GeoPoint geoPoint, int zoomLevel) {
//		mapView.getController().setCenter(geoPoint);
//		mapView.getController().setZoom(zoomLevel);
//		mapView.postInvalidate();
//	}

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
    
    /**
     * From MapActivity, we ignore it for this demo
     */
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	/**
	 * Implement logic here when a tab is selected
	 */
	public void onTabChanged(String tabName) {
		if(tabName.equals(MAP_TAB_TAG)) {
			//do something on the map
		}
		else if(tabName.equals(GET_MY_LOCATION_TAG)) {
			// add this overlay to the MapView and refresh it
			mapView.getOverlays().add(myLocationOverlay);
			mapView.postInvalidate();
		}
		else if(tabName.equals(LIST_TAB_TAG)) {
			//do something on the list
		}
	}
	
	/** Called when the user press back button in the TabbedListMapActivity */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
            .setTitle("Avsluta")
            .setMessage("Säker på att du vill avsluta?")
            .setNegativeButton("Nej", null)
            .setPositiveButton("Ja, avsluta!", new OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    TabbedListMapActivity.super.onBackPressed();
                }
            }).create().show();
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
            Toast.makeText(TabbedListMapActivity.this, items[item] + " är valt", Toast.LENGTH_SHORT).show();
            }
        }).create().show();
        case R.id.settings:
             return true;

        case R.id.share:
        	return true;
        }
        return false;
    }
}
