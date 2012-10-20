package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
<<<<<<< HEAD

public class WelcomeScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 1000;
=======
import android.view.Window;
import android.view.WindowManager;

public class WelcomeScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;
>>>>>>> origin/Branch-for-theMap

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
<<<<<<< HEAD
=======
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
>>>>>>> origin/Branch-for-theMap
        super.onCreate(icicle);
        setContentView(R.layout.welcome);

        /* New Handler to start the MainActivity 
         * and close this WelcomeScreen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
          
        	public void run() {
              
        		/* Create an Intent that will start the MainActivity. */
<<<<<<< HEAD
                Intent mainIntent = new Intent(WelcomeScreen.this,MainActivity.class);
=======
                Intent mainIntent = new Intent(WelcomeScreen.this,TheMap.class);
>>>>>>> origin/Branch-for-theMap
                WelcomeScreen.this.startActivity(mainIntent);
                WelcomeScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/Branch-for-theMap
