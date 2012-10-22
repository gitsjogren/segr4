/* ============================================================
 * Copyright © 2012 Adam Book, Rickard Edfast, Erik Sjögren,
 * Alexander Kurkimäki
 *
 * This file is part of Pubrundan.
 *
 * Pubrundan is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pubrundan is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Pubrundan. If not, see <http://www.gnu.org/licenses/>.
 * ============================================================ */

package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * The class TheMap
 * 
 * @author Alexander Kurkimäki
 * 
 */

public class WelcomeScreen extends Activity {

    private final int displayLength = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        }, displayLength);
    }
}