package com.logbook.view;

import com.logbook.impl.DatabaseOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DatabaseOpenHelper openHelper = new DatabaseOpenHelper(MainActivity.this);

		tvManageMode = (TextView) findViewById(R.id.manage);
		tvReadMode = (TextView) findViewById(R.id.read);
		
		tvManageMode.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,
						ManageTabActivity.class);
				startActivity(intent);
			}

		});
		tvReadMode.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,
						ReadTabActivity.class);
				
				startActivity(intent);
			}

		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private TextView tvManageMode;
	private TextView tvReadMode;
}
