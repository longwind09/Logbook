/**
 * 
 */
package com.logbook.model;

import java.util.Date;

/**
 * @author longwind
 *
 */
public class PreservationRecord
{

	/**
	 * 
	 */
	public PreservationRecord()
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
	 * @return the workName
	 */
	public String getWorkName()
	{
		return workName;
	}
	/**
	 * @param workName the workName to set
	 */
	public void setWorkName(String workName)
	{
		this.workName = workName;
	}
	/**
	 * @return the storageLife
	 */
	public String getStorageLife()
	{
		return storageLife;
	}
	/**
	 * @param storageLife the storageLife to set
	 */
	public void setStorageLife(String storageLife)
	{
		this.storageLife = storageLife;
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
	private Date date;
	private String workName;
	private String storageLife;
	private String department;
	private String sign;
	private boolean mark;
	private String reserved_1;
	private int reserved_2;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
