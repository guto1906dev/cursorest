package com.guto1906.cursorest.dto;

import java.io.Serializable;

import com.guto1906.cursorest.domain.Address;

public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String publicPlace;
	private String number;
	private String district;
	private String cep;
	private String city;
	
	public AddressDto() {
		
	}

	public AddressDto(Long id, String publicPlace, String number, String district, String cep, CityDto city) {
		super();
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.district = district;
		this.cep = cep;
		this.city = city.getName();
	}
	
	public AddressDto(Address entity) {
		
		id = entity.getId();
		publicPlace = entity.getPublicPlace();
		number = entity.getNumber();
		district = entity.getDistrict();
		cep = entity.getCep();
		city = entity.getCity().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city.getName();
	}
	
	
	
	

}
