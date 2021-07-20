package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Categoria;
import com.guto1906.cursorest.dto.CategoriaDto;
import com.guto1906.cursorest.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	
	public List<CategoriaDto> findAll(){
		
		List<Categoria> entities = repo.findAll();		
		List<CategoriaDto> list = entities.stream().map(entity -> new CategoriaDto(entity)).collect(Collectors.toList());
		
		return list;
		
	}
	
	public CategoriaDto findById(Long id) {
		Categoria entity = repo.findById(id).get();
		
		CategoriaDto dto = new CategoriaDto(entity);	
		
		return dto;
	}

}
