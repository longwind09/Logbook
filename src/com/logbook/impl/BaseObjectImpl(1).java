/**
 * 
 */
package com.logbook.impl;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.logbook.inteface.DataAccesser;
import com.logbook.model.BaseObject;

/**
 * @author longwind
 *
 */
public class BaseObjectImpl implements DataAccesser
{

	/**
	 * 
	 */
	public BaseObjectImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public SQLiteOpenHelper getDatabaseOpenHelper()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseObject getObjectById(int id)
	{
		// TODO Auto-generated method stub
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
		return -1;
	}

	@Override
	public boolean update(BaseObject obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateById(ContentValues values,int id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertSomething()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
