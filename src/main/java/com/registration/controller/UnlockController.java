package com.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constraints.AppConstraints;
import com.registration.domain.UnlockUserRegistration;
import com.registration.service.UserRegistrationService;

/**
 * This UnlockController is for Unlock the user by changing password
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class UnlockController {

	@Autowired
	private UserRegistrationService usrRegService;

	/**
	 * This Method is bind UserRegistration with model Attribute and display th
	 * unlock_account form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unlockAccount")
	public String displayUnlockForm(HttpServletRequest req, Model model) {

		String email = req.getParameter("email");

		UnlockUserRegistration unlockRegstion = new UnlockUserRegistration();
		unlockRegstion.setEmail(email);

		model.addAttribute(AppConstraints.USER_REGISTRATION, unlockRegstion);

		return AppConstraints.USER_ACCOUNT;
	}

	/**
	 * This class is for update the status and Password
	 * 
	 * @param unlockUsrReg
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/activeAccount", method = RequestMethod.POST)
	public String activeAccount(@ModelAttribute("unlockUsrRegstion") UnlockUserRegistration unlockUsrReg, Model model) {

		boolean flag = usrRegService.activeUserAccount(unlockUsrReg);

		if (flag)
			model.addAttribute(AppConstraints.UNLOCK_SUCESS_RESULT, "Your AccountUnlocked Sucessfully, Please Login..");
		else
			model.addAttribute(AppConstraints.UNLOCK_FAILURE_RESULT, "Invalid Temporary Password Plz.Try Again...");

		return AppConstraints.USER_ACCOUNT;
	}

}
