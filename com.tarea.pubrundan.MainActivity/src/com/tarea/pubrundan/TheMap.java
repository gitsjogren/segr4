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
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class TheMap extends MapActivity implements OnTabChangeListener {

	private static double lat;
	private static double lon;
	private int latE6;
	private int lonE6;
	private MapController mc;
	private GeoPoint gp;
	private MapView mapView;
	private Button getThePositionButton, changeCampusButton, goToPubListButton; // Buttons
																				// shown
																				// on
																				// top
																				// of
																				// theMap
	private MyLocationOverlay myLocationOverlay; // An Overlay showing a "point"
													// on the map aka your
													// current position

	private List<Overlay> mapOverlays;
	private Drawable drawable1, drawable2;
	private OverlayShowRoute itemizedOverlay1, itemizedOverlay2;

	private final CharSequence[] differentViews = { "Street", "Satellite",
			"Traffic" }; // selectable map views

	// Define an array containing the access overlay items for all of the pubs
	// of Johanneberg and Lindholmen
	// Coordinates need to be converted into integers, by default they are
	// displayed in microdegrees
	private OverlayItem[] allPubsArray = {
			new OverlayItem(new GeoPoint((int) (57.688999 * 1E6),
					(int) (11.973979 * 1E6)), "Access Title 1",
					"Access snippet 1"),
			new OverlayItem(new GeoPoint((int) (57.687738 * 1E6),
					(int) (11.975974 * 1E6)), "Access Title 2",
					"Access snippet 2"),
			new OverlayItem(new GeoPoint((int) (57.688885 * 1E6),
					(int) (11.975481 * 1E6)), "Access Title 3",
					"Access snippet 3"),
			new OverlayItem(new GeoPoint((int) (57.706089 * 1E6),
					(int) (11.936669 * 1E6)), "11:an", "Vänster om SVEA") };

	// standard onCreate method
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for
														// more space
		setContentView(R.layout.showthemap); // Use xml-layout showtomap.xml

		// Add map controller with zoom controls
		mapView = (MapView) findViewById(R.id.mv);
		mapView.setSatellite(true); // Satellite is set by default
		mapView.setBuiltInZoomControls(true); // Set android:clickable=true in
												// main.xml

		// create an overlay that shows our current location
		myLocationOverlay = new MyLocationOverlay(this, mapView); // Creates a
																	// new
																	// MyLocationOverlay
																	// for later
																	// use in
																	// the code

		mc = mapView.getController();
		// Convert lat/long in degrees into integers in microdegrees
		latE6 = (int) (lat * 1e6);
		lonE6 = (int) (lon * 1e6);
		gp = new GeoPoint(latE6, lonE6); // Creates new Geopoint with
											// coordinates passed from
											// MapOverlayDemo class
		mc.animateTo(gp); // Move the map using Mapcontroller object mc to
							// Geopoint object gp
		showThePubs(); // Displaying all pubs as overlay in maps, see method for
						// more info
		mc.setZoom(17); // Set the zoom level (int value from 1 to 21) to 17 for
						// behavior view
		// showTheCurrentPosition();  // navigate to users current location
		// inactive during development

		// Button for get my location
		getThePositionButton = (Button) findViewById(R.id.getPosition);
		getThePositionButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showTheCurrentPosition();
			}
		});

		// Button to control access overlay
		changeCampusButton = (Button) findViewById(R.id.changeCampus);
		changeCampusButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				changeToCampusLindholmen();
			}
		});

		// Button to control access overlay
		goToPubListButton = (Button) findViewById(R.id.pubList);
		goToPubListButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startPubListActivity();
			}
		});

	}

	// The map will navigate to your current position
	public void showTheCurrentPosition() {
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

	// display all pubs in the allPubsArray as an overlay onto the map
	public void showThePubs() {

		// Create itemizedOverlay2 if it doesn't exist
		if (itemizedOverlay2 == null) {
			mapOverlays = mapView.getOverlays();
			drawable2 = this.getResources().getDrawable(R.drawable.ic_launcher);
			itemizedOverlay2 = new OverlayShowRoute(drawable2);
		}
		for (int i = 0; i < allPubsArray.length; i++) {

			itemizedOverlay2.addOverlay(allPubsArray[i]);
			mapOverlays.add(itemizedOverlay2);
		}
		// Added symbols will be displayed when map is redrawn so force redraw
		// now
		mapView.postInvalidate();
	}

	// navigate to campus Lindholmen if users clicks changeCampusButton
	public void changeToCampusLindholmen() {

		mc = mapView.getController();
		gp = new GeoPoint(57705947, 11936642);
		mc.animateTo(gp);
		showThePubs();
		mc.setZoom(17);
	}

	// starting new activity( PubList.java ) if user clicks goToPubListButton
	public void startPubListActivity() {

		Intent i = new Intent(this, PubList.class); // context = this ,
													// ClassToNavigateTo.class
		startActivity(i);
	}

	// Method to insert latitude and longitude in degrees
	public static void putLatLong(double latitude, double longitude) {
		lat = latitude;
		lon = longitude;
	}

	// Required method since class extends MapActivity
	@Override
	protected boolean isRouteDisplayed() {
		return false; // Don't display a route
	}

	// Initiating Menu XML file (menu.xml)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater oMenu = getMenuInflater();
		oMenu.inflate(R.menu.menu, menu);
		return true;
	}

	// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
	// refactor is needed!
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.change_map:
			new AlertDialog.Builder(this).setTitle("Ändra vy")
					.setSingleChoiceItems(differentViews, -1, // -1 === fulhack
																// :|
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int item) {
									if (item == 0) {
										mapView.setTraffic(false);
										mapView.setSatellite(false);
										mapView.setStreetView(true);
									}

									else if (item == 1) {
										mapView.setStreetView(false);
										mapView.setTraffic(false);
										mapView.setSatellite(true);
									}

									else if (item == 2) {
										mapView.setStreetView(false);
										mapView.setSatellite(false);
										mapView.setTraffic(true);
									}
									dialog.dismiss();
									Toast.makeText(TheMap.this,
											differentViews[item] + " är valt",
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
		// when our activity pauses, we want to remove listening for location
		// updates
		myLocationOverlay.disableMyLocation();
	}

	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub

	}

	/** Called when the user press back button in the TheMap */
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setTitle("Avsluta") // Title: "Avsluta"
				.setMessage("Säker på att du vill avsluta?") // Message:
																// "Säker på att du vill avsluta?"
				.setNegativeButton("Nej", null) // Negative answer button: "Nej"
												// -> return null aka close
												// dialog
				.setNeutralButton("Ja, avsluta!", // Neutral answer button:
													// "Ja, avsluta" -> exit
													// current activity
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(DialogInterface arg0, int arg1) {
								TheMap.super.onBackPressed();
							}
						}).create().show();
	}
}