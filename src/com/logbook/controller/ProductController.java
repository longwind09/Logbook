/**
 * 
 */
package com.logbook.controller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.logbook.impl.ProductImpl;
import com.logbook.model.BaseObject;

/**
 * @author longwind
 *
 */
public class ProductController extends BaseObjectController
{

	/**
	 * 
	 */
	public ProductController()
	{
		productImpl = new ProductImpl();
	}
	public BaseObject getObjectById(int id)
	{
		return productImpl.getObjectById(id);
	}
	public ArrayList<BaseObject> getObjectByKeyword(String keyword)
	{
		return productImpl.getObjectByKeyword(keyword);
	}

	public boolean mark(int id)
	{
		return productImpl.mark(id);
	}

	public long add(BaseObject obj)
	{
		return productImpl.add(obj);
	}

	public SQLiteOpenHelper getDatabaseOpenHelper()
	{
		// TODO Auto-generated method stub
		
		return productImpl.getDatabaseOpenHelper();
	}
	public boolean insertSomething()
	{
		return productImpl.insertSomething();
	}
	
	public boolean updateById(ContentValues values,int id)
	{
		return productImpl.updateById(values, id);
		
	}
	
	private ProductImpl productImpl;
}