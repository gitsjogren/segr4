package com.tarea.pubrundan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;

/**
 * The settings-menu where you're able to change your default
 * campus, send feedback on the application, see information about
 * the application itself and other features.
 */


public class SettingsMenu extends PreferenceActivity {


	/**
	 * (non-Javadoc)
	 * 
	 * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		final SharedPreferences sP = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		/**
		 * A clickable "preference" which starts the About-section within
		 * the SettingsMenu.
		 */
		Preference aboutPage = (Preference) findPreference("aboutPage");
		aboutPage
				.setOnPreferenceClickListener(new OnPreferenceClickListener() {

					public boolean onPreferenceClick(Preference preference) {
						Intent aboutPage = new Intent(getBaseContext(),
								AboutPage.class);
						startActivity(aboutPage);
						return true;
					}

				});


		/**
		 * When the value is changed in the Default Campus settings the new value 
		 * is stored in the SharedPreferences to be reminded each time you start
		 * the application.
		 */
		Preference defaultCampus = (Preference) findPreference("defaultCampus");
		defaultCampus.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			public boolean onPreferenceChange(Preference preference, Object newValue) {

				SharedPreferences.Editor editor = sP.edit();
				editor.putString("defaultCampus", (String) newValue);
				editor.commit();
				return true;
			}
		});
		
		Preference feedback = (Preference) findPreference("feedback");
		feedback.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			public boolean onPreferenceClick(Preference preference) {
					Intent i = new Intent(getApplicationContext(), FeedbackForm.class);
					startActivity(i);
					return true;
				}
		});

		/**
		 * Get all options in res/xml/settings.xml
		 */
		sP.getString("defaultCampus", "0");
		sP.getString("aboutPage", "");
		sP.getString("feedback", "");

	}

}