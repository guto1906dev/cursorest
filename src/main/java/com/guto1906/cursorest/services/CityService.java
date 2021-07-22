package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.City;
import com.guto1906.cursorest.dto.CityDto;
import com.guto1906.cursorest.repositories.CityRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repo;
	
	public List<CityDto> findAll(){
		List<CityDto> list = repo.findAll().stream()
				.map(entity -> new CityDto(entity)).collect(Collectors.toList());		
		return list;
	}
	
	public CityDto findByid(Long id) {
		City entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Elemento de Id " + id + " não existe, Tipo " + City.class.getName()));		
		return new CityDto(entity);
	}

}
