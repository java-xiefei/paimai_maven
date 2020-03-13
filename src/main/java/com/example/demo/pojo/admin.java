package com.example.demo.pojo;

public class admin {
	private Integer userid;
	private String username;
	private String userpassword;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	@Override
	public String toString() {
		return "admin [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + "]";
	}

}
