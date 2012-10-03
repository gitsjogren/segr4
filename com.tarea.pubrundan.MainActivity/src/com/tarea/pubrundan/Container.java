package com.tarea.pubrundan;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Container extends TabActivity {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            TabHost host = getTabHost();
            host.addTab(host.newTabSpec("one").setIndicator("TAB1").setContent(new Intent(this, Tab1Activity.class)));
            host.addTab(host.newTabSpec("two").setIndicator("Karta").setContent(new Intent(this, MapOfJohanneberg.class)));
            host.addTab(host.newTabSpec("three").setIndicator("Lista").setContent(new Intent(this, Tab2Activity.class)));
            host.setCurrentTab(0);
    }
}
