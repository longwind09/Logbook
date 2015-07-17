/**
 * 数据访问接口
 */
package com.logbook.inteface;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.logbook.model.BaseObject;

/**
 * @author longwind
 *
 */
public interface DataAccesser
{
	public SQLiteOpenHelper getDatabaseOpenHelper();
	//通过id查找返回一条纪录
	public BaseObject getObjectById(int id);
	
	//通过关键字查找返回多条数据
	public ArrayList<BaseObject> getObjectByKeyword(String keyword);
	
	//标记履历本某一行为错误
	public boolean mark(int id);
	
	//插入履历本一条新纪录
	public long add(BaseObject obj);
	
	public boolean update(BaseObject obj);
	
	public boolean updateById(ContentValues values,int id);
	
	
	public boolean insertSomething();
	
}
