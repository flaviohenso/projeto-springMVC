/**
 * projeto-springMVC : 23 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoSpringMVC.model.Produto;
import com.projetoSpringMVC.service.CategoriaService;
import com.projetoSpringMVC.service.ProdutoService;
import com.projetoSpringMVC.validator.ProdutoValidator;

/**
 * @author flavio
 *
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	private final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@InitBinder
	protected void InitBinder(WebDataBinder webDataBinder) {
		System.out.println("validando dados!");
		webDataBinder.setValidator(new ProdutoValidator());
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {
			attributes.addFlashAttribute("error", "Erro ao salvar "+result.getObjectName() + " " + result.getAllErrors());
			modelAndView.setViewName("redirect:list");
			return modelAndView;
		}

		produtoService.salvar(produto);
		attributes.addFlashAttribute("sucesso", "Cliente salvo com Sucesso!");
		modelAndView.setViewName("redirect:list");
		return modelAndView;
	}

	@GetMapping("/list")
	public ModelAndView list(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produto/list");

		produtoService.listarTudo();
		modelAndView.addObject("categorias", categoriaService.selectCategoria());
		// modelAndView.addObject(new Produto());
		return modelAndView;
	}

	@GetMapping("/ajax")
	public ModelAndView ajax() {
		ModelAndView modelAndView = new ModelAndView("festa/ajax");
		
		//produtoService.listarTudo();
		//modelAndView.addObject("categorias", categoriaService.selectCategoria());
		// modelAndView.addObject(new Produto());
		return modelAndView;
	}
	
	@PostMapping("/api/search")
	public ModelAndView api() {
		ModelAndView modelAndView = new ModelAndView("festa/ajax");
		logger.info("dentro de /api/search");
		//produtoService.listarTudo();
		//modelAndView.addObject("categorias", categoriaService.selectCategoria());
		// modelAndView.addObject(new Produto());
		return modelAndView;
	}

}
