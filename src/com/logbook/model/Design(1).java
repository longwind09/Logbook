package com.logbook.model;

/**
 * @author longwind
 * 设计
 */
public class Design extends BaseObject
{
	
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
	 * @return the productName
	 */
	public String getProductName()
	{
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	/**
	 * @return the itemCode
	 */
	public String getItemCode()
	{
		return itemCode;
	}
	/**
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
	/**
	 * @return the guaranteeTime
	 */
	public String getGuaranteeTime()
	{
		return guaranteeTime;
	}
	/**
	 * @param guaranteeTime the guaranteeTime to set
	 */
	public void setGuaranteeTime(String guaranteeTime)
	{
		this.guaranteeTime = guaranteeTime;
	}
	/**
	 * @return the totalLife
	 */
	public String getTotalLife()
	{
		return totalLife;
	}
	/**
	 * @param totalLife the totalLife to set
	 */
	public void setTotalLife(String totalLife)
	{
		this.totalLife = totalLife;
	}
	/**
	 * @return the mTBF
	 */
	public String getMTBF()
	{
		return MTBF;
	}
	/**
	 * @param mTBF the mTBF to set
	 */
	public void setMTBF(String mTBF)
	{
		MTBF = mTBF;
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
	

	private int id;
	private String serialNumber;
	private String productName;
	private String itemCode;
	private String guaranteeTime;
	private String totalLife;
	private String MTBF;
	private String storageLife;
}
