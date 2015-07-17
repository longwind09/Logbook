/**
 * 
 */
package com.logbook.controller;

import java.util.ArrayList;

import android.database.sqlite.SQLiteOpenHelper;

import com.logbook.impl.BaseObjectImpl;
import com.logbook.impl.DesignImpl;
import com.logbook.model.BaseObject;

/**
 * @author longwind
 *
 */
public class BaseObjectController
{
	
	public BaseObjectController()
	{
		baseObjectImpl = new BaseObjectImpl();
	}
	
	public BaseObject getObjectById(int id)
	{
		return baseObjectImpl.getObjectById(id);
	}
	public ArrayList<BaseObject> getObjectByKeyword(String keyword)
	{
		return baseObjectImpl.getObjectByKeyword(keyword);
	}

	public boolean mark(int id)
	{
		return baseObjectImpl.mark(id);
	}

	public long add(BaseObject obj)
	{
		return baseObjectImpl.add(obj);
	}

	public SQLiteOpenHelper getDatabaseOpenHelper()
	{
		return baseObjectImpl.getDatabaseOpenHelper();
	}
	public boolean insertSomething()
	{
		return baseObjectImpl.insertSomething();
	}
	
	
	private BaseObjectImpl baseObjectImpl;
}
