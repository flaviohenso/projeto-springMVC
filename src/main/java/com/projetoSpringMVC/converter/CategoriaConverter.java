/**
 * projeto-springMVC : 28 de ago de 2017
 */
package com.projetoSpringMVC.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projetoSpringMVC.model.Categoria;
import com.projetoSpringMVC.repository.Categorias;

/**
 * @author flavio
 *
 */
@Component
public class CategoriaConverter implements Converter<String, Categoria>{

	@Autowired
	private Categorias categorias;
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Categoria convert(String id) {
		
		return categorias.findOne(Long.valueOf(id));
	}

}
