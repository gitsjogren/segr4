package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeScreen extends Activity{
	
    // Set the display time, in milliseconds (or extract it out as a configurable parameter)
    private final int SPLASH_DISPLAY_LENGTH = 3000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }
 
    @Override
    protected void onResume()
    {
        super.onResume();

            new Handler().postDelayed(new Runnable()
            {
                public void run()
                {
                    //Finish the splash activity so it can't be returned to.
                    WelcomeScreen.this.finish();
                    // Create an Intent that will start the main activity.
                    Intent mainIntent = new Intent(WelcomeScreen.this, MainActivity.class);
                    WelcomeScreen.this.startActivity(mainIntent);
                }
            }, SPLASH_DISPLAY_LENGTH);
        }

        
    }
