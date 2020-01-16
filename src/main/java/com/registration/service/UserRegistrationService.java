package com.registration.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.registration.domain.UnlockUserRegistration;
import com.registration.domain.UserLogin;
import com.registration.domain.UserRegistration;
import com.registration.entity.UserRegistrationEntity;

public interface UserRegistrationService {

	public boolean saveUserDetails(UserRegistration ur) throws MessagingException,IOException;

	public void forwardMail(UserRegistration usrReg, String tempPwd)  throws MessagingException, IOException ;

	public String readMailFormTextFile(UserRegistration usrRegstion, String password, String fileName) throws IOException ;

	public boolean activeUserAccount(UnlockUserRegistration unlockUsrRegstion);

	public UserRegistrationEntity chkCredentialByEmailAndPwd(UserLogin login);

	public String getUserForChangePwd(String email) throws MessagingException, IOException;
	
	public String getByEmail(String email);
	
}	
