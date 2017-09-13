/**
 * projeto-springMVC : 25 de ago de 2017
 */
package com.projetoSpringMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringMVC.model.Produto;

/**
 * @author flavio
 *
 */
public interface Produtos extends JpaRepository<Produto, Long> {

	/**
	 * @param username
	 */
	List<Produto> findAllByNome(String username);

}
