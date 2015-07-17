package com.logbook.view;

import com.logbook.controller.DesignController;
import com.logbook.controller.ProductController;
import com.logbook.model.Design;
import com.logbook.model.Product;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.Toast;

public class ManageTabActivity extends TabActivity implements
		OnTabChangeListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_host_view);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		designController = new DesignController();
		productController = new ProductController();

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

	/** 记录当前分页ID */

	private void init()
	{

		setIndicator(R.string.design, 0, new Intent(this,
				ManageDesignActivity.class));
		setIndicator(R.string.product, 1, new Intent(this,
				ManageProductActivity.class));

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
					// currentTabID = mTabHost.getTabCount() - 1;
					currentTabID++;
					return false;
				}
			}
			else if (e1.getX() - e2.getX() >= ON_TOUCH_DISTANCE)
			{
				currentTabID = mTabHost.getCurrentTab() + 1;

				if (currentTabID >= mTabHost.getTabCount())
				{
					// currentTabID = 0;
					currentTabID--;
					return false;
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
		getMenuInflater().inflate(R.menu.manage_tab, menu);
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

			case R.id.action_settings:
				config();
				break;
			case R.id.action_add:
				Log.v("currentTabId",""+currentTabID);
				add();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean add()
	{
		switch (currentTabID)
		{
			case 0:
				addDesign();
				break;
			case 1:
				addProduct();
				break;
			default:
				break;
		}
		return true;
	}
	public boolean addDesign()
	{
		
		Design design = new Design();
		design.setSerialNumber("N/A");
		design.setProductName("N/A");
		design.setItemCode("N/A");
		design.setGuaranteeTime("N/A");
		design.setMTBF("N/A");
		design.setStorageLife("N/A");
		design.setTotalLife("N/A");
		long id = designController.add(design);
		
		Bundle bundle = new Bundle();
		bundle.putString("op_type","ADD");
		bundle.putString("origin_class", "ManageTabActivity");
		bundle.putLong("id", id);
		Intent intent = new Intent(this,ManageDesignCatalogActivity.class);
		intent.putExtras(bundle);
		startActivityForResult(intent,0);
		return true;
	}
	public boolean addProduct()
	{
		Product product = new Product();
		product.setSerialNumber("N/A");
		product.setProductName("N/A");
		product.setItemCode("N/A");
		product.setGuarranteeTime("N/A");
		product.setMTBF("N/A");
		product.setStorageLife("N/A");
		product.setTotalLife("N/A");
		long id = productController.add(product);
		
		Bundle bundle = new Bundle();
		bundle.putString("op_type","ADD");
		bundle.putString("origin_class", "ManageTabActivity");
		bundle.putLong("id", id);
		Intent intent = new Intent(this,ManageProductCatalogActivity.class);
		intent.putExtras(bundle);
		startActivityForResult(intent, 0);
		return true;
	}
	public boolean config()
	{
		Intent intent = new Intent(ManageTabActivity.this, ConfigActivity.class);
		startActivity(intent);
		return true;
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
				handleResult(data);
				break;
			default:
				break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	/**
	 * 
	 * @param data
	 * 
	 */
	private void handleResult(Intent data)
	{
		Bundle bundle = data.getExtras();
		String type = bundle.getString("design_product");
		
		Log.v("tabresult", "abc");
		return;
	}

	private GestureDetector gestureDetector;
	private AnimationTabHost mTabHost;
	private TabWidget mTabWidget;
	private int currentTabID = 0;  
	private DesignController designController;
	private ProductController productController;

}
