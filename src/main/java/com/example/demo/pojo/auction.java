package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("auction")
public class auction {
	@TableId(type = IdType.AUTO,value = "auctionId")
	private Integer auctionid;
	private Integer aid;
	private String auctionname;
	private Integer auctionstartprice;
	private Integer auctionupset;
	private String auctionstarttime;
	private String auctionendtime;
	private String auctionpic;
	private String auctiondesc;
	public Integer getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAuctionname() {
		return auctionname;
	}
	public void setAuctionname(String auctionname) {
		this.auctionname = auctionname;
	}
	public Integer getAuctionstartprice() {
		return auctionstartprice;
	}
	public void setAuctionstartprice(Integer auctionstartprice) {
		this.auctionstartprice = auctionstartprice;
	}
	public Integer getAuctionupset() {
		return auctionupset;
	}
	public void setAuctionupset(Integer auctionupset) {
		this.auctionupset = auctionupset;
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
	public String getAuctionpic() {
		return auctionpic;
	}
	public void setAuctionpic(String auctionpic) {
		this.auctionpic = auctionpic;
	}
	public String getAuctiondesc() {
		return auctiondesc;
	}
	public void setAuctiondesc(String auctiondesc) {
		this.auctiondesc = auctiondesc;
	}
	public auction(Integer auctionid, Integer aid, String auctionname, Integer auctionstartprice, Integer auctionupset,
			String auctionstarttime, String auctionendtime, String auctionpic, String auctiondesc) {
		super();
		this.auctionid = auctionid;
		this.aid = aid;
		this.auctionname = auctionname;
		this.auctionstartprice = auctionstartprice;
		this.auctionupset = auctionupset;
		this.auctionstarttime = auctionstarttime;
		this.auctionendtime = auctionendtime;
		this.auctionpic = auctionpic;
		this.auctiondesc = auctiondesc;
	}
	public auction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "auction [auctionid=" + auctionid + ", aid=" + aid + ", auctionname=" + auctionname
				+ ", auctionstartprice=" + auctionstartprice + ", auctionupset=" + auctionupset + ", auctionstarttime="
				+ auctionstarttime + ", auctionendtime=" + auctionendtime + ", auctionpic=" + auctionpic
				+ ", auctiondesc=" + auctiondesc + "]";
	}

}
