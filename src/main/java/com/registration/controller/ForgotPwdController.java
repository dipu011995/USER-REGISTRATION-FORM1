package com.registration.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constraints.AppConstraints;
import com.registration.domain.UserLogin;
import com.registration.service.UserRegistrationService;

/**
 * This Class is injected Service. It handel the ForgetPassword related Actions
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class ForgotPwdController {

	@Autowired
	private UserRegistrationService usrRegService;

	/**
	 * This Method display the Forget Password Form Page..
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/forgetPwd", method = RequestMethod.GET)
	public String forgotPassword(Model model) {

		UserLogin usrLogin = new UserLogin();

		model.addAttribute(AppConstraints.USER_LOGIN, usrLogin);

		return AppConstraints.FORGET_PAZZWORD;
	}

	/**
	 * This Method Is to perform changing The Password Action by interacting with
	 * service and send the result message to user consol
	 * 
	 * @param usrLogin
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws MessagingException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("userLogin") UserLogin usrLogin, Model model) throws MessagingException, IOException {
 
		String result = usrRegService.getUserForChangePwd(usrLogin.getEmail());

		model.addAttribute(AppConstraints.RESULT, result);

		return AppConstraints.FORGET_PAZZWORD;

	}

}
