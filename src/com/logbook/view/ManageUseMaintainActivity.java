package com.logbook.view;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ManageUseMaintainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_use_maintain);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_use_maintain, menu);
		return true;
	}

}
