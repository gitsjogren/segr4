package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class FeedbackForm extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedbackform);
		
		final Button BtnSendFeedback = (Button) this.findViewById(R.id.BtnSendFeedback);
		BtnSendFeedback.setOnClickListener(new View.OnClickListener() {
					
			public void onClick(View v) {
				
				final EditText nameField = (EditText) findViewById(R.id.EditTextName);  
				String name = nameField.getText().toString();  
				final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);  
				String email = emailField.getText().toString();  
				final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);  
				String feedback = feedbackField.getText().toString();  
			
				final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);  
				String feedbackType = feedbackSpinner.getSelectedItem().toString(); 
				final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);  
				boolean boxReqResponse = responseCheckbox.isChecked();
				
				String mottagare = "skrootmejl@gmail.com";
				Intent m = new Intent(Intent.ACTION_SEND);
				m.setType("message/rfc822");
				m.putExtra(Intent.EXTRA_EMAIL	,	new String[]{mottagare});
				m.putExtra(Intent.EXTRA_SUBJECT , 	feedbackType);
				m.putExtra(Intent.EXTRA_TEXT	,	name);
				m.putExtra(Intent.EXTRA_TEXT, email);
				m.putExtra(Intent.EXTRA_TEXT, feedback);
			}
		});
		// Get the context from the feedback form
		
//	    
//		
//		// Add ClickListener for the button
//				View sendButton = findViewById(R.id.ButtonSendFeedback);
//				sendButton.setOnClickListener(new View.OnClickListener() {
//					
//				public void onClick(View v) {
//						switch(v.getId()) {
//						case R.id.ButtonSendFeedback:
//							Intent i = new Intent(this, SettingsMenu.class);
//							startActivity(i);
//							break;
//						}
//					}
//				}
	}
}
//	}
//		if (boxReqResponse == true) {
//			String reqResponse = "Requires a response";
//		}
//		else {
//			String reqResponse = "No response required";
//		}
//		
		



//public void sendFeedback() {
//	switch(button.getId()) {
//	case R.id.ButtonSendFeedback:
