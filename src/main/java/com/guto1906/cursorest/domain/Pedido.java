package com.guto1906.cursorest.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date instant;

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	// @PrimaryKeyJoinColumn
	private Payment pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client cliente;

	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id")
	private Address enderecoEntrega;

	public Pedido() {

	}

	public Pedido(Long id, Date instant, Client cliente, Address enderecoEntrega) {
		super();
		this.id = id;
		this.instant = instant;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Payment getPagamento() {
		return pagamento;
	}

	public void setPagamento(Payment pagamento) {
		this.pagamento = pagamento;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Address getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Address enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
