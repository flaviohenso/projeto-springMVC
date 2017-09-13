/**
 * projeto-springMVC : 29 de ago de 2017
 */
package com.projetoSpringMVC.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author flavio
 *
 */
public class SearchCriteria {
	
	@NotBlank(message = "username can't empty!")
	private String search = "samsung";

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	
}
