/**
 * projeto-springMVC : 29 de ago de 2017
 */
package com.projetoSpringMVC.model;

import java.util.List;

/**
 * @author flavio
 *
 */
public class AjaxResponseBody {
	
	
	private String msg;
	private List<Produto> produtos;
	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}
	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
