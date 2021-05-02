package com.goldrush.dto;

import java.sql.Timestamp;

public class ItemListDTO {
	private int itemsId;
	private String code;
	private String name;
	private String category;
	private String stage;
	private int cost;
	private int quantity;
	private Timestamp openingDate;
	private Timestamp ipoDate;
	private Timestamp tradingDate;
	private Timestamp clearingDate;
	private String description;
	private String imgAddress;
	private int price;
	private int buyOffer;
	private int sellOffer;
	
	public ItemListDTO() {
		super();
	}
	
	public ItemListDTO(int itemsId, String code, String name, String category, String stage, int cost, int quantity,
			Timestamp openingDate, Timestamp ipoDate, Timestamp tradingDate, Timestamp clearingDate, String description,
			String imgAddress, int price, int buyOffer, int sellOffer) {
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
		this.tradingDate = tradingDate;
		this.clearingDate = clearingDate;
		this.description = description;
		this.imgAddress = imgAddress;
		this.price = price;
		this.buyOffer = buyOffer;
		this.sellOffer = sellOffer;
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
	public Timestamp getTradingDate() {
		return tradingDate;
	}
	public void setTradingDate(Timestamp tradingDate) {
		this.tradingDate = tradingDate;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBuyOffer() {
		return buyOffer;
	}
	public void setBuyOffer(int buyOffer) {
		this.buyOffer = buyOffer;
	}
	public int getSellOffer() {
		return sellOffer;
	}
	public void setSellOffer(int sellOffer) {
		this.sellOffer = sellOffer;
	}
	
	@Override
	public String toString() {
		return "ItemListDTO [itemsId=" + itemsId + ", code=" + code + ", name=" + name + ", category=" + category
				+ ", stage=" + stage + ", cost=" + cost + ", quantity=" + quantity + ", openingDate=" + openingDate
				+ ", ipoDate=" + ipoDate + ", tradingDate=" + tradingDate + ", clearingDate=" + clearingDate
				+ ", description=" + description + ", imgAddress=" + imgAddress + ", price=" + price + ", buyOffer="
				+ buyOffer + ", sellOffer=" + sellOffer + "]";
	}
}
