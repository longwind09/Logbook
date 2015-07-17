/**
 * 
 */
package com.logbook.impl;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.logbook.inteface.DataAccesser;
import com.logbook.model.BaseObject;
import com.logbook.model.Design;
import com.logbook.model.DesignAncillary;

/**
 * @author longwind
 * 
 */
public class DesignImpl extends BaseObjectImpl
{

	public DesignImpl()
	{
		sdbOpenHelper = DatabaseOpenHelper.getSingleton();
		sdb = sdbOpenHelper.getReadableDatabase();
	}

	@Override
	public BaseObject getObjectById(int id)
	{

		Cursor cursor = sdb.rawQuery("select * from design where id=?",
				new String[]
				{
					String.valueOf(id)
				});
		if (cursor.moveToFirst())
		{
			String serialNumber = cursor.getString(cursor
					.getColumnIndex("serialNumber"));
			String productName = cursor.getString(cursor
					.getColumnIndex("productName"));
			String itemCode = cursor.getString(cursor
					.getColumnIndex("itemCode"));
			Design design = new Design();
			design.setId(id);
			design.setSerialNumber(serialNumber);
			design.setItemCode(itemCode);
			design.setProductName(productName);
			return design;
		}
		cursor.close();
		return null;
	}

	@Override
	public ArrayList<BaseObject> getObjectByKeyword(String keyword)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mark(int id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long add(BaseObject obj)
	{
		// TODO Auto-generated method stub
		Design design = (Design) obj;
		ContentValues cv_design = new ContentValues();
		cv_design.put("serialNumber", design.getSerialNumber());
		cv_design.put("productName", design.getProductName());
		long rowId = sdb.insert("design", null, cv_design);
		return rowId;
	}
	
	@Override
	public boolean update(BaseObject obj)
	{
		// TODO Auto-generated method stub
		Design design = (Design) obj;
		ContentValues cv_design = new ContentValues();
		cv_design.put("id", ""+design.getId());
		cv_design.put("serialNumber", design.getSerialNumber());
		cv_design.put("productName", design.getProductName());
		sdb.update("design", cv_design, "id=?",new String[]{""+cv_design.getAsString("id")});
		
		return false;
	}

	@Override
	public SQLiteOpenHelper getDatabaseOpenHelper()
	{
		// TODO Auto-generated method stub

		return DatabaseOpenHelper.getSingleton();
	}

	@Override
	public boolean insertSomething()
	{
		for (int i = 0;i < 30; i++)
		{
			id_count++;
			Design design = new Design();
			design.setProductName("飞机");
			design.setSerialNumber("KFS-"+i);
			add(design);
			
			DesignAncillary da = new DesignAncillary();
		}
		Log.e("insertSql", "ok");
		return true;
	}
	
	private DatabaseOpenHelper sdbOpenHelper;
	private SQLiteDatabase sdb;
	private static int id_count=1;
	@Override
	public boolean updateById(ContentValues values, int id)
	{
		// TODO Auto-generated method stub
		
		int rows = sdb.update("design", values, "id=?", new String[]{""+id});
		if(rows>0)return true;
		return false;
	}
	
}
//
// package com.logbook.view;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import android.content.Context;
// import android.database.Cursor;
// import android.database.sqlite.SQLiteDatabase;
//
// public class DBDao
// {
// DBOpenHelper sdbOpenHelper;
//
// public DBDao(Context context)
// {
// this.sdbOpenHelper = new DBOpenHelper(context);
// }
//
// /**
// * 添加一条数据
// *
// * @param user
// */
// public void save(User user)
// {
// SQLiteDatabase sdb = sdbOpenHelper.getWritableDatabase();
// sdb.execSQL("insert into user(uname,uaddress) values(?,?)", new Object[]
// {
// user.getUname(), user.getUaddress()
// });
// sdb.close();
// }
//
// /**
// * 删除一条数据
// *
// * @param uid
// */
// public void delete(Integer uid)
// {
// SQLiteDatabase sdb = sdbOpenHelper.getWritableDatabase();
// sdb.execSQL("delete from user where uid=?", new Object[]
// {
// uid
// });
// sdb.close();
// }
//
// /**
// * 更新一条数据
// *
// * @param user
// */
// public void update(User user)
// {
// SQLiteDatabase sdb = sdbOpenHelper.getWritableDatabase();
// sdb.execSQL("update user set uname=?,uaddress=? where uid=?",
// new Object[]
// {
// user.getUname(), user.getUaddress(), user.getUid()
// });
// sdb.close();
// }
//
// /**
// * 查找一条数据
// *
// * @param uid
// */
// public User find(Integer uid)
// {
// SQLiteDatabase sdb = sdbOpenHelper.getReadableDatabase();
// Cursor cursor = sdb.rawQuery("select * from user where uid=?",
// new String[]
// {
// uid.toString()
// });
// if (cursor.moveToFirst())
// {
// int uid2 = cursor.getInt(cursor.getColumnIndex("uid"));
// String uname = cursor.getString(cursor.getColumnIndex("uname"));
// String uaddress = cursor.getString(cursor
// .getColumnIndex("uaddress"));
// User user = new User();
// user.setUid(uid2);
// user.setUname(uname);
// user.setUaddress(uaddress);
// return user;
// }
// cursor.close();
// return null;
// }
//
// /**
// * 分页查找数据
// *
// * @param offset
// * 跳过多少条数据
// * @param maxResult
// * 每页多少条数据
// * @return
// */
// public List<User> getScrollData(int offset, int maxResult)
// {
// List<User> users = new ArrayList<User>();
// SQLiteDatabase sdb = sdbOpenHelper.getReadableDatabase();
// Cursor cursor = sdb.rawQuery(
// "select * from user order by uid asc limit ?,?", new String[]
// {
// String.valueOf(offset), String.valueOf(maxResult)
// });
// while (cursor.moveToNext())
// {
// int uid2 = cursor.getInt(cursor.getColumnIndex("uid"));
// String uname = cursor.getString(cursor.getColumnIndex("uname"));
// String uaddress = cursor.getString(cursor
// .getColumnIndex("uaddress"));
// User user = new User();
// user.setUid(uid2);
// user.setUname(uname);
// user.setUaddress(uaddress);
// users.add(user);
// }
// return users;
// }
//
// /**
// * 获取数据总数
// *
// * @return
// */
// public long getCount()
// {
// SQLiteDatabase sdb = sdbOpenHelper.getReadableDatabase();
// Cursor cursor = sdb.rawQuery("select count(*) from user", null);
// cursor.moveToFirst();
// long reslut = cursor.getLong(0);
// return reslut;
// }
// }

