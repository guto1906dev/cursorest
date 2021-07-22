package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.dto.ClientDto;
import com.guto1906.cursorest.repositories.ClientRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public List<ClientDto> findAll() {
		return repo.findAll().stream().map(entity -> new ClientDto(entity)).collect(Collectors.toList());
	}

	public ClientDto findById(Long id) {
		Client entity = repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("Elemento de Id " + id + " não existe, Tipo " + Client.class.getName()));

		return new ClientDto(entity);
	}

}
