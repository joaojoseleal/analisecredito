package br.com.zallpy.analisecreditobackend.pessoa.enums;

public enum SexoEnum {
	M("Masculino"), F("Feminino");

	private String label;

	SexoEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
