package com.tarea.pubrundan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// Initiating Menu XML file (menu.xml)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.layout.menu, menu);
		return true;
	}

	/** Called when the user press back button in the MainActivity */
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this).setTitle("Avsluta")
				.setMessage("Säker på att du vill avsluta?")
				.setNegativeButton("Nej", null)
				.setPositiveButton("Ja, avsluta!", new OnClickListener() {

					public void onClick(DialogInterface arg0, int arg1) {
						MainActivity.super.onBackPressed();
					}
				}).create().show();
	}
}
