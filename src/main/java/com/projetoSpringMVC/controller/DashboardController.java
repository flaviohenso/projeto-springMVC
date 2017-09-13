/**
 * projeto-springMVC : 17 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author flavio
 *
 */
@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	private ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		logger.info("chamou Dashboard");
		return model;
	}
	
	@GetMapping("/dashboard")
	private ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		logger.info("chamou Dashboard");
		return model;
	}

}
