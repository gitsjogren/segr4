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
import android.view.*;
import android.widget.*;

/**
 * The class FeedbackForm
 * 
 * @author Rickard Edfast
 * 
 */

public class FeedbackForm extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedbackform);

		final Button SendFeedback = (Button) this
				.findViewById(R.id.ButtonSendFeedback);
		SendFeedback.setOnClickListener(new View.OnClickListener() {

			// Get the context from the feedback form
			public void onClick(View v) {

				final EditText nameField = (EditText) findViewById(R.id.EditTextName);
				String name = nameField.getText().toString();

				final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
				String email = emailField.getText().toString();

				final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
				String feedback = feedbackField.getText().toString();

				final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
				String feedbackSubject = feedbackSpinner.getSelectedItem()
						.toString();

				final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
				boolean boxReqResponse = responseCheckbox.isChecked();

				String response = "";
				if (boxReqResponse) {
					response = "Requires a response";
					if (email == null) {
						// Create dialogbox: "Du måste ange en mailadress"
					}
				} else {
					if (name == null || feedback == null) {
						Toast.makeText(getBaseContext(), "else i feedback",
								Toast.LENGTH_SHORT).show();
						// Create dialogbox: "Namn och feedback måste fyllas i"
					}
				}
				String person = (("Namn: ") + name + ("\nEmailadress: ")
						+ email + ("\nMeddelande: "));
				String feedbackMejlen = "feedbacktarea@gmail.com";

				Intent sendMail = new Intent(Intent.ACTION_SEND);
				sendMail.setType("message/rfc822");
				sendMail.putExtra(Intent.EXTRA_EMAIL,
						new String[] { feedbackMejlen });
				sendMail.putExtra(Intent.EXTRA_SUBJECT, feedbackSubject);
				sendMail.putExtra(Intent.EXTRA_TEXT, person + feedback
						+ response);
				// Either launches a dialog box with available mail-apps or
				// starts the users default choice
				startActivity(sendMail);
			}
		});

	}
}