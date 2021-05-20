package com.goldrush.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

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
	private Timestamp clearingDate;
	private String description;
	private String imgAddress;
	private int price;
	private int buyOffer;
	private int sellOffer;
	private int RemainingAmount;
	private List<PriceGraph> priceGraph;
	private int outstanding;

	public int getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(int outstanding) {
		this.outstanding = outstanding;
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

	public int getRemainingAmount() {
		return RemainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		RemainingAmount = remainingAmount;
	}

	public List<PriceGraph> getPriceGraph() {
		return priceGraph;
	}

	public void setPriceGraph(List<PriceGraph> priceGraph) {
		this.priceGraph = priceGraph;
	}

	@Override
	public String toString() {
		return "ItemListDTO [itemsId=" + itemsId + ", code=" + code + ", name=" + name + ", category=" + category
				+ ", stage=" + stage + ", cost=" + cost + ", quantity=" + quantity + ", openingDate=" + openingDate
				+ ", ipoDate=" + ipoDate + ", clearingDate=" + clearingDate + ", description=" + description
				+ ", imgAddress=" + imgAddress + ", price=" + price + ", buyOffer=" + buyOffer + ", sellOffer="
				+ sellOffer + ", RemainingAmount=" + RemainingAmount + ", priceGraph=" + priceGraph + ", outstanding="
				+ outstanding + "]";
	}


	
	

	
}
