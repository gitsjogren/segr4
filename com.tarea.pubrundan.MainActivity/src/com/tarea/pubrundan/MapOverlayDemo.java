package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MapOverlayDemo extends Activity implements OnClickListener {
        
    static Context context;
        
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        // Get application context for later use
        context = getApplicationContext();
        
        // Add ClickListener for the button
        View firstButton = findViewById(R.id.mapshow_button);
        firstButton.setOnClickListener(this); 

    }

    public void onClick(View v) {  // coordinates for johanneberg
        double lat = 57.689034;
        double lon = 11.976468;
        switch(v.getId()){
            case R.id.mapshow_button:		
                Intent i = new Intent(this, ShowTheMap.class);
                ShowTheMap.putLatLong(lat, lon);
                startActivity(i);
                break;		
        }	
    }
        
    // Create a static method to show toasts (not presently used but included
    // as an example)
    
    public static void showToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

}
