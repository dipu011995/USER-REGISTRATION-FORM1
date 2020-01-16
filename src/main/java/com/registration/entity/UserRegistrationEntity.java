package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

/**
 * This is Entity Class contains Properties to interact with DB
 * 
 * @author Pankaj Kumar
 *
 */
@Data
@Entity
@Table(name = "USER_REGISTRATION")
public class UserRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", length = 10)
	@Type(type = "int")
	private Integer userId;

	@Column(name = "FIRST_NAME", length = 20)
	@Type(type = "string")
	private String fname;

	@Column(name = "LAST_NAME", length = 20)
	@Type(type = "string")
	private String lname;

	@Column(name = "EMAIL", length = 30)
	@Type(type = "string")
	private String email;

	@Column(name = "PHNO", length = 10)
	@Type(type = "long")
	private Long phNo;

	@Column(name = "GENDER", length = 1)
	@Type(type = "string")
	private String gender;

	@Column(name = "COUNTRY", length = 15)
	@Type(type = "string")
	private String country;

	@Column(name = "STATE", length = 15)
	@Type(type = "string")
	private String state;

	@Column(name = "CITY", length = 15)
	@Type(type = "string")
	private String city;

	@Column(name = "STATUS", length = 10)
	@Type(type = "string")
	private String status;

	@Column(name = "PASSWORD", length = 20)
	@Type(type = "string")
	private String password;
}
