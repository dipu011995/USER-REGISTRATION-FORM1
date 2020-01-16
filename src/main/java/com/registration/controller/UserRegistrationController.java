package com.registration.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.constraints.AppConstraints;
import com.registration.domain.UserRegistration;
import com.registration.service.UserRegistrationService;

/**
 * This UserRegistrationController Class implementing Service to use service
 * class operation
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService usrRegService;

	/**
	 * This Method bind the UserRegistration with model Attributes. and load User
	 * Registration Form Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup")
	public String displayContactForm(Model model) {
		UserRegistration reg = new UserRegistration();
		model.addAttribute(AppConstraints.REGISTRATION, reg);

		return AppConstraints.REG_FORM;
	}

	/**
	 * This Method get the form data and interact with service to add the user in DB
	 * 
	 * @param reg
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws MessagingException
	 * @throws Exception
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("registration") UserRegistration reg, Model model,
			RedirectAttributes attribute) throws MessagingException, IOException {

		boolean saveUserDetails = usrRegService.saveUserDetails(reg);

		if (saveUserDetails)
			attribute.addFlashAttribute(AppConstraints.SUCESS_RESULT,
					"User Addes Sucessfully...Please Check Your Email Id to Unlock your Registration");
		else
			attribute.addFlashAttribute(AppConstraints.FAILED_RESULT, "User Not Added, Please Try Again...!");
		return AppConstraints.REDIRECT_TO_GET;
	}

	/**
	 * This Method is to sovle DoublePosting Problem
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doublePost", method = RequestMethod.GET)
	public String solveDoublePostin(Model model) {

		UserRegistration reg = new UserRegistration();

		model.addAttribute(AppConstraints.REGISTRATION, reg);

		return AppConstraints.REG_FORM;
	}

	@GetMapping("/findDupEmail")
	public @ResponseBody String CheckUniqueEmail(@RequestParam("emailId") String email) {
//		System.out.println("1  " + email);
		String status = usrRegService.getByEmail(email);
		return status;
	}

}
