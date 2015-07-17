/**
 * 
 */
package com.logbook.model;

/**
 * @author longwind
 *
 */
public class ProductAncillary
{

	/**
	 * 
	 */
	public ProductAncillary()
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
	 * @return the serialNumber
	 */
	public String getSerialNumber()
	{
		return serialNumber;
	}
	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
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
	private String name;
	private String serialNumber;
	private int quantity;
	private String remark;
	private boolean mark;
	private String reserved_1;
	private int reserved_2;
}
