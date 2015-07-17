/**
 * 
 */
package com.logbook.model;


/**
 * @author longwind
 *
 */
public class DesignParameter
{
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
	 * @return the designId
	 */
	public int getDesignId()
	{
		return designId;
	}
	/**
	 * @param designId the designId to set
	 */
	public void setDesignId(int designId)
	{
		this.designId = designId;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the unit
	 */
	public String getUnit()
	{
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	/**
	 * @return the value
	 */
	public Double getValue()
	{
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Double value)
	{
		this.value = value;
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
	 * @return the reserve
	 */
	public String getReserve()
	{
		return reserve;
	}
	/**
	 * @param reserve the reserve to set
	 */
	public void setReserve(String reserve)
	{
		this.reserve = reserve;
	}
	/**
	 * @return the reserve2
	 */
	public int getReserve2()
	{
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(int reserve2)
	{
		this.reserve2 = reserve2;
	}
	private int designId;
	private String name;
	private String unit;
	private Double value;
	private Boolean mark;
	private String reserve;
	private int	reserve2;
}
