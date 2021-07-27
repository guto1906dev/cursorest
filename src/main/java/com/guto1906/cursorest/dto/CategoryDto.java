package com.guto1906.cursorest.dto;

import java.io.Serializable;

import com.guto1906.cursorest.domain.Category;

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



	public CategoryDto(Category category) {
		id = category.getId();
		name = category.getName();
		
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
