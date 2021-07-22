package com.guto1906.cursorest.dto;

import java.io.Serializable;

import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.domain.enums.TipoClient;

public class ClientDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;

	public ClientDto() {

	}

	public ClientDto(Long id, String name, String email, String cpfOuCnpj, TipoClient tipo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
	}

	public ClientDto(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpfOuCnpj = entity.getCpfOuCnpj();
		tipo = entity.getTipo().getCod();

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
		return TipoClient.toEnum(tipo);
	}

	public void setTipo(TipoClient tipo) {
		this.tipo = tipo.getCod();
	}
	
	

}
