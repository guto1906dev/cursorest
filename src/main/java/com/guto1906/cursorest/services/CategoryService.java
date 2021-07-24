package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Category;
import com.guto1906.cursorest.dto.CategoryDto;
import com.guto1906.cursorest.repositories.CategoryRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public List<CategoryDto> findAll(){
		
		List<Category> entities = repo.findAll();
		List<CategoryDto> list = entities.stream().map(entity -> new CategoryDto(entity)).collect(Collectors.toList());

		return list;

	}

	public CategoryDto findById(Long id) {
		Category entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Elemento de Id " + id + " não existe, Tipo " + Category.class.getName()));
		CategoryDto dto = new CategoryDto(entity);
		
		return dto;
	}

}
