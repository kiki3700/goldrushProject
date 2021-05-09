package com.goldrush.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class PriceGraph {
		Timestamp date;
		int price;
		public Timestamp getDate() {
			return date;
		}
		public void setDate(Timestamp date) {
			this.date = date;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "PriceGraph [date=" + date + ", price=" + price + "]";
		}
}
