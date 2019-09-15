package br.com.zallpy.analisecreditobackend.proposta.enums;

public enum LimiteEnum {
	
	REPROVADO_POLITICA("Reprovado pela Política de crédito"),
	RENDA_BAIXA("Renda Baixa"),
	CEM_QUINHENTOS("100 - 500"),
	QUINHENTOS_MIL("500 - 1000"),
	MIL_MILQUINHENTOS("1000 - 1500"),
	MILQUINHENTOS_DOISMIL("1500 - 2000"),
	MAIOR_2000("Superior 2000");
	
	private String label;
	
	LimiteEnum(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
	
}
