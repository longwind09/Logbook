package com.logbook.view;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

public class ReadTabActivity extends TabActivity implements OnTabChangeListener
{
	private GestureDetector gestureDetector;
	// private FrameLayout frameLayout;
	private AnimationTabHost mTabHost;
	private TabWidget mTabWidget;
	private int currentTabID = 0;

	/** 记录当前分页ID */

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_host_view);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		
		mTabHost = (AnimationTabHost) findViewById(android.R.id.tabhost);
		mTabWidget = (TabWidget) findViewById(android.R.id.tabs);
		mTabHost.setOnTabChangedListener(this);

		init();

		gestureDetector = new GestureDetector(new TabHostTouch());
		new View.OnTouchListener()
		{
			public boolean onTouch(View v, MotionEvent event)
			{
				if (gestureDetector.onTouchEvent(event))
				{
					return true;
				}
				return false;
			}
		};
	}

	private void init()
	{

		setIndicator(R.string.design, 0, new Intent(this,
				ReadDesignActivity.class));
		setIndicator(R.string.product, 1, new Intent(this,
				ReadProductActivity.class));

		mTabHost.setOpenAnimation(true);
		mTabHost.setCurrentTab(0);
	}

	private void setIndicator(int iMDP, int tabId, Intent intent)
	{

		View localView = LayoutInflater.from(this.mTabHost.getContext())
				.inflate(R.layout.tab_widget_view, null);
		TextView tView = (TextView) (localView.findViewById(R.id.MDP_text));
		tView.setText(iMDP);

		String str = String.valueOf(tabId);
		TabHost.TabSpec localTabSpec = mTabHost.newTabSpec(str)
				.setIndicator(localView).setContent(intent);
		mTabHost.addTab(localTabSpec);
	}

	public void onTabChanged(String tabId)
	{
		int tabID = Integer.valueOf(tabId);

		for (int i = 0, count = mTabWidget.getChildCount(); i < count; i++)
		{
			if (i == tabID)
			{
				mTabWidget.getChildAt(Integer.valueOf(i))
						.setBackgroundResource(R.color.lightblue);
			}
			else
			{
				mTabWidget.getChildAt(Integer.valueOf(i))
						.setBackgroundResource(R.color.white);
			}
		}
	}

	public boolean dispatchTouchEvent(MotionEvent event)
	{

		if (gestureDetector.onTouchEvent(event))
		{
			event.setAction(MotionEvent.ACTION_CANCEL);
		}

		return super.dispatchTouchEvent(event);

	}

	

	private class TabHostTouch extends SimpleOnGestureListener
	{
		/** 滑动翻页所需距离 */
		private static final int ON_TOUCH_DISTANCE = 120;

		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY)
		{
			if (Math.abs(e1.getY() - e2.getY()) >= Math.abs(e1.getX()
					- e2.getX()))
				return false;
			if (e1.getX() - e2.getX() <= (-ON_TOUCH_DISTANCE))
			{
				currentTabID = mTabHost.getCurrentTab() - 1;

				if (currentTabID < 0)
				{
					currentTabID = mTabHost.getTabCount() - 1;
				}
			}
			else if (e1.getX() - e2.getX() >= ON_TOUCH_DISTANCE)
			{
				currentTabID = mTabHost.getCurrentTab() + 1;

				if (currentTabID >= mTabHost.getTabCount())
				{
					currentTabID = 0;
				}
			}
			mTabHost.setCurrentTab(currentTabID);
			return false;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_tab, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
				this.finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
