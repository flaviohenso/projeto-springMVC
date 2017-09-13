/**
 * projeto-springMVC : 28 de ago de 2017
 */
package com.projetoSpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringMVC.model.Categoria;

/**
 * @author flavio
 *
 */
public interface Categorias extends JpaRepository<Categoria, Long> {

}
