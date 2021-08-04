package com.guto1906.cursorest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Category;

public class CategoryIdDto extends CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProductDto> products = new ArrayList<>();
	
		
	public CategoryIdDto() {

	}
	
	

	public CategoryIdDto(Long id, String name, List<ProductDto> products) {
		super(id, name);
		this.products = products;		
		
	}



	public CategoryIdDto(Category entity) {
		super(entity.getId(), entity.getName());
		products = entity.getProducts().stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
		
		
		
	}

	public List<ProductDto> getProducts() {
		return products;
	}



	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}	
	

}
