package br.com.zallpy.analisecreditobackend.pessoa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.zallpy.analisecreditobackend.pessoa.enums.EstadoCivilEnum;
import br.com.zallpy.analisecreditobackend.pessoa.enums.EstadoEnum;
import br.com.zallpy.analisecreditobackend.pessoa.enums.SexoEnum;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

@Document
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String CAMPO_OBRIGATORIO = " é um campo obrigatório";
	
	@Id
	private String id;
	@NotBlank(message = "CPF" + CAMPO_OBRIGATORIO)
	private String cpf;
	@NotBlank(message = "Nome" + CAMPO_OBRIGATORIO)
	private String nome;
	@NotBlank(message = "Idade" + CAMPO_OBRIGATORIO)
	private Integer idade;
	@NotBlank(message = "Sexo" + CAMPO_OBRIGATORIO)
	private SexoEnum sexo;
	@NotBlank(message = "Estado civil" + CAMPO_OBRIGATORIO)
	private EstadoCivilEnum estadoCivilEnum;
	@NotBlank(message = "Estado" + CAMPO_OBRIGATORIO)
	private EstadoEnum estado;
	@NotBlank(message = "Dependentes" + CAMPO_OBRIGATORIO)
	private Integer dependentes;
	@NotBlank(message = "Renda" + CAMPO_OBRIGATORIO)
	private BigDecimal renda;
	
	public Pessoa() {
	}
	
	public Pessoa(String cpf, String nome, Integer idade, SexoEnum sexo, EstadoCivilEnum estadoCivilEnum, EstadoEnum estado,
			Integer dependentes, BigDecimal renda) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.estadoCivilEnum = estadoCivilEnum;
		this.estado = estado;
		this.dependentes = dependentes;
		this.renda = renda;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	public EstadoCivilEnum getEstadoCivilEnum() {
		return estadoCivilEnum;
	}
	public void setEstadoCivilEnum(EstadoCivilEnum estadoCivilEnum) {
		this.estadoCivilEnum = estadoCivilEnum;
	}
	public EstadoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	public Integer getDependentes() {
		return dependentes;
	}
	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}
	public BigDecimal getRenda() {
		return renda;
	}
	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
	
	public Instance getInstanceWekaByDataSet(Instances dataset) {
		Instance instance = new DenseInstance(8);
		instance.setDataset(dataset);
		instance.setValue(0, this.getIdade());
		instance.setValue(1, this.getSexo().name());
		instance.setValue(2, this.getEstadoCivilEnum().name().toLowerCase());
		instance.setValue(3, this.getEstado().name());
		instance.setValue(4, this.getDependentes());
		instance.setValue(5, this.getRenda().doubleValue());
		return instance;
	}
	
}
