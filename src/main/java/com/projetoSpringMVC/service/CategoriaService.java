/**
 * projeto-springMVC : 28 de ago de 2017
 */
package com.projetoSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringMVC.model.Categoria;
import com.projetoSpringMVC.repository.Categorias;

/**
 * @author flavio
 *
 */
@Service
public class CategoriaService {

	@Autowired
	private Categorias categorias;
	
	public List<Categoria> selectCategoria(){
		return categorias.findAll();
	}
	
}
