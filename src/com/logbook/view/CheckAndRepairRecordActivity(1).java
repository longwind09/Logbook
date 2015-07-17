package com.logbook.view;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CheckAndRepairRecordActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_and_repair_record);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_and_repair_record, menu);
		return true;
	}

}
