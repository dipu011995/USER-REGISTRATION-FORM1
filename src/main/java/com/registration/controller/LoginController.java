package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constraints.AppConstraints;
import com.registration.domain.UserLogin;
import com.registration.entity.UserRegistrationEntity;
import com.registration.service.UserRegistrationService;

/**
 * This Class Handel the Login Related Activities..
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserRegistrationService usrRegService;

	/**
	 * This Method bind the userLogin to form and to display Sign In form.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	private String displaySignInForm(Model model) {

		UserLogin login = new UserLogin();

		model.addAttribute(AppConstraints.LOGININFO, login);

		return AppConstraints.LOGIN_INFO;

	}

	/**
	 * This method to is check Credential for login purpose
	 * 
	 * @param login
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "checkCredential", method = RequestMethod.POST)
	private String checkCrenditial(@ModelAttribute("loginInfo") UserLogin login, Model model) {

		UserRegistrationEntity credEntity = usrRegService.chkCredentialByEmailAndPwd(login);

		if (credEntity != null) {
			if ("ACTIVE".equals(credEntity.getStatus())) {
				return "redirect:/dashboard";
			} else {
				model.addAttribute(AppConstraints.ACC_LOCK_MSG, "Your Account is Locked..Plz Contact Admin");
			}
		}
		else {
			model.addAttribute(AppConstraints.ERROR_MSG,
					"Invalid Credentilas..,Please Enter valid Email Id and Password..");
		}
		return AppConstraints.LOGIN_INFO;

	}
}
