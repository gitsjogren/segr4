<<<<<<< HEAD

=======
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb
package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
<<<<<<< HEAD

public class WelcomeScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 1000;
=======
import android.view.WindowManager;

public class WelcomeScreen extends Activity {

    private final static int display_length = 2000;
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
<<<<<<< HEAD
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
=======
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb
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
<<<<<<< HEAD
        }, SPLASH_DISPLAY_LENGHT);
    }
}
=======
        }, display_length);
    }
}
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb
