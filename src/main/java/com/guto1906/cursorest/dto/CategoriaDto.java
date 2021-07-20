package com.guto1906.cursorest.dto;

import java.io.Serializable;

import com.guto1906.cursorest.domain.Categoria;

public class CategoriaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public CategoriaDto() {

	}
	
	

	public CategoriaDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public CategoriaDto(Categoria entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
