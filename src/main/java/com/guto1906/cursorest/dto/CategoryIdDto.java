package com.guto1906.cursorest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Category;

public class CategoryIdDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private List<ProductDto> products = new ArrayList<>();
	
		
	public CategoryIdDto() {

	}
	
	

	public CategoryIdDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;		
		
	}



	public CategoryIdDto(Category category) {
		id = category.getId();
		name = category.getName();
		products = category.getProducts().stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
		
		
		
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



	public List<ProductDto> getProducts() {
		return products;
	}



	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}	
	

}
