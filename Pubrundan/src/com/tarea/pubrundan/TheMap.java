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

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import com.google.android.maps.Projection;

//### This class follows some code examples from http://eagle.phys.utk.edu/guidry/android/index.html  ###//

/**
 * The class TheMap
 * 
 * @author Erik Sjögren
 * 
 */
public class TheMap extends MapActivity implements OnGestureListener,
		OnDoubleTapListener, LocationListener {

	private SharedPreferences sharedPrefs;

	/*
	 * Boolean that tells the application which campus that
	 * is currently the one the user is looking at. 
	 * Used for the 'Byt Campus'-button.
	 */
	private boolean activeCampus;
	
	private String defaultCampus;
	
	private final int sleepTime = 3000;
	
	private final static int strokeWidthIsFour = 4;
	
	private final static int zoomLevel = 17;
	
	private final static int closeZoom = 19;
	
	private final int timeConstant = 200;
	
	private final double lindholmenLat = 57705947;
	
	private final double lindholmenLon = 11936642;
	
<<<<<<< HEAD
=======
	private final double johannebergLat = 57691144;
	
	private final double johannebergLon = 11976078;
	
	private final double entranceOfChalmersLat = 57689814;
			
	private final double entranceOfChalmersLon = 11972988;
	
>>>>>>> 93b02a650f2df3966f1c1655821f429336d63125
	private Projection projection;

	private MyOverlay myoverlay;

	/** The mc. */
	private MapController mc;

	/** The gp. */
	private GeoPoint gp;

	/** The map view. */
	private MapView mapView;

	/** The go to pub list button. */
	private Button getThePositionButton, changeCampusButton, goToPubListButton; // Buttons
																				// shown
																				// on
																				// top
																				// of
																				// theMap
	/** The my location overlay. */
	private MyLocationOverlay myLocationOverlay; // An Overlay showing a "point"
	// on the map aka your
	// current position

	/** The map overlays. */

	private List<Overlay> mapOverlays;

	/** The drawable. */
	private Drawable drawable;

	/** The itemized overlay. */
	private OverlayClass itemizedOverlay;

	private final int defaultIntValue = -1;

	/** The different views. */

	private final CharSequence[] differentViews = { "Street", "Satellite",
			"Traffic" };

	/*
	 * Define an array containing the access overlay items for all of the pubs
	 * of Johanneberg and Lindholmen Coordinates need to be converted into
	 * integers, by default they are displayed in microdegrees
	 */

	/*
	 * The pubs in the array are listed and hardcoded from
	 * coordinates_of_the_pubs.txt	 */

	private OverlayItem[] allPubsArray = {

			// J.A. Pripps
			new OverlayItem(new GeoPoint((int) (57.688984 * 1E6),
					(int) (11.974389 * 1E6)), "J.A. Pripps", "Johanneberg"),
			// Gasquen
			new OverlayItem(new GeoPoint((int) (57.688725 * 1E6),
					(int) (11.975156 * 1E6)), "Gasquen", "Johanneberg"),
			// Bulten
			new OverlayItem(new GeoPoint((int) (57.689148 * 1E6),
					(int) (11.978496 * 1E6)), "Bulten", "Johanneberg"),
			// Winden
			new OverlayItem(new GeoPoint((int) (57.688961 * 1E6),
					(int) (11.978665 * 1E6)), "Winden", "Johanneberg"),
			// Zaloonen
			new OverlayItem(new GeoPoint((int) (57.689097 * 1E6),
					(int) (11.979126 * 1E6)), "Zaloonen", "Johanneberg"),
			// Club Avancez
			new OverlayItem(new GeoPoint((int) (57.692219 * 1E6),
					(int) (11.976862 * 1E6)), "Club Avancez", "Johanneberg"),
			// GoldenI
			new OverlayItem(new GeoPoint((int) (57.692939 * 1E6),
					(int) (11.975242 * 1E6)), "GoldenI", "Johanneberg"),
			// Hubben 2.1
			new OverlayItem(new GeoPoint((int) (57.688331 * 1E6),
					(int) (11.979217 * 1E6)), "Hubben 2.1", "Johanneberg"),
			// Basen
			new OverlayItem(new GeoPoint((int) (57.688776 * 1E6),
					(int) (11.978852 * 1E6)), "Basen", "Johanneberg"),
			// Kajsabaren
			new OverlayItem(new GeoPoint((int) (57.688196 * 1E6),
					(int) (11.978573 * 1E6)), "Kajsabaren", "Johanneberg"),
			// Järnvägspub
			new OverlayItem(new GeoPoint((int) (57.688317 * 1E6),
					(int) (11.975757 * 1E6)), "Järnvägspub", "Johanneberg"),
			// GasTown
			new OverlayItem(new GeoPoint((int) (57.687935 * 1E6),
					(int) (11.975918 * 1E6)), "GasTown", "Johanneberg"),
			// FortNOx
			new OverlayItem(new GeoPoint((int) (57.687302 * 1E6),
					(int) (11.977237 * 1E6)), "FortNOx", "Johanneberg"),
			// Spritköket
			new OverlayItem(new GeoPoint((int) (57.689587 * 1E6),
					(int) (11.977978 * 1E6)), "Spritköket", "Johanneberg"),
			// Focus
			new OverlayItem(new GeoPoint((int) (57.691001 * 1E6),
					(int) (11.977591 * 1E6)), "Focus", "Johanneberg"),
			// Röda rummet
			new OverlayItem(new GeoPoint((int) (57.689977 * 1E6),
					(int) (11.976862 * 1E6)), "Röda rummet", "Johanneberg"),
			// Sigurd/A-fiket
			new OverlayItem(new GeoPoint((int) (57.687563 * 1E6),
					(int) (11.976717 * 1E6)), "Sigurd/A-fiket", "Johanneberg"),
			// Pub P
			new OverlayItem(new GeoPoint((int) (57.706463 * 1E6),
					(int) (11.939596 * 1E6)), "Pub P", "Lindholmen"),
			// 11:an
			new OverlayItem(new GeoPoint((int) (57.706085 * 1E6),
					(int) (11.936675 * 1E6)), "Pub F", "Johanneberg"),
			// Gangnam Style
			new OverlayItem(new GeoPoint((int) (37.5175725 * 1E6),
					(int) (127.047462 * 1E6)), "Gangnam Style", "Sydkorea"),

	};

	/*
	 * standard onCreate method
	 * 
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);	// standard onCreate method

		requestWindowFeature(Window.FEATURE_NO_TITLE); // Suppress title bar for more space
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
		checkIfGpsIsEnabled(); // check if gps is enabled

		/*
		 * If the application is running for the first time a dialog will pop up
		 * and ask for the default campus.
		 */
		sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("firstrun", true);
		if (firstrun) {
			setDefaultCampus();

			// Save the state
			getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
					.putBoolean("firstrun", false).commit();
		}	
		/*
		 * If it's not the first run of the application
		 * then we can just start the loading sequence.
		 * Not possible if the default campus hasn't been
		 * chosen.
		 */
		else{
			getDefaultCampus();
			loading();
		}

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
				changeCampus();
			}
		});

		/* Button which accesses the publist */
		goToPubListButton = (Button) findViewById(R.id.pubList);
		goToPubListButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startPubListActivity();
			}
		});

		String fromIdShowPubOnMap = getIntent().getStringExtra("Show");
		int animateToPub = getIntent().getIntExtra(
				"Pub to animate to", defaultIntValue);
		
		String fromIdFindPub = getIntent().getStringExtra("Route");
		int drawRouteToPub = getIntent().getIntExtra(
				"Pub to draw route to", defaultIntValue);

		if (fromIdShowPubOnMap != null) {
			Toast.makeText(getBaseContext(), fromIdShowPubOnMap, Toast.LENGTH_LONG).show();
			GeoPoint gp = allPubsArray[animateToPub].getPoint();
			animateToPubandSetZoom(gp);
		}
		
		else if (fromIdFindPub != null){

			 mapOverlays = mapView.getOverlays();
			 projection = mapView.getProjection();

			 myoverlay = new MyOverlay(drawRouteToPub);
			 mapOverlays.add(myoverlay);
		}

	}
	
	public void animateToPubandSetZoom(final GeoPoint gp) {

		// http://code.google.com/p/osmdroid/issues/detail?id=204
		// issue in google maps, this ugly workaround will bypass the
		// initialization time issues, in this method it is set to 200 msec
		new Handler().postDelayed(new Runnable() {
			public void run() {
				mc = mapView.getController();
				mc.setZoom(closeZoom);
				mc.animateTo(gp);
			}
		}, timeConstant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onDoubleTap(android.
	 * view.MotionEvent)
	 */
	public boolean onDoubleTap(MotionEvent e) {
		int x = (int) e.getX(), y = (int) e.getY();
		Projection p = mapView.getProjection();
		mapView.getController().animateTo(p.fromPixels(x, y));
		mapView.getController().zoomIn();
		return true;
	}


	// display all pubs in the allPubsArray as an overlay onto the map
	/**
	 * Show the pubs.
	 */
	public void showThePubs() {

		// Create itemizedOverlay2 if it doesn't exist
		if (itemizedOverlay == null) {
			mapOverlays = mapView.getOverlays();
			drawable = this.getResources().getDrawable(
					R.drawable.icon_pub_location);
			itemizedOverlay = new OverlayClass(drawable, this);
		}
		for (int i = 0; i < allPubsArray.length; i++) {

			itemizedOverlay.addOverlay(allPubsArray[i]);
		}
		// Added symbols will be displayed when map is redrawn so force redraw
		// now
		itemizedOverlay.populateFix();
		mapOverlays.add(itemizedOverlay); // need to be outside the for-loop
											// (source:
											// http://stackoverflow.com/questions/2659770/android-map-performance-poor-because-of-many-overlays)
		mapView.postInvalidate();
	}

	/*
	 * Method that gets the value for default campus if the
	 * application itself has been closed.
	 */
	private void getDefaultCampus() {
		defaultCampus = sharedPrefs.getString("defaultCampus", "0");

		if(defaultCampus.equals("0")){
			activeCampus = true;
		}
		else if(defaultCampus.equals("1")){
			activeCampus = false;
		}
	}

	/**
	 * A dialog that lets the user set the default campus, on the first run
	 * only, that will make the application navigate there on start.
	 */
	private void setDefaultCampus() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Standard campus")
				.setMessage("Var vänlig och välj standard campus för kartan.")
				.setIcon(R.drawable.icon_warning)
				.setCancelable(false)
				.setNeutralButton(R.string.johanneberg,
						new android.content.DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								defaultCampus = "0";
								SharedPreferences.Editor editor = sharedPrefs
										.edit();
								editor.putString("defaultCampus", "0");
								editor.commit();
								activeCampus = true;
								loading();

							}
						})
				.setNegativeButton(R.string.lindholmen,
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								defaultCampus = "1";
								SharedPreferences.Editor editor = sharedPrefs
										.edit();
								editor.putString("defaultCampus", "1");
								editor.commit();
								activeCampus = false;
								loading();
							}
						});
		final AlertDialog ad = builder.create();
		ad.show();
	}

	private void loading() {

		final Object loadingDialog = ProgressDialog.show(this,
				"Laddar...", "Vänta...", true);
		new Thread() {
			public void run() {
				try {
					showThePubs();
					showDefaultCampus();				

					// Displaying all pubs as overlay in maps,
					// see method for
					// more info.
					// showTheCurrentPosition(); // navigate to users current
					// location, inactive during development.

					sleep(sleepTime); // sleep the thread, 3000 milliseconds = 3
									// seconds.
				} catch (Exception e) {
				}

				((Dialog) loadingDialog).dismiss();
			}

		}.start();
	}

	/**
	 * Zooms into the campus that the user has chosen.
	 */
	protected void showDefaultCampus() {
		if (defaultCampus.equals("0")){
			changeToCampusJohanneberg();
			activeCampus = true;
		}

		else if (defaultCampus.equals("1")){
			changeToCampusLindholmen();
			activeCampus = false;

		}
	}

	/**
	 * Used to for the 'Byt Campus' button which looks
	 * at the current campus and jumps between the two,
	 * depending on which campus you have as active.
	 */
	public void changeCampus(){
		if(activeCampus){
			changeToCampusLindholmen();
		}
		else if(!activeCampus){
			changeToCampusJohanneberg();
		}
	}	


	/**
	 * Show the current position.
	 */

	public void showTheCurrentPosition() {
		myLocationOverlay = new MyLocationOverlay(this, mapView);
		myLocationOverlay.enableMyLocation();
		mapView.getOverlays().add(myLocationOverlay);
		mapView.postInvalidate();

		mc = mapView.getController();
		myLocationOverlay.runOnFirstFix(new Runnable() {
			public void run() {
				GeoPoint gp = myLocationOverlay.getMyLocation();
				mc.setZoom(zoomLevel);
				mc.animateTo(gp);
				mc.setCenter(gp);
			}
		});
	}

	/**
	 * Change to campus lindholmen.
	 */
	public void changeToCampusLindholmen() {

		mc = mapView.getController();
		gp = new GeoPoint((int) (lindholmenLat), (int) (lindholmenLon));
		mc.animateTo(gp);
		mc.setCenter(gp);
		mc.setZoom(zoomLevel);
		Toast.makeText(TheMap.this,
				R.string.campusLindholmen,
				Toast.LENGTH_SHORT).show();
		activeCampus = false;
	}


	/**
	 * Change to campus johanneberg.
	 */

	public void changeToCampusJohanneberg() {

		mc = mapView.getController();
		gp = new GeoPoint((int) (johannebergLat), (int) (johannebergLon));
		mc.animateTo(gp);
		mc.setCenter(gp);
		mc.setZoom(zoomLevel);
		Toast.makeText(TheMap.this, R.string.campusJohanneberg, Toast.LENGTH_SHORT)
				.show();
		activeCampus = true;
	}

	/**
	 * Start pub list activity.
	 */
	public void startPubListActivity() {

		// default PubList.class in development test using PubInfo.class
		Intent i = new Intent(this, PubList.class); // context = this ,
													// PubList.class =
													// ClassToNavigateTo.class
		startActivity(i);
	}

	// Required method since class extends MapActivity
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.google.android.maps.MapActivity#isRouteDisplayed()
	 */
	@Override
	protected boolean isRouteDisplayed() {
		return false; // Don't display a route
	}

	// Initiating Menu XML file (menu.xml)
	/**
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater oMenu = getMenuInflater();
		oMenu.inflate(R.menu.menu, menu);
		return true;
	}

	// onOptionsMenu with three items, "Street", "Satellite" & Traffic... code
	// refactor is needed!
	/**
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.change_map:
			new AlertDialog.Builder(this).setTitle("Ändra vy")
					.setSingleChoiceItems(differentViews, defaultIntValue,
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
			break;
			
		case R.id.settings:
			Intent settingsActivity = new Intent(getBaseContext(),
					SettingsMenu.class);
			startActivity(settingsActivity);
			break;

		case R.id.share:
			// Creates a string with text and a link to the app to be shared via prefered app
			Intent showShare = new Intent(Intent.ACTION_SEND);
			showShare.setType("text/plain");
			String title = (String) getResources().getText(R.string.shareTitle);
			String appLink = (String) getResources().getText(R.string.shareLink);
			showShare.putExtra(Intent.EXTRA_TEXT, appLink);
			startActivity(Intent.createChooser(showShare, title));
			break;
		}
		return true;
		
	}

	/**
	 * Attempts to enable MyLocation, registering for updates from
	 * LocationManager.GPS_PROVIDER and LocationManager.NETWORK_PROVIDER.
	 * 
	 * @see com.google.android.maps.MapActivity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		// when our activity resumes, we want to register for location updates
		myLocationOverlay.enableMyLocation();
	}

	/**
	 * Stops location updates.
	 * 
	 * @see com.google.android.maps.MapActivity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		// when our activity pauses, we want to remove listening for location
		myLocationOverlay.disableMyLocation();
	}

	/**
	 * On tab changed.
	 * 
	 * @param tabId
	 *            the tab id
	 */
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub

	}

	/**
	 * Called when the user press back button in the TheMap.
	 */
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setTitle("Avsluta")
				// Title: "Avsluta"
				.setIcon(R.drawable.icon_warning)
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
								System.exit(0); // if "Ja, avsluta" exit and
												// remove location/network
												// services for this app
							}
						}).create().show();
	}

	/**
	 * Check if gps is enabled.
	 */
	public void checkIfGpsIsEnabled() {
		final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			noGpsDialog();
		}
	}

	/**
	 * No gps dialog.
	 */
	public void noGpsDialog() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("GPS avstängd")
				.setMessage("Din GPS är avstängd, vill du starta den?")
				.setIcon(R.drawable.icon_warning)
				.setCancelable(false)
				.setNeutralButton("Ja",
						new android.content.DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								startActivity(new Intent(
										Settings.ACTION_LOCATION_SOURCE_SETTINGS));
							}
						})
				.setNegativeButton("Nej",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								dialog.cancel();
							}
						});
		final AlertDialog ad = builder.create();
		ad.show();
	}

	/**
	 * On location changed.
	 * 
	 * @param location
	 *            the location
	 */	
	public void onLocationChanged(Location location) {  
	}

	/**
	 * On provider disabled.
	 * 
	 * @param provider
	 *            the provider
	 */
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	/**
	 * On provider enabled.
	 * 
	 * @param provider
	 *            the provider
	 */
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	/**
	 * On status changed.
	 * 
	 * @param provider
	 *            the provider
	 * @param status
	 *            the status
	 * @param extras
	 *            the extras
	 */
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onDoubleTapEvent(android
	 * .view.MotionEvent)
	 */
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onSingleTapConfirmed
	 * (android.view.MotionEvent)
	 */
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * On down.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * On fling.
	 * 
	 * @param e1
	 *            the e1
	 * @param e2
	 *            the e2
	 * @param velocityX
	 *            the velocity x
	 * @param velocityY
	 *            the velocity y
	 * @return true, if successful
	 */
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * On long press.
	 * 
	 * @param e
	 *            the e
	 */
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * On scroll.
	 * 
	 * @param e1
	 *            the e1
	 * @param e2
	 *            the e2
	 * @param distanceX
	 *            the distance x
	 * @param distanceY
	 *            the distance y
	 * @return true, if successful
	 */
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * On show press.
	 * 
	 * @param e
	 *            the e
	 */
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * On single tap up.
	 * 
	 * @param e
	 *            the e
	 * @return true, if successful
	 */
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.gesture.GestureOverlayView.OnGestureListener#onGesture(android
	 * .gesture.GestureOverlayView, android.view.MotionEvent)
	 */
	public void onGesture(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.gesture.GestureOverlayView.OnGestureListener#onGestureCancelled
	 * (android.gesture.GestureOverlayView, android.view.MotionEvent)
	 */
	public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.gesture.GestureOverlayView.OnGestureListener#onGestureEnded(android
	 * .gesture.GestureOverlayView, android.view.MotionEvent)
	 */
	public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.gesture.GestureOverlayView.OnGestureListener#onGestureStarted
	 * (android.gesture.GestureOverlayView, android.view.MotionEvent)
	 */
	public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}
	
	class MyOverlay extends Overlay {

		private int endPoint;

		public MyOverlay(int endPoint) {

			this.endPoint=endPoint;
		}

		public void draw(Canvas canvas, MapView mapv, boolean shadow) {
			super.draw(canvas, mapv, shadow);
			// Configuring the paint brush
			Paint mPaint = new Paint();
			mPaint.setDither(true);
			mPaint.setColor(Color.BLUE);
			mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			mPaint.setStrokeJoin(Paint.Join.ROUND);
			mPaint.setStrokeCap(Paint.Cap.ROUND);
			mPaint.setStrokeWidth(strokeWidthIsFour);

			GeoPoint gp1 = new GeoPoint((int) (57.689814 * 1E6), (int) (11.972988 * 1E6));  // for development, geopoint of chalmers entrance, starting point
			GeoPoint gp2 = allPubsArray[endPoint].getPoint();	// End point

			Path path1 = new Path();

			Point p1 = new Point();
			Point p2 = new Point();
			projection.toPixels(gp2, p1);
			projection.toPixels(gp1, p2);

			path1.moveTo(p2.x, p2.y);	// Moving to next pub
			path1.lineTo(p1.x, p1.y);	// Path till next pub

			canvas.drawPath(path1, mPaint);// Actually drawing the path from first GeoPoint to second

		}
	}

}