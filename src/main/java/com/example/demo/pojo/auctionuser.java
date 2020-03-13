package com.example.demo.pojo;

public class auctionuser {
	private Integer aid;
	private String aname;
	private String apassword;
	private String acardno;
	private String atel;
	private String aaddress;
	private String apostnumber;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getAcardno() {
		return acardno;
	}
	public void setAcardno(String acardno) {
		this.acardno = acardno;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getApostnumber() {
		return apostnumber;
	}
	public void setApostnumber(String apostnumber) {
		this.apostnumber = apostnumber;
	}
	public auctionuser(Integer aid, String aname, String apassword, String acardno, String atel, String aaddress,
			String apostnumber) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apassword = apassword;
		this.acardno = acardno;
		this.atel = atel;
		this.aaddress = aaddress;
		this.apostnumber = apostnumber;
	}
	public auctionuser() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "auctionuser [aid=" + aid + ", aname=" + aname + ", apassword=" + apassword + ", acardno=" + acardno
				+ ", atel=" + atel + ", aaddress=" + aaddress + ", apostnumber=" + apostnumber + "]";
	}
}
