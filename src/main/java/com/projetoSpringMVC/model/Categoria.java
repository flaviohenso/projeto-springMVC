package com.projetoSpringMVC.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Categoria subcategorias;
	private List<Produto> produtos;
	
	public Categoria() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Categoria getSubcategorias() {
		return subcategorias;
	}
	
	public void setSubcategorias(Categoria subcategorias) {
		this.subcategorias = subcategorias;
	}
	
	@OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Column(nullable = false, length = 50, unique = true)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
			
		return true;
	}
	
	
	
}
