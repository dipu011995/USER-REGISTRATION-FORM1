package com.registration.domain;

import lombok.Data;

@Data
public class UserRegistration {

	private Integer userId;
	private String fname;
	private String lname;
	private String email;
	private Long phNo;
	private String gender;
	private String country;
	private String state;
	private String city;

}
