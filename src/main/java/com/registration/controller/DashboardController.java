package com.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.constraints.AppConstraints;

/**
 * This class is to dashboard
 * 
 * @author Pankaj Kumar
 *
 */
@Controller
public class DashboardController {

	/**
	 * This Method is to display dashBoard
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dashboard")
	public String displayDashBoardForm(Model model) {

		return AppConstraints.DASHBOARD_INFO;
	}

}
