/**
 * projeto-springMVC : 29 de ago de 2017
 */
package com.projetoSpringMVC.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringMVC.model.AjaxResponseBody;
import com.projetoSpringMVC.model.Produto;
import com.projetoSpringMVC.model.SearchCriteria;
import com.projetoSpringMVC.service.ProdutoService;

/**
 * @author flavio
 *
 */
@RestController
public class SearchController {
	
	@Autowired
	private ProdutoService produtoService;
	

	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
		
		AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<Produto> produtos = produtoService.findByProdutoNome(search.getSearch());
        if (produtos.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setProdutos(produtos);

        return ResponseEntity.ok(result);


	}
}
