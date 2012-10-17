package com.tarea.pubrundan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
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
				String person = name + (" , ") + email;
				
				try {
					Toast.makeText(FeedbackForm.this, "email sent", Toast.LENGTH_SHORT)
					.show();
					GmailSender sender = new GmailSender("feedbacktarea@gmail.com", "tarearu13z");
					sender.sendMail(feedbackType, feedback, person, "feedbacktarea@gmail.com");
				} catch (Exception e) {
					Toast.makeText(FeedbackForm.this, "email error", Toast.LENGTH_SHORT)
					.show();
					Log.e("SendMail", e.getMessage(), e);
				}
				
				Intent i = new Intent(getBaseContext(), SettingsMenu.class);
				startActivity(i);
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
//							
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
