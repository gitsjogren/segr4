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

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.maps.MapView;

/**
 * The class OnDoubleTap
 * 
 * @author Erik Sjögren
 * 
 */
public class OnDoubleTap extends MapView {

	/** The last touch time. */
	private static long lastTouchTime = -1;

	private final int milliValue = 250; // to make double tap, the next
												// tap must tapped <250
												// milliseconds after the first
												// tap

	/**
	 * Instantiates a new double tap.
	 * 
	 * @param context
	 *            the context
	 * @param attrs
	 *            the attrs
	 */
	public OnDoubleTap(Context context, AttributeSet attrs) {

		super(context, attrs);	// passes parameters to superclass, context and attrs contructs a mapView object
	}

	/*
	 * onInterceptTouchEvent, listen for any MotionEvent to happen
	 * 
	 * @param ev
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {

		if (ev.getAction() == MotionEvent.ACTION_DOWN) { // if user tap
															// somewhere do
															// things within
															// braces

			long thisTime = System.currentTimeMillis(); // sets thisTime to the
														// systems current time
														// in milliseconds
			if (thisTime - lastTouchTime < milliValue) {	// if current time(msec) minus the value of lastTouchTime is less than 250 msec, zoom in one zoomlevel = a double tap

				this.getController().zoomInFixing((int) ev.getX(), // get
																	// controller
																	// from
																	// MapController
																	// using
																	// zoomInFixing()
																	// to zoom
																	// in one
																	// zoomlevel
																	// depending
																	// on the
																	// tapped
																	// pixels on
																	// the
																	// device
						(int) ev.getY());
				// Double tap
				lastTouchTime = -1;

			} else {

				lastTouchTime = thisTime; // Too slow
			}
		}

		return super.onInterceptTouchEvent(ev); // return boolean true, if
												// successful
	}
}
