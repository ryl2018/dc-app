package com.ddos.pizza.domain;

import lombok.*;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
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
}
