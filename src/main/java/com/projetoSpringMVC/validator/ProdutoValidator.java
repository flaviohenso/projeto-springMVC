package com.projetoSpringMVC.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projetoSpringMVC.model.Produto;

public class ProdutoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sku", "field.required");
		
		Produto produto = (Produto) target;
	}

}
