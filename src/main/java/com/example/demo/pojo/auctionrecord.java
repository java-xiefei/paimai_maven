package com.example.demo.pojo;

public class auctionrecord {
	private Integer id;
	private Integer aid;
	private Integer auctionid;
	private String auctiontime;
	private Integer auctionprice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}
	public String getAuctiontime() {
		return auctiontime;
	}
	public void setAuctiontime(String auctiontime) {
		this.auctiontime = auctiontime;
	}
	public Integer getAuctionprice() {
		return auctionprice;
	}
	public void setAuctionprice(Integer auctionprice) {
		this.auctionprice = auctionprice;
	}
	public auctionrecord(Integer id, Integer aid, Integer auctionid, String auctiontime, Integer auctionprice) {
		super();
		this.id = id;
		this.aid = aid;
		this.auctionid = auctionid;
		this.auctiontime = auctiontime;
		this.auctionprice = auctionprice;
	}
	public auctionrecord() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "auctionrecord [id=" + id + ", aid=" + aid + ", auctionid=" + auctionid + ", auctiontime=" + auctiontime
				+ ", auctionprice=" + auctionprice + "]";
	}

}
