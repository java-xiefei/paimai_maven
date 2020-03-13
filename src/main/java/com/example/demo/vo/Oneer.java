package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

public class Oneer {
	private Integer auctionid;
	private String auctionname;
	private String auctionstarttime;
	private String auctionendtime;
	private String auctionstartprice;
	private List<Tower> tower = new ArrayList<Tower>(0);
	public Integer getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}
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
	public List<Tower> getTower() {
		return tower;
	}
	public void setTower(List<Tower> tower) {
		this.tower = tower;
	}
	public Oneer(Integer auctionid, String auctionname, String auctionstarttime, String auctionendtime,
			String auctionstartprice, List<Tower> tower) {
		super();
		this.auctionid = auctionid;
		this.auctionname = auctionname;
		this.auctionstarttime = auctionstarttime;
		this.auctionendtime = auctionendtime;
		this.auctionstartprice = auctionstartprice;
		this.tower = tower;
	}
	public Oneer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Oneer [auctionid=" + auctionid + ", auctionname=" + auctionname + ", auctionstarttime=" + auctionstarttime
				+ ", auctionendtime=" + auctionendtime + ", auctionstartprice=" + auctionstartprice + ", tower=" + tower
				+ "]";
	}


}
