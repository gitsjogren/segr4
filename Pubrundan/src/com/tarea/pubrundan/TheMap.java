package com.tarea.pubrundan;

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
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
import com.tarea.pubrundan.Pubs.JAPripps;

//### This class follows some code examples from http://eagle.phys.utk.edu/guidry/android/index.html  ###//

public class TheMap extends MapActivity {

	private SharedPreferences sharedPrefs;

	/*
	 * Boolean that tells the application which campus that
	 * is currently the one the user is looking at. 
	 * Used for the 'Byt Campus'-button.
	 */
	private boolean activeCampus;
	
	private String default_campus;
	private int zoomLevel = 17;
	private MapController mc;
	private GeoPoint gp;
	private MapView mapView;

	/* Buttons shown on top of TheMap */
	private Button getThePositionButton, changeCampusButton, goToPubListButton;

	/* An Overlay showing a blue dot, which indicates your location */
	private MyLocationOverlay myLocationOverlay;

	private List<Overlay> mapOverlays;
	private Drawable drawable;
	private OverlayClass itemizedOverlay;

	/* The different view selections of the map */
	private final CharSequence[] differentViews = { "Street", "Satellite",
			"Traffic" };

	/*
	 * Define an array containing the access overlay items for all of the pubs
	 * of Johanneberg and Lindholmen Coordinates need to be converted into
	 * integers, by default they are displayed in microdegrees
	 */

	/*
	 * The pubs in the array are listed and hardcoded from
	 * coordinates_of_the_pubs.txt
	 */
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
					(int) (57.687302 * 1E6)), "FortNOx", "Johanneberg"),
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
					(int) (11.936675 * 1E6)), "11:an", "Johanneberg"),

	};

	/* Standard onCreate-method */
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

	}

	/*
	 * Method that gets the value for default campus if the
	 * application itself has been closed.
	 */
	private void getDefaultCampus() {
		default_campus = sharedPrefs.getString("defaultCampus", "0");
		
		if(default_campus.equals("0"))
			activeCampus = true;
		
		else if(default_campus.equals("1"))
			activeCampus = false;
	}

	/*
	 * A dialog that lets the user set the default campus, on the first run
	 * only, that will make the application navigate there on start.
	 */
	private void setDefaultCampus() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Standard campus")
				.setMessage("Var vänlig och välj standard campus för kartan.")
				.setIcon(R.drawable.icon_warning)
				.setCancelable(false)
				.setNeutralButton("Johanneberg",
						new android.content.DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								default_campus = "0";
								SharedPreferences.Editor editor = sharedPrefs
										.edit();
								editor.putString("defaultCampus", "0");
								editor.commit();
								activeCampus = true;
								loading();
								
							}
						})
				.setNegativeButton("Lindholmen",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {
								default_campus = "1";
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

	/*
	 * A simple method to check if the application is run for the first time.
	 */
	public boolean firstRun() {
		return sharedPrefs.getBoolean("firstRun", true);
	}

	/*
	 * A method that sets the application to "not first run"
	 */
	public void setRunned() {
		SharedPreferences.Editor edit = sharedPrefs.edit();
		edit.putBoolean("firstRun", false);
		edit.commit();
	}

	/*
	 * Sets the application for first run.
	 *  0 = Only this app can read these preferences.
	 */
	public void firstRunPreferences() {
		Context mContext = this.getApplicationContext();
		sharedPrefs = mContext.getSharedPreferences("myAppPrefs", 0); 
	}

	private void loading() {

		final Object loadingDialog = ProgressDialog.show(this,
				"Laddar pubbar...", "Vänta...", true);
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

					sleep(3000); // sleep the thread, 3000 milliseconds = 3
									// seconds.
				} catch (Exception e) {
				}
				((Dialog) loadingDialog).dismiss();
			}

		}.start();
	}

	/*
	 * Zooms into the campus that the user has chosen.
	 */
	protected void showDefaultCampus() {
		if (default_campus.equals("0")){
			changeToCampusJohanneberg();
			activeCampus = true;
		}

		else if (default_campus.equals("1")){
			changeToCampusLindholmen();
			activeCampus = false;
			
		}
	}

	/*
	 * Used to for the 'Byt Campus' button which looks
	 * at the current campus and jumps between the two,
	 * depending on which campus you have as active.
	 */
	public void changeCampus(){
		if(activeCampus)
			changeToCampusLindholmen();
			
		else if(!activeCampus)
			changeToCampusJohanneberg();
	}	

	
	/* The map will navigate to your current position */
	public void showTheCurrentPosition() {
		myLocationOverlay = new MyLocationOverlay(this, mapView);
		myLocationOverlay.enableMyLocation();
		mapView.getOverlays().add(myLocationOverlay);

		mc = mapView.getController();
		myLocationOverlay.runOnFirstFix(new Runnable() {
			public void run() {
				mc.setZoom(zoomLevel);
				mc.animateTo(myLocationOverlay.getMyLocation());
			}
		});
	}

	/* Display all pubs in the allPubsArray as an overlay onto the map */
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
			mapOverlays.add(itemizedOverlay);
		}
		/*
		 * Added symbols will be displayed when map is redrawn so force redraw
		 * now
		 */
		mapView.postInvalidate();
	}

	/* Navigate to campus Lindholmen if users click on the changeCampusButton */
	public void changeToCampusLindholmen() {

		mc = mapView.getController();
		gp = new GeoPoint((int) (57.705947 * 1e6), (int) (11.936642 * 1e6));
		mc.animateTo(gp);
		mc.setZoom(zoomLevel);
		Toast.makeText(TheMap.this,
				"Campus Lindholmen",
				Toast.LENGTH_SHORT).show();
		activeCampus = false;
	}

	/* Navigate to campus Johanneberg if users click on the changeCampusButton */
	public void changeToCampusJohanneberg() {

		mc = mapView.getController();
		gp = new GeoPoint((int) (57.689034 * 1e6), (int) (11.976468 * 1e6));
		mc.animateTo(gp);
		mc.setZoom(zoomLevel);
		Toast.makeText(TheMap.this, "Campus Johanneberg", Toast.LENGTH_SHORT)
				.show();
		activeCampus = true;
	}

	// starting new activity( PubList.java ) if user clicks goToPubListButton
	public void startPubListActivity() {

		// default PubList.class in development test using PubInfo.class
		Intent i = new Intent(this, PubList.class); // context = this ,
													// PubList.class =
													// ClassToNavigateTo.class
		startActivity(i);
	}

	// starting new activity( PubInfo.java ) if user clicks goToPubListButton
	public void startPubInfoActivity() {

		// default PubList.class in development test using PubInfo.class
		Intent i = new Intent(this, JAPripps.class); // context = this ,
														// PubInfo.class =
														// ClassToNavigateTo.class
		startActivity(i);
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

			Intent settingsActivity = new Intent(getBaseContext(),
					SettingsMenu.class);
			startActivity(settingsActivity);

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
		// onPause, pressing home-button for example the GPS will be turned off,
		// onResme will start it again
		// LocationManager manager = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		// manager.removeUpdates(this);
		// manager = null;
		myLocationOverlay.disableMyLocation();
	}

	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub

	}

	/** Called when the user press back button in the TheMap */
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

	public void checkIfGpsIsEnabled() {
		final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			NoGpsDialog();
		}
	}

	public void NoGpsDialog() {
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

	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}