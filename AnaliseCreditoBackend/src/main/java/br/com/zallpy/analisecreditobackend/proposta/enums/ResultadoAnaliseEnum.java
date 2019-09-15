package br.com.zallpy.analisecreditobackend.proposta.enums;

public enum ResultadoAnaliseEnum {
	
	APROVADO("Aprovado"),
	NEGADO("Negado");
	
	private String label;
	
	ResultadoAnaliseEnum(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}
