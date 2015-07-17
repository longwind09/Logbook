/**
 * 
 */
package com.logbook.model;

/**
 * @author longwind
 *
 */
public class UseMaintainMap
{

	/**
	 * 
	 */
	public UseMaintainMap()
	{
		// TODO Auto-generated constructor stub
	}
	
	private int id;
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
	 * @return the tableName
	 */
	public String getTableName()
	{
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName)
	{
		this.tableName = tableName;
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

	private String tableName;
	private int useMaintainType;
}
