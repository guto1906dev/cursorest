package com.guto1906.cursorest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Category;
import com.guto1906.cursorest.domain.Product;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
		
	public CategoryDto() {

	}
	
	

	public CategoryDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;		
		
	}



	public CategoryDto(Category entity) {
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
