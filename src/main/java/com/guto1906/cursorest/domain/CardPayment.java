package com.guto1906.cursorest.domain;

import javax.persistence.Entity;

import com.guto1906.cursorest.domain.enums.StatePayment;

@Entity
public class CardPayment extends Payment{
	
	private Integer numeroDeParcelas;
	
	public CardPayment() {
		
	}

	public CardPayment(Long id, StatePayment estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	

}
