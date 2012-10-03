package com.tarea.pubrundan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

 // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
 
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
// 
//        switch (item.getItemId())
//        {
//        case R.id.menu_change_map:
//            // Single menu item is selected do something
//            // Ex: launching new activity/screen or show alert message
//            Toast.makeText(MainActivity.this, "Kartvy är valt", Toast.LENGTH_SHORT).show();
//            return true;
// 

    
    /** Called when the user clicks the "get location" button */
    public void getLocationButton(View view) {
        Intent intent = new Intent(this, MapOfJohanneberg.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the "Byt campus" button */
    public void changeCampusButton(View view) {
        Intent intent = new Intent(this, MapOfJohanneberg.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the "list view" button */
    public void listViewButton(View view) {
        Intent intent = new Intent(this, PubList.class);
        startActivity(intent);
    }
    
    /** Called when the user press back button in the MainActivity */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
            .setTitle("Avsluta")
            .setMessage("Säker på att du vill avsluta?")
            .setNegativeButton("Nej", null)
            .setPositiveButton("Ja, avsluta!", new OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    MainActivity2.super.onBackPressed();
                }
            }).create().show();
    }
}
