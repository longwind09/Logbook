/**
 * 
 */
package com.logbook.model;

/**
 * @author longwind
 *
 */
public class ProductParameter
{

	/**
	 * 
	 */
	public ProductParameter()
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
	 * @return the parameterName
	 */
	public String getParameterName()
	{
		return parameterName;
	}
	/**
	 * @param parameterName the parameterName to set
	 */
	public void setParameterName(String parameterName)
	{
		this.parameterName = parameterName;
	}
	/**
	 * @return the parameterUnit
	 */
	public String getParameterUnit()
	{
		return parameterUnit;
	}
	/**
	 * @param parameterUnit the parameterUnit to set
	 */
	public void setParameterUnit(String parameterUnit)
	{
		this.parameterUnit = parameterUnit;
	}
	/**
	 * @return the parameterValue
	 */
	public double getParameterValue()
	{
		return parameterValue;
	}
	/**
	 * @param parameterValue the parameterValue to set
	 */
	public void setParameterValue(double parameterValue)
	{
		this.parameterValue = parameterValue;
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
	private int productId;
	private String parameterName;
	private String parameterUnit;
	private double parameterValue;
	private boolean mark;
	private String reserved_1;
	private int reserved_2;
}
