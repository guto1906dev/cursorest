package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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

	@Transactional
	public List<ClientDto> findAll() {
		List<Client> clientes = repo.findAll();
		List<ClientDto> lista = clientes.stream().map(entity -> new ClientDto(entity)).collect(Collectors.toList());
		return lista;
	}

	@Transactional
	public ClientDto findById(Long id) {
		Client entity = repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("Elemento de Id " + id + " não existe, Tipo " + Client.class.getName()));

		return new ClientDto(entity);
	}

}
