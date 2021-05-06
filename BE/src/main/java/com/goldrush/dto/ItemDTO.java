package com.goldrush.dto;

import java.sql.Timestamp;


public class ItemDTO {
	private int itemsId;
	private String code;
	private String name;
	private String category;
	private String stage;
	private int cost;
	private int quantity;
	private Timestamp openingDate;
	private Timestamp ipoDate;
	private Timestamp clearingDate;
	private String description;
	private String imgAddress;
	
	
	public ItemDTO() {
		super();
	}


	public ItemDTO(int itemsId, String code, String name, String category, String stage, int cost, int quantity,
			Timestamp openingDate, Timestamp ipoDate, Timestamp clearingDate, String description, String imgAddress) {
		super();
		this.itemsId = itemsId;
		this.code = code;
		this.name = name;
		this.category = category;
		this.stage = stage;
		this.cost = cost;
		this.quantity = quantity;
		this.openingDate = openingDate;
		this.ipoDate = ipoDate;
		this.clearingDate = clearingDate;
		this.description = description;
		this.imgAddress = imgAddress;
	}


	public int getItemsId() {
		return itemsId;
	}


	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getStage() {
		return stage;
	}


	public void setStage(String stage) {
		this.stage = stage;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Timestamp getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(Timestamp openingDate) {
		this.openingDate = openingDate;
	}


	public Timestamp getIpoDate() {
		return ipoDate;
	}


	public void setIpoDate(Timestamp ipoDate) {
		this.ipoDate = ipoDate;
	}


	public Timestamp getClearingDate() {
		return clearingDate;
	}


	public void setClearingDate(Timestamp clearingDate) {
		this.clearingDate = clearingDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgAddress() {
		return imgAddress;
	}


	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

}
