package com.tarea.pubrundan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class PubList extends Activity {
	
	private Button goBackToMapButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);  // Suppress title bar for more space
            setContentView(R.layout.publist);

            // Button to control access overlay
            goBackToMapButton = (Button)findViewById(R.id.pubList);
            goBackToMapButton.setOnClickListener(new OnClickListener(){
            	public void onClick(View v) {	
                     onBackPressed();       
                }
            });
	}
	
}

// super.onBackPressed(); // back button OR finish()
