package com.lcomputerstudy.books.java.ch08.ex06;

public class Book {
	
	public String title;
	private String author;
	protected int price;
	protected int dollarPrice;
	protected int edition;
	protected float tax;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	protected void setPrice(int price) {
		this.price = price;
		setDollarPrice(price);
	}
	
	protected int getPrice() {
		return price;
	}
	
	protected void setDollarPrice(int price) {
		dollarPrice = (int)(price / 1000f);
	}
	
	protected int getDollarPrice() {
		return dollarPrice;
	}
	
	protected void setTax(float tax) {
		this.tax = tax;
	}
	
	
	protected float getTax() {
		return tax;
	}
	
	
}
