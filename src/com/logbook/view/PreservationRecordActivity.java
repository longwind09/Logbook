package com.logbook.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;


public class PreservationRecordActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preservation_record);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preservation_record, menu);
		return true;
	}

}
