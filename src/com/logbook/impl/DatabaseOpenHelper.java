/**
 * 
 */
package com.logbook.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.widget.SlidingDrawer;
import android.widget.Toast;

/**
 * @author longwind
 * @date    2014/03/18
 * 数据库创建和维护
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper
{
	
	private static Context context;
	// Early initialization.定义的时候就初始化(不推荐)。
	private static DatabaseOpenHelper s;
	
	public static DatabaseOpenHelper getSingleton() 
	{
		if(s == null)
		{
			s =  new DatabaseOpenHelper(context);
			
		}
		return s;
	}
	
	public DatabaseOpenHelper(Context context)
	{
		super(context, "logbook301.s3db", null, 1);
		
		Log.v("database","DatabaseOpenHelper");
		DatabaseOpenHelper.context = context;
		
		
	}
	
	//数据库第一次创建时候调用，
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		//db.execSQL("create table user(uid integer primary key autoincrement, uname varchar(20), uaddress varchar(20))");
		
		db.execSQL("drop table if exists assembleRecord;");
		db.execSQL("drop table if exists checkAndRepairRecord;");
		db.execSQL("drop table if exists design;");
		db.execSQL("drop table if exists designAncillary;");
		db.execSQL("drop table if exists designParameter;");
		db.execSQL("drop table if exists disassembleRecord;");
		db.execSQL("drop table if exists performanceCheckRecord;");
		db.execSQL("drop table if exists preservationRecord;");
		db.execSQL("drop table if exists product;");
		db.execSQL("drop table if exists productAncillary;");
		db.execSQL("drop table if exists productParameter;");
		db.execSQL("drop table if exists useMaintain;");
		db.execSQL("drop table if exists useMaintainMap;");
		db.execSQL("create table design (id INTEGER not null,serialNumber varchar,productName varchar,itemCode varchar,guaranteeTime varchar,totalLife varchar,MTBF varchar,storageLife varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id));");
		db.execSQL("create table product (id INTEGER not null,designId INTEGER,serialNumber varchar,productName varchar,state varchar,manufacturerCode varchar,itemCode varchar,'order' varchar,guaranteeTime varchar,totalLife varchar,MTBF varchar,storageLife varchar,guaranteePeriod varchar,manufacturer varchar,purchaser varchar,acceptanceTime DATE,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (designId) references design (id));");
		db.execSQL("create table useMaintain (id INTEGER not null,productId INTEGER,useMaintainType INTEGER,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (productId) references product (id));");
		db.execSQL("create table assembleRecord (id INTEGER not null,useMaintainId integer,productSerialNumber varchar,'date' DATE,sign varchar,department varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (useMaintainId) references useMaintain (id));");
		db.execSQL("create table checkAndRepairRecord (id INTEGER not null,useMaintainId INTEGER,'date' DATE,checkOperator varchar,repairOperator varchar,department varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (useMaintainId) references useMaintain (id));");
		db.execSQL("create table designAncillary (id INTEGER not null,name varchar,productModel varchar,serialNumber varchar,quantity INTEGER,remark varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (id) references design (id));");
		db.execSQL("create table designParameter (id INTEGER not null,designId INTEGER,parameterName varchar,parameterUnit varchar,parameterValue DOUBLE PRECISION,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (designId) references design (id));");
		db.execSQL("create table disassembleRecord (id INTEGER not null,useMaintainId INTEGER,productSerialNumber varchar,'date' DATE,sign varchar,department varchar,reason varchar,worktime varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (useMaintainId) references useMaintain (id));");
		db.execSQL("create table performanceCheckRecord (id INTEGER not null,useMaintainId INTEGER,'order' INTEGER,checkItem varchar,sign varchar,result01 varchar,result02 varchar,checkOperator01 varchar,checkOperator02 varchar,date01 DATE,date02 DATE,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (useMaintainId) references useMaintain (id));");
		db.execSQL("create table preservationRecord (id INTEGER not null,useMaintainId INTEGER,'date' DATE,workName varchar,storageLIfe varchar,department varchar,sign varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (useMaintainId) references useMaintain (id));");
		db.execSQL("create table productAncillary (id INTEGER not null,productId INTEGER,name varchar,serialNumber varchar,quantity INTEGER,remark varchar,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (productId) references product (id));");
		db.execSQL("create table productParameter (id INTEGER not null,productId INTEGER,parameterName varchar,parameterUnit varchar,parameterValue DOUBLE PRECISION,mark BIT,reserved_1 varchar,reserved_2 INTEGER,primary key (id),foreign key (productId) references product (id));");
		db.execSQL("create table useMaintainMap (id INTEGER not null,tableName varchar,useMaintainType INTEGER,primary key (id));");
		
		Log.v("database","createOk");
	}

	//数据库文件版本号发生变化时调用
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) 
	{
		Log.v("database","upgrade");
	}
	
	
}
