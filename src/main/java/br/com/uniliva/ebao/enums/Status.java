package br.com.uniliva.ebao.enums;

public enum Status {
	ATIVO("ativo"), CANCELADO("cancelado");
	
	private String descricao;

	Status(String descricao) {
        this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
}
