/**
 * 
 */
package com.logbook.model;

import java.util.Date;

import android.R.integer;

/**
 * @author longwind
 *
 */
public class PerformanceCheckRecord
{

	/**
	 * 
	 */
	public PerformanceCheckRecord()
	{
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the useMaintainId
	 */
	public int getUseMaintainId()
	{
		return useMaintainId;
	}
	/**
	 * @param useMaintainId the useMaintainId to set
	 */
	public void setUseMaintainId(int useMaintainId)
	{
		this.useMaintainId = useMaintainId;
	}
	/**
	 * @return the order
	 */
	public int getOrder()
	{
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order)
	{
		this.order = order;
	}
	/**
	 * @return the checkItem
	 */
	public String getCheckItem()
	{
		return checkItem;
	}
	/**
	 * @param checkItem the checkItem to set
	 */
	public void setCheckItem(String checkItem)
	{
		this.checkItem = checkItem;
	}
	/**
	 * @return the sign
	 */
	public String getSign()
	{
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	/**
	 * @return the result_01
	 */
	public String getResult_01()
	{
		return result_01;
	}
	/**
	 * @param result_01 the result_01 to set
	 */
	public void setResult_01(String result_01)
	{
		this.result_01 = result_01;
	}
	/**
	 * @return the result_02
	 */
	public String getResult_02()
	{
		return result_02;
	}
	/**
	 * @param result_02 the result_02 to set
	 */
	public void setResult_02(String result_02)
	{
		this.result_02 = result_02;
	}
	/**
	 * @return the checkOperator_01
	 */
	public String getCheckOperator_01()
	{
		return checkOperator_01;
	}
	/**
	 * @param checkOperator_01 the checkOperator_01 to set
	 */
	public void setCheckOperator_01(String checkOperator_01)
	{
		this.checkOperator_01 = checkOperator_01;
	}
	/**
	 * @return the checkOperator_02
	 */
	public String getCheckOperator_02()
	{
		return checkOperator_02;
	}
	/**
	 * @param checkOperator_02 the checkOperator_02 to set
	 */
	public void setCheckOperator_02(String checkOperator_02)
	{
		this.checkOperator_02 = checkOperator_02;
	}
	/**
	 * @return the date01
	 */
	public Date getDate01()
	{
		return date01;
	}
	/**
	 * @param date01 the date01 to set
	 */
	public void setDate01(Date date01)
	{
		this.date01 = date01;
	}
	/**
	 * @return the date02
	 */
	public Date getDate02()
	{
		return date02;
	}
	/**
	 * @param date02 the date02 to set
	 */
	public void setDate02(Date date02)
	{
		this.date02 = date02;
	}
	/**
	 * @return the mark
	 */
	public boolean isMark()
	{
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(boolean mark)
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
	private int useMaintainId;
	private int order;
	private String checkItem;
	private String sign;
	private String result_01;
	private String result_02;
	private String checkOperator_01;
	private String checkOperator_02;
	private Date date01;
	private Date date02;
	private boolean mark;
	private String reserved_1;
	private int reserved_2;
}
