package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Category;
import com.guto1906.cursorest.dto.CategoryDto;
import com.guto1906.cursorest.repositories.CategoryRepository;
import com.guto1906.cursorest.services.exceptions.DataIntegrityException;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Transactional
	public List<CategoryDto> findAll(){
		
		List<Category> entities = repo.findAll();
		List<CategoryDto> list = entities.stream().map(entity -> new CategoryDto(entity)).collect(Collectors.toList());

		return list;

	}

	@Transactional
	public CategoryDto findById(Long id) {
		Category entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Elemento de Id " + id + " não existe, Tipo " + Category.class.getName()));
		CategoryDto dto = new CategoryDto(entity);
		
		return dto;
	}
	
	public CategoryDto insert(CategoryDto dto) {
		Category entity = new Category(null, dto.getName());
		return new CategoryDto(repo.save(entity));		
	}
	
	@Transactional
	public CategoryDto update(CategoryDto dto) {
		findById(dto.getId());
		Category entity = new Category(dto.getId(), dto.getName());
		return new CategoryDto(repo.save(entity));		
	}
	
	@Transactional
	public void delete(Long id) {
		CategoryDto dto = findById(id);
		
		if(dto.getProducts().isEmpty()) {
			repo.deleteById(id);
		} else {
			throw new DataIntegrityException("Não é possível excluir uma categoria com produtos associados.");
		}
		
		
		
	}
	

}
