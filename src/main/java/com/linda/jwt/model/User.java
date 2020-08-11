package com.linda.jwt.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String gender;
	private String phone;
	private String address;
	private String detailaddress;
	private Timestamp birthday;
	private int total_amount;
	private String role;
	private String cancel;
	private String profile;
	private Timestamp createDate;
}
