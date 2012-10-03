package com.tarea.pubrundan;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AppMain extends TabActivity  {
 TabHost mTabHost;
 FrameLayout mFrameLayout;

 /** Called when the activity is first created.*/
 @Override
 public void onCreate(Bundle savedInstanceState) {
    
	 super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    mTabHost = getTabHost();
    
    TabSpec tabSpec = mTabHost.newTabSpec("tab_test1");
    tabSpec.setIndicator("Tab1");
    Context ctx = this.getApplicationContext();
    Intent i = new Intent(ctx, Tab1Activity.class);
    tabSpec.setContent(i);
    mTabHost.addTab(tabSpec);
    
    TabSpec tabSpec2 = mTabHost.newTabSpec("tab_test2");
    tabSpec2.setIndicator("Map");
    Context ctx2 = this.getApplicationContext();
    Intent j = new Intent(ctx2, MapOverlayDemo.class);
    tabSpec2.setContent(j);
    mTabHost.addTab(tabSpec2);
    
    TabSpec tabSpec3 = mTabHost.newTabSpec("tab_test3");
    tabSpec3.setIndicator("Tab2");
    Context ctx3 = this.getApplicationContext();
    Intent k = new Intent(ctx3, Tab2Activity.class);
    tabSpec3.setContent(k);
    mTabHost.addTab(tabSpec3);
    
    mTabHost.setCurrentTab(1);
 }
}