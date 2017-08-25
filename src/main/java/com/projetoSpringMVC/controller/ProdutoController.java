/**
 * projeto-springMVC : 23 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author flavio
 *
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@PostMapping("/save")
	public ModelAndView save() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:list");
		return new ModelAndView();
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		return new ModelAndView();
	}
	
}
