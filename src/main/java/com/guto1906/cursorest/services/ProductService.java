package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Product;
import com.guto1906.cursorest.dto.ProductDto;
import com.guto1906.cursorest.repositories.ProductRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<ProductDto> findAll() {

		List<Product> entities = repo.findAll();
		List<ProductDto> list = entities.stream().map(entity -> new ProductDto(entity)).collect(Collectors.toList());

		return list;

	}

	public ProductDto findById(Long id) {
		Product entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Elemento de Id " + id + " não existe, Tipo " + Product.class.getName()));
		ProductDto dto = new ProductDto(entity);
		
		return dto;
	}

}
