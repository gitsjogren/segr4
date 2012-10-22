package com.tarea.pubrundan.test;

import com.jayway.android.robotium.solo.Solo;

import com.tarea.pubrundan.AboutPage;
import com.tarea.pubrundan.FeedbackForm;
import com.tarea.pubrundan.PubLayout;
import com.tarea.pubrundan.PubList;
import com.tarea.pubrundan.SettingsMenu;
import com.tarea.pubrundan.TheMap;
import android.test.ActivityInstrumentationTestCase2;

public class ButtonTests extends ActivityInstrumentationTestCase2<TheMap> {

	private Solo solo;
	
	public ButtonTests(){
		super("com.tarea.pubrundan", TheMap.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	
	public void testButtons(){
		solo.assertCurrentActivity("Activity is not TheMap", TheMap.class);
		solo.clickOnButton("Min position");
		solo.clickOnButton("Byt campus");
		solo.clickOnButton("Publista");
		solo.assertCurrentActivity("Activity is not Publist", PubList.class);
		
		for(int i=1; i<6; i++){
		solo.clickInList(i);
		solo.assertCurrentActivity("Activity", PubLayout.class);
		solo.goBack();
	}
		solo.goBack();
		solo.assertCurrentActivity("Activity is not TheMap", TheMap.class);
		solo.clickOnMenuItem("Inställningar");
		solo.assertCurrentActivity("Activity is not SettingsMenu", SettingsMenu.class);
		solo.clickOnText("Default campus");
		solo.clickInList(0);
		solo.clickOnText("Send feedback");
		solo.assertCurrentActivity("Activity is not FeedbackForm", FeedbackForm.class);
		solo.goBack();
		solo.goBack();
		solo.clickOnText("About");
		solo.assertCurrentActivity("Activity is not AboutPage", AboutPage.class);
		solo.goBack();
		solo.goBack();
		solo.assertCurrentActivity("Activity is not TheMap", TheMap.class);
		
		for(int j=1; j<4; j++){
		solo.clickOnMenuItem("Ändra vy");
		solo.clickInList(j);
	}
		solo.clickOnMenuItem("Tipsa vän");
		solo.goBack();
		solo.assertCurrentActivity("Activity is not TheMap", TheMap.class);
		
	}
}
