/**
 * 
 */
package com.logbook.impl;

/**
 * @author longwind
 *
 */
import android.app.Application;

public class ContextUtility extends Application
{
	private static ContextUtility instance;

	public static ContextUtility getInstance()
	{
		return instance;
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
	}
}
