package com.logbook.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class OpenFileActivity extends ListActivity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.openfile);
		intent = this.getIntent();
		bundle = intent.getExtras();
		getFileDir(rootPath);
	}

	private void getFileDir(String filePath)
	{
		items = new ArrayList<String>();
		paths = new ArrayList<String>();
		File f = new File(filePath);
		File[] files = f.listFiles();
		if (!filePath.equals(rootPath))
		{
			items.add("back to " + rootPath);
			paths.add(rootPath);
			items.add("back to ../");
			paths.add(f.getParent());
		}

		for (int i = 0, count = files.length; i < count; i++)
		{
			File file = files[i];
			items.add(file.getName());
			paths.add(file.getPath());
		}
		ArrayAdapter<String> fileList = new ArrayAdapter<String>(this,
				R.layout.file_row, items);
		setListAdapter(fileList);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		File file = new File(paths.get(position));
		Toast.makeText(this, file.getPath(), Toast.LENGTH_LONG).show();
		if (file.canRead())
		{
			if (file.isDirectory())
			{
				getFileDir(paths.get(position));
			}
			else
			{
				openFile(file);
			}
		}
		else
		{
			new AlertDialog.Builder(this)
					.setTitle("Message")
					.setMessage("权限不够")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener()
							{

								@Override
								public void onClick(DialogInterface dialog,
										int which)
								{
									// TODO Auto-generated method stub
								}
							}).show();
		}
	}

	private void openFile(File f)
	{
		String type = getMIMEType(f);
		if (type.equals("sql"))
		{
			bundle.putString("mPath", f.getPath());
			intent.putExtras(bundle);
			OpenFileActivity.this.setResult(RESULT_OK, intent);
			OpenFileActivity.this.finish();
		}
	}

	private String getMIMEType(File f)
	{
		String fName = f.getName();
		String end = fName
				.substring(fName.lastIndexOf(".") + 1, fName.length())
				.toLowerCase();
		return end;
	}

	private List<String> items = null;
	private List<String> paths = null;
	private String rootPath = "/";
	Bundle bundle = null;
	Intent intent = null;
}
