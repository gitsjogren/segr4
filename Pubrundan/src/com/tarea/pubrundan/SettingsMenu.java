package com.tarea.pubrundan;

import android.content.*;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/*
 * The settings-menu where you're able to change your default
 * campus, send feedback on the application, see information about
 * the application itself and other features.
 */

public class SettingsMenu extends PreferenceActivity {

	/*
	 * (non-Javadoc)
	 * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

		/*
		 * Get all options in res/xml/settings.xml
		 */
		String defaultCampus = SP.getString("defaultCampus", "true");
		
		Preference feedback = (Preference) findPreference("feedback");
		feedback.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				Intent i = new Intent(getApplicationContext(), FeedbackForm.class);
				startActivity(i);
				return true;
			}
		});
	}
	

}
