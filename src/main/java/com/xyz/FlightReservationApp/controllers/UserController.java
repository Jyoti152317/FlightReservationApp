package com.xyz.FlightReservationApp.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.FlightReservationApp.entity.User;
import com.xyz.FlightReservationApp.repository.UserRepository;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showReg() {
		LOGGER.info("inside showReg()");
//		LOGGER.warn("inside showReg()");
//		LOGGER.error("inside showReg()");
//		LOGGER.debug("inside showReg()");
		return "login/userRegistration";
	}

	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
	}

	@RequestMapping(value = "/saveReg", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		userRepo.save(user);
		modelMap.addAttribute("msg", "saved");
//		return "login/userRegistration";
		return "login/login";
	}

	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		try {
			User user = userRepo.findByEmail(email);
			if (user.getPassword().equals(password) && user.getEmail().equals(email)) {
				return "findFlight";
			} else {
				modelMap.addAttribute("msg", "Invalid user name / password. Please try again!!");
				return "login/login";
			}
		} 
		catch (Exception e) {
			modelMap.addAttribute("msg", "Invalid username / password. Please try again!!");
			return "login/login";
		}

	}
}
