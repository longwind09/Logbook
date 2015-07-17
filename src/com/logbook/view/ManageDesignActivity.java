package com.logbook.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ManageDesignActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_design);
		
		linearLayout = (LinearLayout) findViewById(R.id.linearLayout_manage_design);
		//linearLayout_search = (LinearLayout) findViewById(R.id.linearLayout_search);
		//linearLayout_search.setVisibility(View.INVISIBLE);

		editSearch = (EditText)findViewById(R.id.searchEditText);
		
		
		
		
		// 要查询的字段和对应显示的名称
		items = new String[][]
		{
				{
						"id", "序列"
				},
				{
						"productName", "名称"
				},
				{
						"serialNumber", "型号"
				},
		};

		sql = "select * from design";
		simpleList = new SimpleList(this, items, sql, "ManageDesignActivity");
		linearLayout.addView(simpleList);
		linearLayout.setScrollContainer(true);

	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu)
//	{
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.manage_design, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item)
//	{
//		switch (item.getItemId())
//		{
//			case android.R.id.home:
//				this.finish();
//				break;
//				
//			case  R.id.action_search:
//				break;
//			case  R.id.action_add:
//				break;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	private LinearLayout linearLayout;
	private LinearLayout linearLayout_search;
	private EditText editSearch;
	private SimpleList simpleList;
	private String[][] items;
	private String sql;
}

