/**
 * projeto-springMVC : 25 de ago de 2017
 */
package com.projetoSpringMVC.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringMVC.model.Produto;
import com.projetoSpringMVC.repository.Produtos;

/**
 * @author flavio
 *
 */
@Service
public class ProdutoService {

	@Autowired
	private Produtos produtos;

	/**
	 * 
	 */
	public List<Produto> listarTudo() {
		return produtos.findAll();
	}

	public void salvar(Produto produto) {
		produtos.save(produto);

	}

	public List<Produto> findByProdutoNome(String username) {

		List<Produto> result = produtos.findAllByNome(username).stream().filter(x -> x.getNome().equalsIgnoreCase(username))
				.collect(Collectors.toList());

		return result;

	}

}
