/**
 * projeto-springMVC : 16 de ago de 2017
 */
package com.projetoSpringMVC.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author flavio
 *
 */
@Entity
public class Convidado implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer quantidadeConvidado;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the quantidadeConvidado
	 */
	public Integer getQuantidadeConvidado() {
		return quantidadeConvidado;
	}
	/**
	 * @param quantidadeConvidado the quantidadeConvidado to set
	 */
	public void setQuantidadeConvidado(Integer quantidadeConvidado) {
		this.quantidadeConvidado = quantidadeConvidado;
	}
	
}
