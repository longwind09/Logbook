package com.logbook.view;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.logbook.controller.ProductController;

public class ManageProductCatalogActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_product_catalog);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		tv_ancillary = (TextView) findViewById(R.id.tv_ancillary);
		tv_parameter = (TextView) findViewById(R.id.tv_parameter);
		tv_baseInfo = (TextView) findViewById(R.id.tv_baseInfomation);
		tv_life = (TextView) findViewById(R.id.tv_life);

		ClickCallback clickCallback = new ClickCallback();
		tv_ancillary.setOnClickListener(clickCallback);
		tv_parameter.setOnClickListener(clickCallback);
		tv_baseInfo.setOnClickListener(clickCallback);
		tv_life.setOnClickListener(clickCallback);
		
		
		
		
	}


	class ClickCallback implements OnClickListener
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			
			
			switch (((TextView) v).getId())
			{
				case R.id.tv_ancillary:
					 openActivity(R.id.tv_ancillary);
					break;
				case R.id.tv_parameter:
					 openActivity(R.id.tv_parameter);
					break;
				case R.id.tv_life:
					openActivity(R.id.tv_life);
					break;
				case R.id.tv_baseInfomation:
					openActivity(R.id.tv_baseInfomation);
					break;
					
				case R.id.tv_useMaintain:
					openActivity(R.id.tv_useMaintain);
					break;
				default:
					break;
			}
		}

	}
	/**
	 * Activity 间传值
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (resultCode)
		{
			case RESULT_OK:
				handleResult(data);
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * 
	 * @param data
	 * 
	 */
	private void handleResult(Intent data)
	{
		Bundle bundle = data.getExtras();
		int resultId = bundle.getInt("result");
		if(resultId != 0)
		findViewById(resultId).setBackgroundResource(R.drawable.welldone_bg);
		return;
	}
	private void openActivity(int activityId)
	{
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getExtras();
		Intent intent = new Intent();
		intent.putExtras(bundle);
		switch(activityId)
		{
			case R.id.tv_ancillary:
				intent.setClass(this, ManageAncillaryActivity.class);
				break;
			case R.id.tv_parameter:
				 intent.setClass(this, ManageParameterActivity.class);
				break;
			case R.id.tv_life:
				intent.setClass(this, ManageLifeActivity.class);
				break;
			case R.id.tv_baseInfomation:
				intent.setClass(this, ManageBaseInfomationActivity.class);
				break;
			case R.id.tv_useMaintain:
				intent.setClass(this, ManageUseMaintainActivity.class);
				break;
			default:
				return;
				
		}
		
		//intent.putExtras(bundle);
		
		startActivityForResult(intent, 0);
	}
	
	private void feedBack()
	{
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_product_catalog, menu);
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

	private TextView tv_baseInfo;
	private TextView tv_ancillary;
	private TextView tv_parameter;
	private TextView tv_life;
	private ProductController productController;
}

