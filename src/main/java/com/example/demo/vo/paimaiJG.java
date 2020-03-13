package com.example.demo.vo;

public class paimaiJG {
	private String auctionname;
	private String auctionstarttime;
	private String auctionendtime;
	private String auctionstartprice;
	private String cjj;
	private String aname;
	public String getAuctionname() {
		return auctionname;
	}
	public void setAuctionname(String auctionname) {
		this.auctionname = auctionname;
	}
	public String getAuctionstarttime() {
		return auctionstarttime;
	}
	public void setAuctionstarttime(String auctionstarttime) {
		this.auctionstarttime = auctionstarttime;
	}
	public String getAuctionendtime() {
		return auctionendtime;
	}
	public void setAuctionendtime(String auctionendtime) {
		this.auctionendtime = auctionendtime;
	}
	public String getAuctionstartprice() {
		return auctionstartprice;
	}
	public void setAuctionstartprice(String auctionstartprice) {
		this.auctionstartprice = auctionstartprice;
	}
	public String getCjj() {
		return cjj;
	}
	public void setCjj(String cjj) {
		this.cjj = cjj;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "paimaiJG [auctionname=" + auctionname + ", auctionstarttime=" + auctionstarttime + ", auctionendtime="
				+ auctionendtime + ", auctionstartprice=" + auctionstartprice + ", cjj=" + cjj + ", aname=" + aname + "]";
	}

}
