package br.com.zallpy.analisecreditobackend;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.zallpy.analisecreditobackend.pessoa.Pessoa;
import br.com.zallpy.analisecreditobackend.pessoa.enums.EstadoCivilEnum;
import br.com.zallpy.analisecreditobackend.pessoa.enums.EstadoEnum;
import br.com.zallpy.analisecreditobackend.pessoa.enums.SexoEnum;
import br.com.zallpy.analisecreditobackend.proposta.Proposta;
import br.com.zallpy.analisecreditobackend.proposta.PropostaService;
import br.com.zallpy.analisecreditobackend.proposta.enums.LimiteEnum;
import br.com.zallpy.analisecreditobackend.proposta.enums.ResultadoAnaliseEnum;

public class PropostaServiceTest {
	
	private PropostaService propostaService;
	
	@Before
	public void beforeEach() {
		propostaService = new PropostaService();
	}
	
	@Test
	public void lucasAprovadoQuinhentosMil() {
		Pessoa pessoa = new Pessoa("11111111111", "Lucas", 28, SexoEnum.M, EstadoCivilEnum.SOLTEIRO, 
				EstadoEnum.SC, 0, new BigDecimal(2500));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.QUINHENTOS_MIL, proposta.getLimite());
	}
	
	@Test
	public void anaAprovadoCemQuinhentos() {
		Pessoa pessoa = new Pessoa("11111111111", "Ana", 17, SexoEnum.F, EstadoCivilEnum.SOLTEIRO, 
				EstadoEnum.SP, 0, new BigDecimal(1000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.CEM_QUINHENTOS, proposta.getLimite());
	}
	
	@Test
	public void pedroAprovadoMilQuinhentosDoisMil() {
		Pessoa pessoa = new Pessoa("22222222222", "Pedro", 68, SexoEnum.M, EstadoCivilEnum.CASADO, 
				EstadoEnum.SC, 3, new BigDecimal(8000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MILQUINHENTOS_DOISMIL, proposta.getLimite());
	}
	
	@Test
	public void paulaAprovadoMilMilQuinhentos() {
		Pessoa pessoa = new Pessoa("22222222222", "Paula", 61, SexoEnum.F, EstadoCivilEnum.CASADO, 
				EstadoEnum.RJ, 3, new BigDecimal(5000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MIL_MILQUINHENTOS, proposta.getLimite());
	}
	
	@Test
	public void joaoNegadoReprovadoPolitica() {
		Pessoa pessoa = new Pessoa("33333333333", "João", 56, SexoEnum.M, EstadoCivilEnum.DIVORCIADO, 
				EstadoEnum.RJ, 2, new BigDecimal(2000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.NEGADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.REPROVADO_POLITICA, proposta.getLimite());
	}
	
	@Test
	public void mariaReprovadoPolitica() {
		Pessoa pessoa = new Pessoa("22222222222", "Maria", 45, SexoEnum.F, EstadoCivilEnum.DIVORCIADO, 
				EstadoEnum.SP, 1, new BigDecimal(2000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.NEGADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.REPROVADO_POLITICA, proposta.getLimite());
	}
	
	@Test
	public void joseAprovadoMaiorDoisMil() {
		Pessoa pessoa = new Pessoa("44444444444", "José", 30, SexoEnum.M, EstadoCivilEnum.CASADO, 
				EstadoEnum.MA, 2, new BigDecimal(8000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MAIOR_2000, proposta.getLimite());
	}
	
	@Test
	public void dinaeAprovadoMaiorDoisMil() {
		Pessoa pessoa = new Pessoa("55555555555", "Dinae", 33, SexoEnum.F, EstadoCivilEnum.CASADO, 
				EstadoEnum.SP, 1, new BigDecimal(10000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MAIOR_2000, proposta.getLimite());
	}

	@Test
	public void marcosNegadoRendaBaixa() {
		Pessoa pessoa = new Pessoa("44444444444", "Marcos", 19, SexoEnum.M, EstadoCivilEnum.SOLTEIRO, 
				EstadoEnum.SC, 1, new BigDecimal(400));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.NEGADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.RENDA_BAIXA, proposta.getLimite());
	}
	
	@Test
	public void suzanNegadoReprovadoPolitica() {
		Pessoa pessoa = new Pessoa("55555555555", "Suzan", 63, SexoEnum.F, EstadoCivilEnum.VIUVA, 
				EstadoEnum.MA, 3, new BigDecimal(1500));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.NEGADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.REPROVADO_POLITICA, proposta.getLimite());
	}
	
	@Test
	public void luciAprovadoCemQuinhentos() {
		Pessoa pessoa = new Pessoa("55555555555", "Luci", 28, SexoEnum.F, EstadoCivilEnum.SOLTEIRO, 
				EstadoEnum.SC, 2, new BigDecimal(2500));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.CEM_QUINHENTOS, proposta.getLimite());
	}
	
	@Test
	public void robertoNegadoRendaBaixa() {
		Pessoa pessoa = new Pessoa("44444444444", "Roberto", 16, SexoEnum.M, EstadoCivilEnum.SOLTEIRO, 
				EstadoEnum.SP, 0, new BigDecimal(500));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.NEGADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.RENDA_BAIXA, proposta.getLimite());
	}
	
	@Test
	public void brunoAprovadoMilMilQuinhentos() {
		Pessoa pessoa = new Pessoa("44444444444", "Bruno", 30, SexoEnum.M, EstadoCivilEnum.CASADO, 
				EstadoEnum.MA, 5, new BigDecimal(8000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MIL_MILQUINHENTOS, proposta.getLimite());
	}
	
	@Test
	public void arielAprovadoMaiorDoisMil() {
		Pessoa pessoa = new Pessoa("55555555555", "Ariel", 33, SexoEnum.F, EstadoCivilEnum.VIUVA, 
				EstadoEnum.SP, 0, new BigDecimal(10000));
		Proposta proposta = propostaService.gerarProposta(pessoa);
		assertEquals(ResultadoAnaliseEnum.APROVADO, proposta.getResultadoAnalise());
		assertEquals(LimiteEnum.MAIOR_2000, proposta.getLimite());
	}
}
