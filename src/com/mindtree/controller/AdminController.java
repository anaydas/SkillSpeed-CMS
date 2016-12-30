package com.mindtree.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger=Logger.getLogger(AdminController.class);
	
	@RequestMapping("/")
	public ModelAndView admin(){
		 ModelAndView model = new ModelAndView("admin");
	        model.addObject("title", "Administrator Control Panel");
	        model.addObject("message", "Here You Can Upload Image and Text File");
	        return model;
	}
	

}
