package com.logbook.view;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class ManageAncillaryActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_ancillary);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		intent = getIntent();
		bundle = intent.getExtras();
		
		
	}

	
	private void feedBack()
	{
		ContentValues values = new ContentValues();
		
		//boolean updateResult = designController.updateById(values, id);
		bundle.putInt("result", R.id.tv_ancillary);
		intent.putExtras(bundle);
		ManageAncillaryActivity.this.setResult(RESULT_OK, intent);
		ManageAncillaryActivity.this.finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_ancillary, menu);
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
				
			case R.id.action_add:
				break;
				
			case R.id.action_ok:
				feedBack();
				break;

		}
		return super.onOptionsItemSelected(item);
	}
	
	private Intent intent;
	private Bundle bundle;
}
