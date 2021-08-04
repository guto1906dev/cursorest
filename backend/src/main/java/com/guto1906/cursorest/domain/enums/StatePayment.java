package com.guto1906.cursorest.domain.enums;

public enum StatePayment {
	
	PEDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private StatePayment(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatePayment toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StatePayment statePayment : StatePayment.values()) {
			if(cod.equals(statePayment.getCod())) {
				return statePayment;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
