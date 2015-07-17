package com.logbook.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.style.UpdateAppearance;

public class SqliteUtility
{

	private static final int MODE_PRIVATE = 0x0;
	private static final String DATABASE = "logbook301.s3db";
	private static SQLiteDatabase db;

	/**
	 * 插入一些数据
	 */
	public static void insertSomething(Context context)
	{

	}

	/**
	 * 查询
	 * 
	 * @param context
	 *            上下文
	 * @param sql
	 *            SQl查询语句
	 * @param fields
	 *            字段名集合
	 * @return 查询结果集 List<String>类型
	 */
	public static List<String> query(Context context, String sql,
			String[] fields)
	{
		List<String> dataList = new ArrayList<String>();
		Cursor cursor;

		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);
			
			cursor = db.rawQuery(sql, null);
			if (cursor != null)
			{
				while (cursor.moveToNext())
				{
					for (int i = 0; i < fields.length; i++)
					{
						String temp = cursor.getString(cursor
								.getColumnIndex(fields[i]));
						dataList.add(temp);
					}
				}
			}
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		finally
		{
			db.close();
		}
		return dataList;
	}

	/**
	 * 数据记录总条数
	 * 
	 * @param context
	 *            上下文
	 * @param sql
	 *            SQL查询语句
	 * @return 记录条数
	 */
	public static int getCount(Context context, String sql)
	{

		int totalCounty = 0;
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);
			Cursor cursor = db.rawQuery(sql, null);
			cursor.moveToFirst();
			totalCounty = cursor.getInt(0);
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		finally
		{
			db.close();
		}
		return totalCounty;
	}

	/**
	 * 查询
	 * 
	 * @param context
	 *            上下文
	 * @param sql
	 *            SQl查询语句
	 * @param fields
	 *            字段名集合
	 * @return 查询结果集 ArrayList<HashMap<String,String>>类型
	 */
	public static ArrayList<HashMap<String, String>> query2(Context context,
			String sql, String[] fields)
	{

		ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		Cursor cursor;  // 游标
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库

			cursor = db.rawQuery(sql, null);    // 获取数据集游标

			if (cursor != null)
			{
				while (cursor.moveToNext())
				{   // 游标递增，访问数据集

					for (int i = 0; i < fields.length; i++)
					{
						String temp = cursor.getString(cursor   // 获取对应数据项
								.getColumnIndex(fields[i]));
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("item", temp);
						dataList.add(map);

					}
				}
			}
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		finally
		{
			cursor = null;
			db.close();
		}
		return dataList;
	}
	
	
	/**
	 * 查询
	 * 
	 * @param context
	 *            上下文
	 * @param sql
	 *            SQl查询语句
	 * @param fields
	 *            字段名集合
	 * @return 查询结果集 ArrayList<HashMap<String,String>>类型
	 */
	public static ArrayList<HashMap<String, String>> query3(Context context,
			String sql, String[] fields)
	{

		ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		Cursor cursor;  // 游标
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库

			cursor = db.rawQuery(sql, null);    // 获取数据集游标

			if (cursor != null)
			{
				while (cursor.moveToNext())
				{   // 游标递增，访问数据集
					HashMap<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < fields.length; i++)
					{
						String temp = cursor.getString(cursor   // 获取对应数据项
								.getColumnIndex(fields[i]));
						map.put(fields[i], temp);
					}
					dataList.add(map);
				}
			}
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		finally
		{
			cursor = null;
			db.close();
		}
		return dataList;
	}
	/**
	 * 查询
	 * 
	 * @param context
	 *            上下文
	 * @param sql
	 *            SQl查询语句
	 * @param fields
	 *            字段名集合
	 * @return 查询结果集 ArrayList<HashMap<String,String>>类型
	 */
	public static Cursor query4(Context context,
			String sql, String[] fields)
	{

		Cursor cursor = null;  // 游标
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库

			cursor = db.rawQuery(sql, null);    // 获取数据集游标
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		return cursor;
	}
	
	/**
	 * 更新
	 * 
	 * @param tableName
	 *            表名
	 * @param contentvalues
	 *            更新后的值
	 * @param whereClause
	 *            条件
	 * @param whereArgs
	 * 			  要更新的字段          
	 * @return 更新结果boolean类型
	 */
	public static boolean Update(Context context,String tableName,ContentValues contentValue,String whereClause,String[] whereArgs )
	{
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库
			int rows = db.update(tableName, contentValue, whereClause, whereArgs);
			if(rows>0)return true;
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		return false;
		
		
	}
	
	/**
	 * 更新
	 * 
	 * @param tableName
	 *            表名
	 * @param contentvalues
	 *            更新后的值
	 * @param whereClause
	 *            条件
	 * @param whereArgs
	 * 			  要更新的字段          
	 * @return 更新结果boolean类型
	 */
	public static boolean UpdateById(Context context,String tableName,ContentValues contentValues)
	{
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库
			int rows = db.update(tableName, contentValues, "id=?", new String[]{""+contentValues.getAsInteger("id")});
			if(rows>0)return true;
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		return false;
		
		
	}
	
	public static boolean add(Context context,String tableName,ContentValues contentValues)
	{
		try
		{
			db = context.openOrCreateDatabase(DATABASE, MODE_PRIVATE, null);    // 连接数据库
			long rows = db.insert(tableName, null, contentValues);
			if(rows>0)return true;
		}
		catch (Exception e)
		{
			new AlertDialog.Builder(context)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("数据库连接错误：").setMessage("数据访问异常。").show();
		}
		return false;
	}
}
