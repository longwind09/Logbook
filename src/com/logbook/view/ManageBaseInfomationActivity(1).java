package com.logbook.view;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.logbook.controller.DesignController;
import com.logbook.controller.ProductController;
import com.logbook.model.Design;
import com.logbook.model.Product;

public class ManageBaseInfomationActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_base_infomation);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		edt_name = (EditText) findViewById(R.id.edt_name);
		edt_model = (EditText) findViewById(R.id.edt_model);
		
		intent = getIntent();
		bundle = intent.getExtras();
		id = (int) bundle.getLong("id");
		origin_class = bundle.getString("origin_class");
		if(origin_class == "ManageDesignActivity")
		{
			designController = new DesignController();
			design = (Design) designController.getObjectById(id);
			if (design != null)
			{
				edt_name.setText(design.getProductName());
				edt_model.setText(design.getSerialNumber());
			}
		}
		else if(origin_class=="ManageProductActivity")
		{
			productController = new ProductController();
			product = (Product) productController.getObjectById(id);
			Log.v("product",""+product.toString());
			if (product != null)
			{
				edt_name.setText(product.getProductName());
				edt_model.setText(product.getSerialNumber());
			}
		}

		
	

	}

	private void feedBack()
	{
		ContentValues values = new ContentValues();
		values.put("productName", edt_name.getText().toString());
		values.put("serialNumber",edt_model.getText().toString());
		boolean updateResult = false;
		if(origin_class == "ManageDesignActivity")
		{
			updateResult = designController.updateById(values, id);
		}
		else if(origin_class == "ManageProductActivity")
		{
			updateResult = productController.updateById(values, id);
		}
		 
		
		bundle.putInt("result", R.id.tv_baseInfomation);
		intent.putExtras(bundle);
		ManageBaseInfomationActivity.this.setResult(RESULT_OK, intent);
		ManageBaseInfomationActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_base_infomation, menu);
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

	private EditText edt_name;
	private EditText edt_model;
	private Intent intent;
	private Design design;
	private Product product;
	private DesignController designController;
	private ProductController productController;
	private int id;
	private Bundle bundle;
	private String origin_class;
}
