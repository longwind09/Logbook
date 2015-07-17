/**
 * 
 */
package com.logbook.controller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.logbook.impl.DesignImpl;
import com.logbook.model.BaseObject;

/**
 * @author longwind
 * 
 */
public class DesignController extends BaseObjectController
{
	
	
	public DesignController()
	{
		designImpl = new DesignImpl();
	}
	public BaseObject getObjectById(int id)
	{
		return designImpl.getObjectById(id);
	}
	public ArrayList<BaseObject> getObjectByKeyword(String keyword)
	{
		return designImpl.getObjectByKeyword(keyword);
	}

	public boolean mark(int id)
	{
		return designImpl.mark(id);
	}

	public long add(BaseObject obj)
	{
		return designImpl.add(obj);
	}

	public SQLiteOpenHelper getDatabaseOpenHelper()
	{
		// TODO Auto-generated method stub
		
		return designImpl.getDatabaseOpenHelper();
	}
	public boolean insertSomething()
	{
		return designImpl.insertSomething();
	}
	
	public boolean updateById(ContentValues values,int id)
	{
		return designImpl.updateById(values, id);
		
	}
	
	private DesignImpl designImpl;
}
