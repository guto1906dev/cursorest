package com.guto1906.cursorest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.domain.enums.TipoClient;

public class ClientDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	private TipoClient tipo;
	private List<AddressDto> addresses = new ArrayList<>();
	private Set<String> phones = new HashSet<>();
	

	public ClientDto() {

	}

	public ClientDto(Long id, String name, String email, String cpfOuCnpj, TipoClient tipo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
		
	}
	
	public ClientDto(Client entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpfOuCnpj = entity.getCpfOuCnpj();
		tipo = entity.getTipo();
		addresses = entity.getAddresses().stream().map(e -> new AddressDto(e)).collect(Collectors.toList());
		phones = entity.getPhones();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoClient getTipo() {
		return tipo;
	}

	public void setTipo(TipoClient tipo) {
		this.tipo = tipo;
	}

	public List<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	
	

	
	
	

}
