package com.guto1906.cursorest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.guto1906.cursorest.domain.Address;
import com.guto1906.cursorest.domain.Client;
import com.guto1906.cursorest.domain.Payment;
import com.guto1906.cursorest.domain.Pedido;

public class PedidoDto {
	
	private Long id;
	private Date instant;
	
	private Payment pagamento;
	
	private ClientDto cliente;
	
	private AddressDto enderecoEntrega;
	
	private List<ProductDto> itens = new ArrayList<>();
	
	
	public PedidoDto() {
		
	}


	public PedidoDto(Long id, Date instant, Payment pagamento, Client cliente, Address enderecoEntrega) {
		super();
		this.id = id;
		this.instant = instant;
		this.pagamento = pagamento;
		this.cliente = new ClientDto(cliente);
		this.enderecoEntrega = new AddressDto(enderecoEntrega);
	}
	
	public PedidoDto(Pedido pedido) {
		super();
		id = pedido.getId();
		instant = pedido.getInstant();
		pagamento = pedido.getPagamento();
		cliente = new ClientDto(pedido.getCliente());
		enderecoEntrega = new AddressDto(pedido.getEnderecoEntrega());		
		itens = pedido.getItens().stream().map(x -> new ProductDto(x.getProduct())).collect(Collectors.toList());
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


	public ClientDto getCliente() {
		return cliente;
	}


	public void setCliente(ClientDto cliente) {
		this.cliente = cliente;
	}


	public AddressDto getEnderecoEntrega() {
		return enderecoEntrega;
	}


	public void setEnderecoEntrega(AddressDto enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}


	public List<ProductDto> getItens() {
		return itens;
	}


	public void setItens(List<ProductDto> itens) {
		this.itens = itens;
	}
	
	
	
	
	
}
