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
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Window;
import android.widget.TextView;

/**
 * The class AboutPage
 * 
 * @author Alexander Kurkimäki
 * 
 */

public class AboutPage extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

<<<<<<< HEAD
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
=======
		requestWindowFeature(Window.FEATURE_NO_TITLE);
>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb
		setContentView(R.layout.about);

		TextView noteView = (TextView) findViewById(R.id.iconshock);
		noteView.setText("http://www.iconshock.com");
		Linkify.addLinks(noteView, Linkify.ALL);
<<<<<<< HEAD
		
=======

>>>>>>> 368d9c8d2f2579eb18102e53e045dca03ee590bb

	}
}