package br.com.zallpy.analisecreditobackend.proposta;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.zallpy.analisecreditobackend.pessoa.Pessoa;
import br.com.zallpy.analisecreditobackend.proposta.enums.LimiteEnum;
import br.com.zallpy.analisecreditobackend.proposta.enums.ResultadoAnaliseEnum;

@Document
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@DBRef
	private Pessoa pessoa;
	private LimiteEnum limite;
	private ResultadoAnaliseEnum resultadoAnalise;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public LimiteEnum getLimite() {
		return limite;
	}
	public void setLimite(LimiteEnum limite) {
		this.limite = limite;
	}
	public ResultadoAnaliseEnum getResultadoAnalise() {
		return resultadoAnalise;
	}
	public void setResultadoAnalise(ResultadoAnaliseEnum resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
	}
	
}
