package com.java.DTO;

public class ItemDTO {
	private String category;
	private String itemNumber;
	private String itemName;
	private String dcPrice;
	private String originPrice;
	private String desc;
	private String unit;
	private String weight;
	private String delivery;
	private String packing;
	private String filename;

	public ItemDTO(String category, String itemNumber, String itemName, String dcPrice, String originPrice, String desc,
			String unit, String weight, String delivery, String packing, String filename) {
		this.category = category;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.dcPrice = dcPrice;
		this.originPrice = originPrice;
		this.desc = desc;
		this.unit = unit;
		this.weight = weight;
		this.delivery = delivery;
		this.packing = packing;
		this.filename = filename;
	}

	public String getCategory() {
		return category;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDcPrice() {
		return dcPrice;
	}

	public String getOriginPrice() {
		return originPrice;
	}

	public String getDesc() {
		return desc;
	}

	public String getUnit() {
		return unit;
	}

	public String getWeight() {
		return weight;
	}

	public String getDelivery() {
		return delivery;
	}

	public String getPacking() {
		return packing;
	}

	public String getFilename() {
		return filename;
	}

}
