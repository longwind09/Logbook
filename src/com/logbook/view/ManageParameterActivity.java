package com.logbook.view;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ManageParameterActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parameter);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		intent = getIntent();
		bundle = intent.getExtras();
		
		
		
	}

	private void feedBack()
	{
		ContentValues values = new ContentValues();
		
		//boolean updateResult = designController.updateById(values, id);
		bundle.putInt("result", R.id.tv_parameter);
		intent.putExtras(bundle);
		ManageParameterActivity.this.setResult(RESULT_OK, intent);
		ManageParameterActivity.this.finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_parameter, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
				this.finish();
				break;
				
			case R.id.action_ok:
				feedBack();
				break;

		}
		return super.onOptionsItemSelected(item);
	}

	String flag;
	private Bundle bundle;
	private Intent intent;
}
