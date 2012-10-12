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

// TODO: Auto-generated Javadoc
/**
 * The class OnDoubleTap
 * 
 * @author Erik Sjögren
 * 
 */
public class OnDoubleTap extends MapView {

	  /** The last touch time. */
  	private long lastTouchTime = -1;
  	private int millivalue = 250;

	  /**
  	 * Instantiates a new on double tap.
  	 *
  	 * @param context the context
  	 * @param attrs the attrs
  	 */
  	public OnDoubleTap(Context context, AttributeSet attrs) {

	    super(context, attrs);
	  }

	  /* (non-Javadoc)
  	 * @see android.view.ViewGroup#onInterceptTouchEvent(android.view.MotionEvent)
  	 * 
  	 * @param ev
  	 * 
  	 * @return true, if successful
  	 */
  	@Override
	  public boolean onInterceptTouchEvent(MotionEvent ev) {

	    if (ev.getAction() == MotionEvent.ACTION_DOWN) {

	      long thisTime = System.currentTimeMillis();
	      if (thisTime - lastTouchTime < millivalue) {

	        // Double tap
	        this.getController().zoomInFixing((int) ev.getX(), (int) ev.getY());
	        lastTouchTime = -1;

	      } else {

	        // Too slow 
	        lastTouchTime = thisTime;
	      }
	    }

	    return super.onInterceptTouchEvent(ev);
	  }
	}
