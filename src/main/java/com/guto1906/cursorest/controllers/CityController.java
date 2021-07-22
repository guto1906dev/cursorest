package com.guto1906.cursorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guto1906.cursorest.dto.CityDto;
import com.guto1906.cursorest.services.CityService;

@RestController
@RequestMapping(value = "/cidades")
public class CityController {
	
	@Autowired
	private CityService service;
	
	@GetMapping
	public ResponseEntity<List<CityDto>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CityDto> findById(@PathVariable(name = "id") Long id){
		
		return ResponseEntity.ok().body(service.findByid(id));
	}

}
