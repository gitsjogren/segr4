package com.tarea.pubrundan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;

/*
 * The settings-menu where you're able to change your default
 * campus, send feedback on the application, see information about
 * the application itself and other features.
 */

public class SettingsMenu extends PreferenceActivity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		SharedPreferences SP = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		Preference aboutPage = (Preference) findPreference("aboutPage");
		aboutPage
				.setOnPreferenceClickListener(new OnPreferenceClickListener() {

					public boolean onPreferenceClick(Preference preference) {
						Intent AboutActivity = new Intent(getBaseContext(),
								AboutPage.class);
						startActivity(AboutActivity);
						return true;
					}

				});

		/*
		 * Get all options in res/xml/settings.xml
		 */
		String defaultCampus = SP.getString("defaultCampus", "true");
		String about = SP.getString("aboutPage", "");
	}

}
