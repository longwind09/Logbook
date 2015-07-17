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

import com.logbook.model.BaseObject;
import com.logbook.model.Product;
import com.logbook.model.ProductAncillary;

/**
 * @author longwind
 *
 */
public class ProductImpl extends BaseObjectImpl
{

	/**
	 * 
	 */
	public ProductImpl()
	{
		sdbOpenHelper = DatabaseOpenHelper.getSingleton();
		sdb = sdbOpenHelper.getReadableDatabase();
	}

	@Override
	public BaseObject getObjectById(int id)
	{

		Cursor cursor = sdb.rawQuery("select * from product where id=?",
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
			Product product = new Product();
			product.setId(id);
			product.setSerialNumber(serialNumber);
			product.setItemCode(itemCode);
			product.setProductName(productName);
			return product;
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
		Product product = (Product) obj;
		ContentValues cv_product = new ContentValues();
		cv_product.put("serialNumber", product.getSerialNumber());
		cv_product.put("productName", product.getProductName());
		long rowId = sdb.insert("product", null, cv_product);
		return rowId;
	}
	
	@Override
	public boolean update(BaseObject obj)
	{
		// TODO Auto-generated method stub
		Product product = (Product) obj;
		ContentValues cv_product = new ContentValues();
		cv_product.put("id", ""+product.getId());
		cv_product.put("serialNumber", product.getSerialNumber());
		cv_product.put("productName", product.getProductName());
		sdb.update("product", cv_product, "id=?",new String[]{""+cv_product.getAsString("id")});
		
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
			Product product = new Product();
			product.setProductName("飞机");
			product.setSerialNumber("KFS-"+i);
			add(product);
			
			ProductAncillary da = new ProductAncillary();
		}
		Log.e("insertSql", "ok");
		return true;
	}
	

	@Override
	public boolean updateById(ContentValues values, int id)
	{
		// TODO Auto-generated method stub
		
		int rows = sdb.update("product", values, "id=?", new String[]{""+id});
		if(rows>0)return true;
		return false;
	}
	private DatabaseOpenHelper sdbOpenHelper;
	private SQLiteDatabase sdb;
	private static int id_count=1;
}
