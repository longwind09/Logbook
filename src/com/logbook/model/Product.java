package com.logbook.model;


public class Product extends BaseObject
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
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	/**
	 * @return the manufacturerCode
	 */
	public String getManufacturerCode()
	{
		return manufacturerCode;
	}
	/**
	 * @param manufacturerCode the manufacturerCode to set
	 */
	public void setManufacturerCode(String manufacturerCode)
	{
		this.manufacturerCode = manufacturerCode;
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
	 * @return the order
	 */
	public String getOrder()
	{
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order)
	{
		this.order = order;
	}
	/**
	 * @return the guarranteeTime
	 */
	public String getGuarranteeTime()
	{
		return guarranteeTime;
	}
	/**
	 * @param guarranteeTime the guarranteeTime to set
	 */
	public void setGuarranteeTime(String guarranteeTime)
	{
		this.guarranteeTime = guarranteeTime;
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
	/**
	 * @return the guranteePeriod
	 */
	public String getGuranteePeriod()
	{
		return guranteePeriod;
	}
	/**
	 * @param guranteePeriod the guranteePeriod to set
	 */
	public void setGuranteePeriod(String guranteePeriod)
	{
		this.guranteePeriod = guranteePeriod;
	}
	/**
	 * @return the manuafacturer
	 */
	public String getManuafacturer()
	{
		return manuafacturer;
	}
	/**
	 * @param manuafacturer the manuafacturer to set
	 */
	public void setManuafacturer(String manuafacturer)
	{
		this.manuafacturer = manuafacturer;
	}
	/**
	 * @return the purchaser
	 */
	public String getPurchaser()
	{
		return purchaser;
	}
	/**
	 * @param purchaser the purchaser to set
	 */
	public void setPurchaser(String purchaser)
	{
		this.purchaser = purchaser;
	}
	/**
	 * @return the acceptanceTime
	 */
	public String getAcceptanceTime()
	{
		return acceptanceTime;
	}
	/**
	 * @param acceptanceTime the acceptanceTime to set
	 */
	public void setAcceptanceTime(String acceptanceTime)
	{
		this.acceptanceTime = acceptanceTime;
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
	private int designId;
	private String serialNumber;
	private String productName;
	private String state;
	private String manufacturerCode;
	private String itemCode;
	private String order;
	private String guarranteeTime;
	private String totalLife;
	private String MTBF;
	private String storageLife;
	private String guranteePeriod;
	private String manuafacturer;
	private String purchaser;
	private String acceptanceTime;
	private Boolean mark;
	private String reserved_1;
	private int reserved_2;
	
	
}
