package com.logbook.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.logbook.controller.SqliteUtility;

public class SimpleTable extends LinearLayout implements OnClickListener,
		OnItemSelectedListener, OnItemClickListener
{
	private Context context;    // 上下文
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

	public SimpleTable(Context context)
	{
		super(context);
		this.context = context;
	}

	/**
	 * 表格视图
	 * 
	 * @param context
	 *            上下文
	 * @param items
	 *            字段名和对应显示名称
	 * @param sql
	 *            SQl查询语句
	 * @param displayNum
	 *            每页的最大记录数
	 */
	public SimpleTable(Context context, String[][] items, String sql,
			int TableRowCount)
	{
		super(context);
		this.context = context;
		this.items = items;
		this.sql = sql.replace(";", "");
		this.TableRowCount = TableRowCount;

		// 排序方式标记：false-递增排序，true-递减排序
		isDesc = new boolean[items.length];
		// 当前页码
		pageID = 0;
		// 表名称和查询条件
		TableName = sql
				.toLowerCase()
				.substring(sql.toLowerCase().indexOf(" from ") + 5,
						sql.length()).trim();
		Log.v("simpleTable", TableName);
		// 记录总数
		TotalCount = SqliteUtility.getCount(context, "select count(*) from "
				+ TableName);
		Log.v("totalCount", String.valueOf(TotalCount));
		// 总页码
		pageCount = TotalCount % TableRowCount == 0 ? TotalCount
				/ TableRowCount - 1 : TotalCount / TableRowCount;
		// 字段名称
		fields = new String[items.length];
		for (int i = 0; i < items.length; i++)
		{
			fields[i] = items[i][0];
		}

		setField(); // 字段视图
		setBody();  // 数据视图
		setBottomLayout();  // 底部视图
		setOrientation(LinearLayout.VERTICAL);
		setScrollContainer(false);
		// setLayoutParams(new LayoutParams(500, LayoutParams.WRAP_CONTENT));
		addView(gv_titles); // 添加视图
		//gv_titles.setLayoutParams(params);
		addView(gv_body);
		addView(bottomLayout);

	}

	/**
	 * 设置字段视图
	 */
	private void setField()
	{
		gv_titles = new GridView(context);
		gv_titles.setNumColumns(items.length);

		// 字段标题
		ArrayList<HashMap<String, String>> titles = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < items.length; i++)
		{
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("title", items[i][1]);
			titles.add(map);
		}
		titlesAdatper = new SimpleAdapter(context, titles,
				R.layout.page_table_head, new String[]
				{
					"title"
				}, new int[]
				{
					R.id.gridTitle
				});
		gv_titles.setAdapter(titlesAdatper);
		Log.v("titles", items[0][0]);

		// 点击字段标题，改变排序方式
		gv_titles.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{

				String sql = "select * from (" + SimpleTable.this.sql
						+ " Limit " + TableRowCount + " Offset " + pageID
						* TableRowCount + ") tempTable order by "
						+ items[arg2][0];
				if (isDesc[arg2])
				{
					sql += " asc ";
					isDesc[arg2] = false;
				}
				else
				{
					sql += " desc ";
					isDesc[arg2] = true;
				}
				Log.e("sql", sql);
				toPage(0, sql);
			}
		});
	}

	/**
	 * 设置表格数据视图
	 */
	private void setBody()
	{
		gv_body = new GridView(context);
		gv_body.setNumColumns(items.length);

		toPage(0, this.sql);    // 转到第一页
		gv_body.setOnItemClickListener(this);   // 点击数据事件
		Log.e("database:", "get page 0");

	}

	/**
	 * 设置底部翻页视图， 由如下组成：首页、上一页、下一页、尾页、页码选择、当期页码提示
	 */
	private void setBottomLayout()
	{
		// 底部容器
		bottomLayout = new LinearLayout(context);
		bottomLayout.setOrientation(LinearLayout.HORIZONTAL);
		bottomLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		// 翻页按钮
		bt_pre = new Button(context);   // 上一页
		bt_next = new Button(context);  // 下一页
		bt_first = new Button(context); // 首页
		bt_last = new Button(context);  // 尾页
		sp_page = new Spinner(context); // 页码
		tv_page = new TextView(context);// 页码

		// 设置文本
		bt_pre.setText("上一页");
		bt_next.setText("下一页");
		bt_first.setText("首页");
		bt_last.setText("尾页");
		tv_page.setText("页码:");

		// 设置页码下拉框选项
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= pageCount; i++)
		{
			list.add(i);
		}
		ArrayAdapter<Integer> pageAdapter = new ArrayAdapter<Integer>(context,
				android.R.layout.simple_spinner_item, list);
		sp_page.setAdapter(pageAdapter);

		// 设置事件
		sp_page.setOnItemSelectedListener(this);    // 设置下拉框事件
		bt_first.setOnClickListener(this);
		bt_pre.setOnClickListener(this);
		bt_last.setOnClickListener(this);
		bt_next.setOnClickListener(this);

		// 设置文本大小
		bt_first.setTextSize(12);
		bt_pre.setTextSize(12);
		bt_last.setTextSize(12);
		bt_next.setTextSize(12);
		tv_page.setTextSize(12);

		// 添加到底部容器
		bottomLayout.addView(bt_first);
		bottomLayout.addView(bt_pre);
		bottomLayout.addView(bt_next);
		bottomLayout.addView(bt_last);
		bottomLayout.addView(tv_page);
		bottomLayout.addView(sp_page);
	}

	// 设置显示大小
	public void setSize(View v)
	{
//		int pHight = gv_body.getHeight();
//		Log.v("gridview_height",""+pHight);
//        GridView.LayoutParams params = new GridView.LayoutParams(
//                        LayoutParams.FILL_PARENT, pHight / 6);
//        gv_body.setLayoutParams(params);
        
		v.setLayoutParams(new android.view.ViewGroup.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	}

	/**
	 * 翻页点击事件
	 */
	@Override
	public void onClick(View v)
	{

		if (v == bt_first)
		{ // 第一页
			pageID = 0;

		}
		else if (v == bt_last)
		{    // 最后一页
			if (pageCount == 0)
			{
				return;
			}
			pageID = pageCount;

		}
		else if (v == bt_next)
		{    // 下一页
			if (pageID < pageCount)
			{
				++pageID;
			}
			else
			{
				return;
			}

		}
		else if (v == bt_pre)
		{ // 上一页
			if (pageID <= 0)
			{
				return;
			}
			else
			{
				--pageID;
			}
		}
		sp_page.setSelection(pageID);
	}

	/**
	 * 页码下拉框选择事件
	 */
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3)
	{

		pageID = arg2;
		Log.e("onItemSelected:", "selected");
		toPage(pageID * TableRowCount, this.sql);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 跳转页面
	 * 
	 * @param stratIndex
	 *            开始页码
	 * @param sql
	 *            查询语句
	 */
	public void toPage(int stratIndex, String sql)
	{
//		// 查询语句
//		sql += " Limit " + TableRowCount + " Offset " + stratIndex;
//		// 获取查询结果集合
//		dataList = SqliteUtility.query2(context, sql, fields);
//		Log.v("toPage:", sql);
//		// 设置适配器
//		datasAdatper = new SimpleAdapter(context, dataList,
//				R.layout.page_table_view, new String[]
//				{
//					"item"
//				}, new int[]
//				{
//					R.id.ItemText
//				});
//		gv_body.setAdapter(datasAdatper);  // 重新添加适配器
		try
		{
			dataList = SqliteUtility.query3(context, sql,
					fields);
			SimpleAdapter adapter = new SimpleAdapter(context, dataList,
					R.layout.page_table_view, 
					fields,
					new int[]
					{
							R.id.ItemId,R.id.ItemText, R.id.serial
					});
			gv_body.setAdapter(adapter);
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

	/**
	 * 数据项点击事件
	 */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{

		Toast.makeText(context,
				((HashMap<String, String>) dataList.get(arg2)).get("item"),
				Toast.LENGTH_SHORT).show();
		Log.v("gridview",arg1.toString()+arg2+" "+arg3);
	}

}
