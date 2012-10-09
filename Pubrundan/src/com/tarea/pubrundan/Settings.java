package com.tarea.pubrundan;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.widget.Toast;

public class Settings extends PreferenceActivity{
	
	  @Override
      public void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.main);
              Button prefBtn = (Button) findViewById(R.id.prefButton);
              prefBtn.setOnClickListener(new OnClickListener() {

                      public void onClick(View v) {
                              Intent settingsActivity = new Intent(getBaseContext(),
                                              Preferences.class);
                              startActivity(settingsActivity);
                      }
              });
      }
}


