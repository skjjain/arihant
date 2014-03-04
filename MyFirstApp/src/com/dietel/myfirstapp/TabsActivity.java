package com.dietel.myfirstapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.TabActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.content.Intent;

@SuppressWarnings("deprecation")
public class TabsActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrolling_tabs);

		// create the TabHost that will contain the Tabs
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec tab1 = tabHost.newTabSpec("First Tab");
		TabSpec tab2 = tabHost.newTabSpec("Second Tab");
		TabSpec tab3 = tabHost.newTabSpec("Third tab");
		

		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected
		tab1.setIndicator("Tab1");
		tab1.setContent(new Intent(this, Tab1Activity.class));

		tab2.setIndicator("Tab2");
		tab2.setContent(new Intent(this, Tab2Activity.class));

		tab3.setIndicator("Tab3");
		tab3.setContent(new Intent(this, Tab3Activity.class));

		/** Add the tabs to the TabHost to display. */
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);
	}

	public void goNext(View view) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse("http://www.google.com"));
		startActivity(browserIntent);
	}

}
