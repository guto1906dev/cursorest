package com.guto1906.cursorest.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Address;
import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.domain.enums.TipoClient;
import com.guto1906.cursorest.dto.ClientDto;
import com.guto1906.cursorest.dto.ClientIdDto;
import com.guto1906.cursorest.dto.ClientInsertDto;
import com.guto1906.cursorest.repositories.AddressRepository;
import com.guto1906.cursorest.repositories.CityRepository;
import com.guto1906.cursorest.repositories.ClientRepository;
import com.guto1906.cursorest.services.exceptions.DataIntegrityException;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;

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
		ClientDto dto = new ClientIdDto(entity);

		return dto;
	}
	
	@Transactional
	public ClientDto update(ClientDto dto) {
		findById(dto.getId());
		Client entity = repo.getById(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		return new ClientIdDto(repo.save(entity));
	}
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		Client entity = repo.getById(id);
		if(entity.getPedidos().isEmpty()) {
			repo.delete(entity);
		} else {
			throw new DataIntegrityException("Não é possível excluir, há pedidos vinculados");
		}
	}
	
	@Transactional
	public ClientDto insert(ClientInsertDto insertDto) {
		Client client = new Client(null, insertDto.getName(), insertDto.getEmail(),insertDto.getCpfOuCnpj(), TipoClient.toEnum(insertDto.getTipo()));
		client.getPhones().add(insertDto.getPhone1());
		if(insertDto.getPhone2() != null) {
			client.getPhones().add(insertDto.getPhone2());
		}
		if(insertDto.getPhone3() != null) {
			client.getPhones().add(insertDto.getPhone2());
		}
		Address address = new Address(
				null,
				insertDto.getPublicPlace(),
				insertDto.getNumber(),
				insertDto.getDistrict(),
				insertDto.getCep(),
				client,
				cityRepository.getById(insertDto.getCityId())
				);
		client  = repo.save(client);
		addressRepository.save(address);
		
		ClientDto dto = findById(client.getId());
		
		
		return dto;
	}
	
	

}
