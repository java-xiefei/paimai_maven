package com.example.demo.vo;

public class Tower {
	private String aname;
	private Integer auctionprice;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getAuctionprice() {
		return auctionprice;
	}
	public void setAuctionprice(Integer auctionprice) {
		this.auctionprice = auctionprice;
	}
	@Override
	public String toString() {
		return "Tower [aname=" + aname + ", auctionprice=" + auctionprice + "]";
	}
}
