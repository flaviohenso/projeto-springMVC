/**
 * projeto-springMVC : 17 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author flavio
 *
 */
@Controller
public class DashboardController {
	
	@GetMapping("/index")
	private String home() {
		return "index";
	}

}
