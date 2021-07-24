package com.guto1906.cursorest.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.guto1906.cursorest.domain.enums.StatePayment;

@Entity
public class PaymentWithBankSlip extends Payment{
	
	private Date dataVencimento;
	private Date dataPgamento;
	
	public PaymentWithBankSlip() {
		
	}

	public PaymentWithBankSlip(Long id, StatePayment estado, Pedido pedido, Date dataVencimento, Date dataPgamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPgamento = dataPgamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPgamento() {
		return dataPgamento;
	}

	public void setDataPgamento(Date dataPgamento) {
		this.dataPgamento = dataPgamento;
	}
	
	
	

}
