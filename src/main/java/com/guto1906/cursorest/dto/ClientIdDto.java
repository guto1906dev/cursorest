package com.guto1906.cursorest.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.domain.enums.TipoClient;

public class ClientIdDto extends ClientDto {

	private static final long serialVersionUID = 1L;
	
	private String cpfOuCnpj;
	private Integer tipo;
	private List<AddressDto> addresses = new ArrayList<>();
	private Set<String> phones = new HashSet<>();	
	
	public ClientIdDto() {
		
	}
	
	public ClientIdDto(Long id, String name, String email, String cpfOuCnpj, TipoClient tipo, List<AddressDto> addresses,
			Set<String> phones) {
		super(id, name, email);
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
		this.addresses = addresses;
		this.phones = phones;		
	}
	
	public ClientIdDto(Client entity) {
		super(entity.getId(), entity.getName(), entity.getEmail());
		cpfOuCnpj = entity.getCpfOuCnpj();
		tipo = entity.getTipo().getCod();
		addresses = entity.getAddresses().stream().map(x -> new AddressDto(x)).collect(Collectors.toList());
		phones = entity.getPhones();
		
		}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoClient getTipo() {
		return TipoClient.toEnum(tipo);
	}

	public void setTipo(TipoClient tipo) {
		this.tipo = tipo.getCod();
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
