package com.logbook.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.logbook.controller.DesignController;
import com.logbook.impl.DatabaseOpenHelper;

public class ConfigActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		
	}

	

	private void createLogic()
	{
		sqlFilePath = "";

//		bt1 = (Button) findViewById(R.id.button1);
//		bt1.setOnClickListener(new Button.OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v)
//			{
//				skanFile();
//			}
//
//		});
//		//bt2 = (Button) findViewById(R.id.button2);
//		bt2.setOnClickListener(new Button.OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v)
//			{
//				if (sqlFilePath != "")
//				{
//					ReadSql(sqlFilePath, getSDPath() + "/" + "logbook301.s3db");
//				}
//			}
//
//		});
	}

	public void createDatabase()
	{
		Log.v("database","in");
		// 然后：在后面加上斜杠，在加上文件名
		File path = Environment.getExternalStorageDirectory();

		DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(this);
		designController = new DesignController();
		designController.insertSomething();

	}

	private void ReadSql(String sqlFileName, String DatabaseFileName)
	{
		try
		{
			File file = new File(sqlFileName);
			FileReader fReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fReader);
			
			//FileOutputStream out = null;   
			// out = new FileOutputStream(new File("d:/sql.txt"));   
			File f = new File(getSDPath()+"/sql.txt");
			 BufferedWriter out = new BufferedWriter(new FileWriter(f));
			  // output.write(s1);
			  // output.close();

//			SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(
//					DatabaseFileName, null);

			

			String sqlUpdate = "";
			String tmpString = null;

			while ((tmpString = bufferedReader.readLine()) != null)
			{
				sqlUpdate += tmpString;
				if (sqlUpdate.contains(";"))
				{
					out.write("db.execSQL('"+sqlUpdate+"');");
					//database.execSQL(sqlUpdate);
					sqlUpdate = "";
				}
			}
			bufferedReader.close();
			out.close();

			fReader.close();

			//database.close();
		}
		catch (SQLException e)
		{
			// tv1.append(e.getMessage());
			// XLog.log(TAG, e.getMessage());
		}
		catch (IOException e)
		{
			// tv1.append(e.getMessage());
		}
	}

	public String getSDPath()
	{
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);   // 判断sd卡是否存在

		if (sdCardExist)      // 如果SD卡存在，则获取跟目录
		{
			sdDir = Environment.getExternalStorageDirectory();// 获取根目录
			return sdDir.toString();
		}
		else
			return "";
	}

	private void skanFile()
	{
		Bundle bundle = new Bundle();
		Intent intent = new Intent();
		intent.setClass(ConfigActivity.this, OpenFileActivity.class);
		intent.putExtras(bundle);
		startActivityForResult(intent, 0);
	}

	/**
	 * Activity 间传值
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (resultCode)
		{
			case RESULT_OK:
				Bundle bundle = data.getExtras();
				String mPath = bundle.getString("mPath");
				sqlFilePath = mPath;
				break;
			default:
				break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.config, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
				this.finish();
				break;
				
			case  R.id.action_create_database:
				createDatabase();
				break;
			case  R.id.action_insert_test:
				this.finish();
				break;
				
		}
		return super.onOptionsItemSelected(item);
	}
	
	private TextView tv1;
	private TextView tv2;
	private Button bt1;
	private Button bt2;
	private String sqlFilePath;
    String sqlFileName = getSDPath() + "/" + "logbook.sql"; // 以name存在目录中
    String DatabaseFileName = getSDPath() + "/" + "logbook301.s3db"; //
	// 以name存在目录中
    
    private DesignController designController;
}
