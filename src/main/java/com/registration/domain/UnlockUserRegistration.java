package com.registration.domain;

import lombok.Data;

@Data
public class UnlockUserRegistration {

	private String email;
	private String tempPwd;
	private String newPwd;
	private String cnfPwd;

}
