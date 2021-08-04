package com.guto1906.cursorest.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.guto1906.cursorest.domain.Client;

public class ClientDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Campo Obrigatório")
	@Size(min = 5, max = 120, message = "Campo com 5 a 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Campo Obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	public ClientDto() {
		
	}

	public ClientDto(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public ClientDto(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
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
	
	
	
	

}
