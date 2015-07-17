package com.logbook.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.logbook.controller.SqliteUtility;
import com.logbook.view.R.string;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleList extends LinearLayout implements
		OnItemSelectedListener, OnItemClickListener
{

	public SimpleList(Context context, String[][] items, String sql,
			String origin_className)
	{
		super(context);
		this.context = context;
		this.items = items;
		this.sql = sql.replace(";", "");
		this.origin_class = origin_className;

		// 排序方式标记：false-递增排序，true-递减排序
		isDesc = new boolean[items.length];
		// 当前页码
		pageID = 0;
		// 表名称和查询条件
		TableName = sql
				.toLowerCase()
				.substring(sql.toLowerCase().indexOf(" from ") + 5,
						sql.length()).trim();
		Log.v("simpleList", TableName);
		fields = new String[items.length];
		for (int i = 0; i < items.length; i++)
		{
			fields[i] = items[i][0];
		}
		bindData1();
		
		//addView(lv_head);
		//setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
		addView(lv_body);
		lv_body.setOnItemSelectedListener(this);
		lv_body.setOnItemClickListener(this);
		
	}

	/*
	 * 使用SimpleCursorAdapter适配器绑定数据
	 */
	private void bindData()
	{
		lv_body = new ListView(context);

		Cursor cursor = SqliteUtility.query4(context, sql, fields);  // 游标
		try
		{
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(context,
					R.layout.page_list_view, cursor, fields, new int[]
					{
							R.id.ItemId,R.id.ItemText, R.id.serial
					});
			lv_body.setAdapter(adapter);
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
			Log.e("database", e.getMessage());
		}
		finally
		{
			cursor = null;
		}

	}

	/*
	 * 使用SimpleAdapter适配器绑定数据
	 */
	private void bindData1()
	{
		lv_body = new ListView(context);
		try
		{
			dataList = SqliteUtility.query3(context, sql,
					fields);
			SimpleAdapter adapter = new SimpleAdapter(context, dataList,
					R.layout.page_list_view, 
					fields,
					new int[]
					{
							R.id.ItemId,R.id.ItemText, R.id.serial
					});
			lv_body.setAdapter(adapter);
			Log.v("bindData1", "ok");
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
			Log.e("database", e.getMessage());
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		// TODO Auto-generated method stub
		TextView tView = (TextView)arg1.findViewById(R.id.ItemId);
		String str_id =  (String) tView.getText();
		Integer id = Integer.valueOf(str_id);
		Intent intent = new Intent();
		Bundle bundle = new Bundle();
		if(origin_class== "ManageDesignActivity")
		{
			intent.setClass(context,ManageDesignCatalogActivity.class);
		}
		else if(origin_class== "ManageProductActivity")
		{ 
			intent.setClass(context, ManageProductCatalogActivity.class);
		}
		else if(origin_class=="ReadDesignActivity")
		{
			intent.setClass(context, DesignFirstpageActivity.class);
		}
		else if(origin_class == "ReadProductActivity")
		{
			intent.setClass(context, ProductFirstpageActivity.class);
		}
		else 
		{
			return;
		}
	
		
		bundle.putLong("id", id);
		bundle.putString("origin_class", origin_class);
		intent.putExtras(bundle);
		context.startActivity(intent);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3)
	{
		// TODO Auto-generated method stub
//		TextView tView = (TextView)arg1.findViewById(R.id.ItemId);
//		Toast.makeText(context, tView.getText(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
		// TODO Auto-generated method stub

	}


	private Context context;    // 上下文
	private String origin_class;
	/**
	 * @return the origin_class
	 */
	public String getOrigin_class()
	{
		return origin_class;
	}

	/**
	 * @param origin_class the origin_class to set
	 */
	public void setOrigin_class(String origin_class)
	{
		this.origin_class = origin_class;
	}


	private GridView gv_titles; // 字段视图
	private GridView gv_body;   // 数据视图
	private LinearLayout bottomLayout;  // 视图底部布局

	private Button bt_next, bt_pre, bt_first, bt_last;  // 按钮：下一页、上一页、首页、尾页
	private TextView tv_page, tv_count;
	private Spinner sp_page;    // 页码下拉框
	private String[][] items;   // [字段][显示的名称]
	private String sql;         // 查询语句
	private SimpleAdapter titlesAdatper;    // 字段视图适配器
	private SimpleAdapter datasAdatper; // 数据视图适配去
	private int TableRowCount;          // 每页显示条数
	private int pageID;                 // 当前页码
	private int TotalCount;             // 总记录条数
	private int pageCount;              // 总页数
	private String TableName;           // 表名和查询条件
	private String[] fields;            // 字段名称
	private boolean[] isDesc;           // 排序方式标记：false-递增排序，true-递减排序
	private ArrayList<HashMap<String, String>> dataList;   // 数据集合

	private ListView lv_head;
	private ListView lv_body;
	private ListView lv_detail;
	private static final int MODE_PRIVATE = 0x0;
	private static final String DATABASE = "logbook301.s3db";
	private static SQLiteDatabase db;
}
