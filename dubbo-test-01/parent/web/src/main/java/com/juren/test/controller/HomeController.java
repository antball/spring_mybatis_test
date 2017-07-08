package com.juren.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juren.iservice.DemoService;
import com.juren.test.model.TUser;
import com.juren.test.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	DemoService demoService;
	
	@Autowired
	IUserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String home(Locale locale, Model model,int page) {
		
//		String s = demoService.sayHello("hello dubbo!!!!");
//		logger.info("------------");
//		logger.info("**********"+s+"***********");
//		logger.info("------------");
		
		TUser user =  userService.getUserById(1);
		logger.info("*********************");
		logger.info("**********"+user.getName()+"***********");
		logger.info("*********************");

		List<TUser> users =  userService.getAllUser(page);
		logger.info("*********************");
		logger.info("**********"+users.size()+"   name:"+users.get(0).getName()+"***********");
		logger.info("*********************");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
