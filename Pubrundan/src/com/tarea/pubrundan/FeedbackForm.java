package com.tarea.pubrundan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class FeedbackForm extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedbackform);
		
		final Button SendFeedback = (Button) this.findViewById(R.id.ButtonSendFeedback);
		SendFeedback.setOnClickListener(new View.OnClickListener() {
					

		// Get the context from the feedback form
			public void onClick(View v) {
				
				
				final EditText nameField = (EditText) findViewById(R.id.EditTextName);  
				String name = nameField.getText().toString(); 
//				if(name == ""){
//					// Create dialogbox: "alla fält måste vara ifyllda"
//				}
					
				final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);  
				String email = emailField.getText().toString();
				
				final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);  
				String feedback = feedbackField.getText().toString();  
			
				final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);  
				String feedbackSubject = feedbackSpinner.getSelectedItem().toString(); 
				
				final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);  
				boolean boxReqResponse = responseCheckbox.isChecked();
				
//				if(boxReqResponse == true){
//					if(email == ""){
//						// Create dialogbox: "Du måste ange en mailadress"
//					}
//				}
				
//				if(name == "" || feedback == ""){
//					// Create dialogbox: "Namn och feedback måste fyllas i"
//				}
					
				String person = (("Namn: ") + name + ("\nEmailadress: ") + email + ("\nMeddelande: "));
				String feedbackMejlen = "feedbacktarea@gmail.com";
				
				
				Intent sendMail = new Intent(Intent.ACTION_SEND);
				sendMail.setType("text/plain");
				sendMail.putExtra(Intent.EXTRA_EMAIL, new String[] {feedbackMejlen});
				sendMail.putExtra(Intent.EXTRA_SUBJECT, feedbackSubject);
				sendMail.putExtra(Intent.EXTRA_TEXT, person+feedback);
				startActivity(Intent.createChooser(sendMail, "Send feedback via..."));
				
//				Intent i = new Intent(getBaseContext(), SettingsMenu.class);
//				startActivity(i);
			}
		});
	
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
