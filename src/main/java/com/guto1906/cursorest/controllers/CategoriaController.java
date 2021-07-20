package com.guto1906.cursorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guto1906.cursorest.dto.CategoriaDto;
import com.guto1906.cursorest.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> findAll() {
		
		List<CategoriaDto> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDto> findById(@PathVariable Long id) {
		
		CategoriaDto dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	

}
