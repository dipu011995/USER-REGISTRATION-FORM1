package com.registration.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.constraints.AppConstraints;
import com.registration.domain.UnlockUserRegistration;
import com.registration.domain.UserLogin;
import com.registration.domain.UserRegistration;
import com.registration.entity.UserRegistrationEntity;
import com.registration.mail.UtilMails;
import com.registration.repositeries.UserRegistrationRepositeries;

/**
 * This class is for performing curd operation. It Implementing JpaRepositeries
 * indirectly which have some pre-defind method to perform crud operation
 * 
 * @author Pankaj Kumar
 *
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationRepositeries usrRegRepositeries;

	@Autowired
	private UtilMails utilmails;

	/**
	 * This Method is to save the user details in DB
	 * 
	 * @throws IOException
	 * @throws MessagingException
	 * @throws Exception
	 */
	@Override
	public boolean saveUserDetails(UserRegistration uesrReg) throws MessagingException,IOException {

		UserRegistrationEntity entity = new UserRegistrationEntity();

		BeanUtils.copyProperties(uesrReg, entity);

		String tempPwd = generateRndPwd();

		entity.setPassword(tempPwd);

		entity.setStatus("INACTIVE");

		UserRegistrationEntity savedEntity = usrRegRepositeries.save(entity);

		boolean isSaved = savedEntity.getUserId() > 0;

		if (isSaved) {
			try {
				forwardMail(uesrReg, tempPwd);
			}catch (MessagingException me) {
				throw me;
			}catch (IOException ioe) {
				throw ioe;
			}
		}
		return isSaved;
	}

	/**
	 * This Method Generate the random alpha-numeric String
	 * 
	 * @return
	 */
	
	public String generateRndPwd() {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		StringBuilder salt = new StringBuilder();

		Random rnd = new Random();

		while (salt.length() < 8) { 
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}

		return salt.toString();

	}

	/**
	 * This Method call the sendMail(-) Method to send a mail
	 * 
	 * @throws MessagingException
	 * @throws IOException
	 */
	@Override
	public void forwardMail(UserRegistration usrReg, String tempPwd) throws MessagingException, IOException {

		String fileName = AppConstraints.EMAIL_TXT_FILE;

		String body = readMailFormTextFile(usrReg, tempPwd, fileName);

		utilmails.sendMail(usrReg.getEmail(), AppConstraints.EMAIL_SUBJECT, body);
	}

	/**
	 * This Method is to read the message from text file
	 * 
	 * @throws IOException
	 */
	@Override
	public String readMailFormTextFile(UserRegistration usrRegstion, String password, String fileName)
			throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line = reader.readLine();
		while (line != null) {
			if (line.contains(AppConstraints.TO_NAME)) {
				line = line.replace(AppConstraints.TO_NAME, usrRegstion.getFname());
			} else if (line.contains(AppConstraints.PAZZWORD)) {
				line = line.replace(AppConstraints.PAZZWORD, password);
			} else if (line.contains(AppConstraints.LOGIN_LINK)) {
				line = line.replace(AppConstraints.LOGIN_LINK, usrRegstion.getEmail());
			}
			sb.append(line);
			line = reader.readLine();
		}
		reader.close();
		return String.valueOf(sb);
	}

	/**
	 * This Method get the UserAccount Details
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public boolean activeUserAccount(UnlockUserRegistration unlockUsrReg) {

		boolean flag = false;

		UserRegistrationEntity usrRegEntity = usrRegRepositeries.getAccDetaisByEmailAndTempPwd(unlockUsrReg.getEmail(),
				unlockUsrReg.getTempPwd());

		if (usrRegEntity != null) {
			if (usrRegEntity.getPassword().equals(unlockUsrReg.getTempPwd())) {
				usrRegEntity.setStatus("ACTIVE");
				usrRegEntity.setPassword(unlockUsrReg.getNewPwd());
				
				usrRegRepositeries.save(usrRegEntity);

				flag = true;
			}
		}
		return flag;
	}

	/**
	 * This Method check the Credential User By sending email id and password
	 */
	@Override
	public UserRegistrationEntity chkCredentialByEmailAndPwd(UserLogin login) {

		return usrRegRepositeries.getUserByEmailAndOriginalPwd(login.getEmail(), login.getPassword());
	}

	/**
	 * This Method the get old password of user and change password of User
	 * 
	 * @throws MessagingException
	 * @throws IOException
	 */
	@Override
	public String getUserForChangePwd(String email) throws MessagingException, IOException {

		String message;

		UserRegistrationEntity userEntity = usrRegRepositeries.getUserByEmail(email);

		if (userEntity != null) {
			if ("ACTIVE".equals(userEntity.getStatus())) {

				UserRegistration usrReg = new UserRegistration();

				String fileName = AppConstraints.FORGET_PAZZWORD_TXT_FILE;
				BeanUtils.copyProperties(userEntity, usrReg);
				String body = readMailFormTextFile(usrReg, userEntity.getPassword(), fileName);

				utilmails.sendMail(usrReg.getEmail(), AppConstraints.RETRIVE_PAZZWORD_SUBJECT, body);
				message = "Password Sent to Your Given Mail Id..,Please Check";
			} else {
				message = "Your Account is in INACTIVE Mode ..Please Contact Admin.";
			}
		} else {
			message = "Invalid Email ID..Please Enter a valid Email ID...";
		}
		return message;
	}

	@Override
	public String getByEmail(String email) {
		UserRegistrationEntity entity = usrRegRepositeries.getUserByEmail(email);

		if (entity != null) {
			return "DUPLICATE";
		}
		else {
		return "UNIQUE";
		}
	}

}
