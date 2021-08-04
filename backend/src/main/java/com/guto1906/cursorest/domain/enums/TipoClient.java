package com.guto1906.cursorest.domain.enums;

public enum TipoClient {

	PESSOAFISICA(1, "Pessoa Físca"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoClient(int cod, String descricao) {

		this.cod = cod;
		this.descricao = descricao;

	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoClient e : TipoClient.values()) {
			if(cod.equals(e.getCod())) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
