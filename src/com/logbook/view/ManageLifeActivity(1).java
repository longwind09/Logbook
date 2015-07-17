package com.logbook.view;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class ManageLifeActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_life);
		ActionBar actionbar = getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true); 
		
		
		intent = getIntent();
		bundle = intent.getExtras();
	}
	
	private void feedBack()
	{
		ContentValues values = new ContentValues();
		
		//boolean updateResult = designController.updateById(values, id);
		bundle.putInt("result", R.id.tv_life);
		intent.putExtras(bundle);
		ManageLifeActivity.this.setResult(RESULT_OK, intent);
		ManageLifeActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_life, menu);
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
	
	private Intent intent;
	private Bundle bundle;
}
