package com.logbook.model;

import android.R.bool;
import android.R.integer;

public class UseMaintain extends BaseObject
{

	/**
	 * @return the productId
	 */
	public int getProductId()
	{
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	/**
	 * @return the useMaintainType
	 */
	public int getUseMaintainType()
	{
		return useMaintainType;
	}
	/**
	 * @param useMaintainType the useMaintainType to set
	 */
	public void setUseMaintainType(int useMaintainType)
	{
		this.useMaintainType = useMaintainType;
	}
	/**
	 * @return the mark
	 */
	public Boolean getMark()
	{
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(Boolean mark)
	{
		this.mark = mark;
	}
	/**
	 * @return the reserved_1
	 */
	public String getReserved_1()
	{
		return reserved_1;
	}
	/**
	 * @param reserved_1 the reserved_1 to set
	 */
	public void setReserved_1(String reserved_1)
	{
		this.reserved_1 = reserved_1;
	}
	/**
	 * @return the reserved_2
	 */
	public int getReserved_2()
	{
		return reserved_2;
	}
	/**
	 * @param reserved_2 the reserved_2 to set
	 */
	public void setReserved_2(int reserved_2)
	{
		this.reserved_2 = reserved_2;
	}
	private int id;
	private int productId;
	private int useMaintainType;
	private Boolean mark;
	private String reserved_1;
	private int reserved_2;
}
