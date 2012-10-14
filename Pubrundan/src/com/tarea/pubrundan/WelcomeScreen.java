
package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class WelcomeScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 1000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(icicle);
        setContentView(R.layout.welcome);

        /* New Handler to start the MainActivity 
         * and close this WelcomeScreen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
          
        	public void run() {
              
        		/* Create an Intent that will start the MainActivity. */
                Intent mainIntent = new Intent(WelcomeScreen.this,TheMap.class);
                WelcomeScreen.this.startActivity(mainIntent);
                WelcomeScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
