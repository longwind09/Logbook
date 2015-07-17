/**
 * 
 */
package com.logbook.model;

import java.util.Date;

/**
 * @author longwind
 *
 */
public class DisassembleRecord
{

	/**
	 * 
	 */
	public DisassembleRecord()
	{
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		return super.clone();
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
	 * @return the productSerialNumber
	 */
	public String getProductSerialNumber()
	{
		return productSerialNumber;
	}
	/**
	 * @param productSerialNumber the productSerialNumber to set
	 */
	public void setProductSerialNumber(String productSerialNumber)
	{
		this.productSerialNumber = productSerialNumber;
	}
	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
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
	 * @return the department
	 */
	public String getDepartment()
	{
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department)
	{
		this.department = department;
	}
	/**
	 * @return the reason
	 */
	public String getReason()
	{
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	/**
	 * @return the worktime
	 */
	public String getWorktime()
	{
		return worktime;
	}
	/**
	 * @param worktime the worktime to set
	 */
	public void setWorktime(String worktime)
	{
		this.worktime = worktime;
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
	private String productSerialNumber;
	private Date date;
	private String sign;
	private String department;
	private String reason;
	private String worktime;
	private boolean mark;
	private String reserved_1;
	private int reserved_2;
}
