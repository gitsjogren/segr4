package com.tarea.pubrundan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsMenu extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		getSettings();
	}

	protected void getSettings() {
		SharedPreferences SP = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		String defaultCampus = SP.getString("defaultCampus", "true");

	}

}
