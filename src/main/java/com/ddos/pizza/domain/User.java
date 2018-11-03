package com.ddos.pizza.domain;

public class User {
	private String userId;
	private String userName;
	private String userTrueName;
	private String userPass;
	private String userAge;
	private String userAddr;
	private String userImgUrl;
	private String userImgName;
	private String userPhone;
	private char userSex;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserImgUrl() {
		return userImgUrl;
	}
	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}
	public String getUserImgName() {
		return userImgName;
	}
	public void setUserImgName(String userImgName) {
		this.userImgName = userImgName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public char getUserSex() {
		return userSex;
	}
	public void setUserSex(char userSex) {
		this.userSex = userSex;
	}
	public User(String userId, String userName, String userTrueName, String userPass, String userAge, String userAddr,
			String userImgUrl, String userImgName, String userPhone, char userSex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTrueName = userTrueName;
		this.userPass = userPass;
		this.userAge = userAge;
		this.userAddr = userAddr;
		this.userImgUrl = userImgUrl;
		this.userImgName = userImgName;
		this.userPhone = userPhone;
		this.userSex = userSex;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userTrueName=" + userTrueName + ", userPass="
				+ userPass + ", userAge=" + userAge + ", userAddr=" + userAddr + ", userImgUrl=" + userImgUrl
				+ ", userImgName=" + userImgName + ", userPhone=" + userPhone + ", userSex=" + userSex + "]";
	}

	

}
