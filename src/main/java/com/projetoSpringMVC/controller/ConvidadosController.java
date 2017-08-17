/**
 * projeto-springMVC : 16 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projetoSpringMVC.model.Convidado;
import com.projetoSpringMVC.repository.Convidados;

/**
 * @author flavio
 *
 */
@Controller
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	@GetMapping("/convidados")
	private ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());

		return modelAndView;
	}

	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {

		this.convidados.save(convidado);
		return "redirect:/convidados";
	}

}
