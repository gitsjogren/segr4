package com.tarea.pubrundan;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Window;
import android.widget.TextView;

public class AboutPage extends Activity {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);

		TextView noteView = (TextView) findViewById(R.id.iconshock);
		noteView.setText("http://www.iconshock.com");
		Linkify.addLinks(noteView, Linkify.ALL);


	}
}