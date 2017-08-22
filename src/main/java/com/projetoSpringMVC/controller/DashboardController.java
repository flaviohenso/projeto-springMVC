/**
 * projeto-springMVC : 17 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author flavio
 *
 */
@Controller
public class DashboardController {
	
	@GetMapping("/index")
	private ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

}
