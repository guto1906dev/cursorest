package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.State;
import com.guto1906.cursorest.dto.StateDto;
import com.guto1906.cursorest.repositories.StateRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class StateService {

	@Autowired
	private StateRepository repo;

	public List<StateDto> findAll() {
		List<StateDto> list = repo.findAll().stream().map(entity -> new StateDto(entity)).collect(Collectors.toList());
		return list;
	}

	public StateDto findById(Long id) {
		State entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException(
				"Elemento de Id " + id + " não existe, Tipo " + State.class.getName()));
		return new StateDto(entity);
	}

}
